//*********************************************************************************
// class jephem.astro.planets.vsop87.VSOP87
// Software released under the General Public License (version 2 or later), available at
// http://www.gnu.org/copyleft/gpl.html
//*********************************************************************************

package jephem.astro.solarsystem.vsop87;

import jephem.astro.solarsystem.PlanetaryTheory;
import jephem.astro.solarsystem.SolarSystemConstants;
import jephem.astro.solarsystem.ComputationException;
import jephem.astro.Body;
import jephem.astro.AstroException;
import jephem.astro.spacetime.SpaceConstants;
import jephem.astro.spacetime.Time;
import jephem.astro.spacetime.TimeConstants;
import jephem.astro.spacetime.UnitsConstants;

import tig.maths.Maths;
import tig.maths.Vector3;
import tig.GeneralConstants;

import java.lang.reflect.Method;
import java.io.*;
/******************************************************************************
Low-level class performing calculations of planet coordinates from VSOP87 theory,

@author Thierry Graff.
@history nov 26 2000 : Creation
@history dec 17 2000 : Integration to the rest of JEphem.
@history aug 15 2001 : In calcCoord(), replaced 'filter' parameter by 'precision' ; implemented Exception mechanism
@history nov 14 2001 : Adapted the code to the evolution of other parts of the API.
@history feb 10 2002 : Adapted to load the data from binary files.
                       Introduced _dataFull and _dataJEphem (to load data only when necessary);

@todo internationalize error messages.
@todo handle correctly precision.
@todo see why XEphem coefs are different from BDL;
@todo in calcCoord : check date and precision validity
*********************************************************************************/
public abstract class VSOP87
    implements PlanetaryTheory, SolarSystemConstants, GeneralConstants, TimeConstants{

  //=================================================================================
  //                   STATIC VARIABLES
  //=================================================================================

  private static final int NB_PLANETS = 8;
  // _data[iBody][iTerm][iABC]
  /** Contains the terms of full precision version. */
  private static double[][][] _dataFull = new double[NB_PLANETS][][];
  /** Contains the terms of full version truncated using JEphem truncation. */
  private static double[][][] _dataJEphem = new double[NB_PLANETS][][];

  /** Path to the directory where VSOP87 files are stored (for full precision version). */
  private static String _dataPath;

  //=================================================================================
  //                     CONSTANTS
  //=================================================================================
  // For constants nbTerms and totalTerms, see at the end of class

  /** VSOP Version used to do the computation */
  private static final String VSOP87_VERSION = "A";

  /** Strings used to build the filenames and class to retrieve the data */
  private static final String FILENAME_PREFIX = "DataVSOP87" + VSOP87_VERSION + "_Full_";
  private static final String CLASSNAME_PREFIX = "jephem.astro.planets.vsop87.DataVSOP87"
                                               + VSOP87_VERSION + "_JEphem_";
  private static final String STR_DATA = "data";

  /** Max degree of time */
  private static final int ALPHA_MAX	= 5;
  /** Nb of coordinates */
  private static final int NB_COORDS	= 3;

  /** Semimajor axes; only for VSOP87 planets; for precision control.
      Positions in the array must correspond to SolarSystemConstants constants. */
  private static final double[] a0 = {0.0, 0.0, 0.3871, 0.7233, 1.0000, 1.5237,
                                5.2026, 9.5547, 19.2181, 30.1096};

  /** Planet names used for naming data files or classes ; these names are local to VSOP87.
  <BR>Their range in the array correspond to constants of
  <CODE>jephem.astro.SolarSystemConstants</CODE>.*/
  private static final String[] planetNames	= {"", "", "Mercury", "Venus", "Earth", "Mars",
                                               "Jupiter", "Saturn", "Uranus", "Neptune"};

  //*************************************************************
  // ******* Variables for precision and validity dates. ********
  //*************************************************************

  /** Represents the best precision the truncated version can reach. */
  private static final double LIMIT_TRUNCATED_PRECISION = 4.0;

  /** Initial time of validity */
  private static final double[] ti;
  /** Final time of validity */
  private static final double[] tf;
  /** Precision at final time of validity */
  private static final double[] pNow;
  /** Precision at initial and final times of validity */
  private static final double pLim = 1; // arc second
  static{
    // took J2000 and 365250 days per millenium
    double M6000 = 260045; // J2000 - 6000 years
    double M4000 = 990545; // J2000 - 4000 years
    double M2000 = 1721045; // J2000 - 2000 years
    double P2000 = 3182045; // J2000 + 2000 years
    double P4000 = 3912545; // J2000 + 4000 years
    double P6000 = 4643045; // J2000 + 6000 years
    // for all the arrays, the two first values are meaningless
    // this permits to use them with SolarSystem constants.
    ti = new double[]{0, 0, M4000, M4000, M4000, M4000, M2000, M2000, M6000, M6000};
    tf = new double[]{0, 0, P4000, P4000, P4000, P4000, P2000, P2000, P6000, P6000};
    pNow = new double[]{0, 0, 0.001, 0.006, 0.005, 0.023, 0.020, 0.100, 0.016, 0.030};
  };

  //=================================================================================
  //                                 PUBLIC METHODS
  //=================================================================================

  //******************* getPrecision *************
  // (implementation of PlanetaryTheory)
  /** Returns the precision of VSOP87 for a given body and a given julian day. */
  public static double getPrecision(int bodyIndex, double jd){
    if (bodyIndex < MERCURY || bodyIndex > NEPTUNE)
      throw new IllegalArgumentException("'bodyIndex' not valid - doesn't represent a body computed by VSOP87");

    if(jd >= JD1900 || jd <= JD2100)
      return pNow[bodyIndex];
    else if(jd < JD1900){
      double a = (pLim - pNow[bodyIndex]) / (ti[bodyIndex] - JD1900);
      return a * jd + pLim - a*ti[bodyIndex];
    }
    else{ // jd > 2100
      double a = (pLim - pNow[bodyIndex]) / (tf[bodyIndex] - JD2100);
      return a * jd + pLim - a*tf[bodyIndex];
    }
  }// end getPrecision

  //******************* setDataPath *************
  /** Sets the path where the VSOP87 files are located ; MUST be called before using VSOP87. */
  public static void setDataPath(String dataPath){
    _dataPath = dataPath;
  }// end setDataPath

  //******************* calcCoord(jd, body, precision, velocities) *************
  // This method only know how to perform the summations.
  // Choice of data depending on the precision, loading of data are handled by getData() end getNbTerms()
  /** Calculation of planetary positions, from Mercury to Neptune, using VSOP87 theory.
  <BR>If the date asked for the computation is not handled by VSOP87 theory or if parameter 'precision' can't be
  handled by the theory, a {@link jephem.astro.Body#setComputationException(ComputationException)} is called.
  @param jd julian date ; time scale : dynamical time TDB.
  @param body Index of the planet to calculate (using constants of
  {@link jephem.astro.solarsystem.SolarSystemConstants}).
  @param prec Precision required for calculations (in arc seconds).
  @param velocities Flag indicating if velocities must be also calculated.

  @throws AstroException if an IO or reflection error occurs.
  */
  public static void calcCoord(double jd, Body body, double precision, boolean velocities) throws AstroException{
    try{
      // Check validity of parameters
      int iBody = body.getIndex();
      if (iBody < MERCURY || iBody > NEPTUNE)
        throw new IllegalArgumentException("'body' not valid : '" + iBody + "' doesn't represent a body computed by VSOP87");
      if(precision < 0)
        throw new IllegalArgumentException("'precision' must be positive");

      // ComputationException checking
      if(precision < getPrecision(iBody, jd))
        body.setComputationException(new ComputationException(ComputationException.PRECISION_ERROR,
                                                              iBody, jd, TimeConstants.TT_TDB));
      if(jd > JD2000 + getValidityInterval(iBody) || jd < JD2000 - getValidityInterval(iBody))
        body.setComputationException(new ComputationException(ComputationException.DATE_LIMIT_ERROR,
                                                              iBody, jd, TimeConstants.TT_TDB));

      int[][] nbTerms = null;
      double[][] data = null;
      data = getData(iBody, precision);
      nbTerms = getNbTerms(iBody, precision);

      int coord, alpha, n;                            // index variables
      int nbegin, nend;                               // limit of index n
      double p, q;                                    // for precision control
      double prec = 0.0;
      double a=0, b=0, c=0, arg, term, termdot;       // for term calculation
      double res[] = {0.0, 0.0, 0.0, 0.0, 0.0, 0.0};  // to stock results
      int i;                                          // used sevral times.

      // Time and its powers ; t[i] = t^i
      double[] t = new double[ALPHA_MAX + 1];
      double[] t_abs = new double[ALPHA_MAX + 1];
      t[0] = 1;
      t[1] = (jd - JD2000)/DAYS_PER_MILLENIUM;
      for (i = 2; i<= ALPHA_MAX; i++) t[i] = t[i-1] * t[1];
      for (i = 0; i <= ALPHA_MAX; ++i) t_abs[i] = Math.abs(t[i]);

      // Precision control
      q = Math.max(3.0, -Maths.log10(prec + 1e-50));
      //System.out.println("q = " + q);

      // *** Term summation ***
      nbegin = 0;
      // for each coordinate (order : X, Y, Z)
      for (coord = 0; coord < NB_COORDS; coord++){

        // sum on the powers of time
        for (alpha = 0 ; alpha <= ALPHA_MAX ; alpha ++){

            // reduce threshold progressively for higher precision
            p = a0[iBody] * prec / 10.0 / (q-2) /
                (t_abs[alpha] + alpha * (alpha>0 ? t_abs[alpha-1] : 0.0) * 1e-4 + 1e-50);
            //System.out.println("p = " + p);

          nend = nbTerms[coord][alpha];
          if (nend == 0)
            continue; // no term for this couple (coord, alpha)
          nend += nbegin;

          term = termdot = 0.0;

          // summation of terms for this couple (coord, alpha)
          for (n = nbegin ; n < nend ; n++){
            a = data[n][0];
            if (a < p) continue;	// ignore small terms
            b = data[n][1];
            c = data[n][2];
            arg = b + c * t[1];
            term += a * Math.cos(arg);
            if (velocities) termdot += -c * a * Math.sin(arg);
          }// end for n

          res[coord] += t[alpha] * term;
          if (velocities) res[coord + NB_COORDS] += t[alpha] * termdot
                          + ((alpha > 0) ? alpha * t[alpha - 1] * term : 0.0);
          nbegin = nend;

        }// end for alpha

      }// end for coord

      // convert millenium rate to day rate
      if (velocities)
        for (i = 3; i < 6; ++i) res[i] /= DAYS_PER_MILLENIUM;

      // Set the fields of Body
      body.setFrame(SpaceConstants.FRAME_THEORY);
      body.setCoordinateExpression(SpaceConstants.CARTESIAN);
      body.setPositionUnits(UnitsConstants.UNITGROUP_AU_AU_AU);
      if (velocities) body.setVelocityUnits(UnitsConstants.UNITGROUP_AUD_AUD_AUD);
      body.setPositionCoords(res[0], res[1], res[2]);
      if (velocities) body.setVelocityCoords(res[3], res[4], res[5]);
    }
    catch(Exception e){
      throw new AstroException(e);
    }
  }// end calcCoord(jd, body, precision, velocities)

  //=================================================================================
  //                                 PRIVATE METHODS
  //=================================================================================

  //******************* getValidityInterval *************
  /** Returns the validity interval of VSOP87 for a given body, in days.
  The theory is valid from J2000 - interval to J2000 + interval
  */
  private static double getValidityInterval(int bodyIndex){
    switch(bodyIndex){
      case MERCURY:
      case VENUS:
      case EARTH:
      case MARS:
        return 1461000;// 4000 years
      case JUPITER:
      case SATURN:
        return 730500; // 2000 years
      case URANUS:
      case NEPTUNE:
        return 2191500; // 6000 years
      default:
        throw new IllegalArgumentException("'bodyIndex' not valid - doesn't represent a body computed by VSOP87");
    }
  }// end getValidityInterval

  //******************* getData(iBody, precision) *************
  // Choice of data depending on the precision, loading of data are handled by getData() end getNbTerms()
  /** Returns the terms for a given body ;
  param iBody Index of a body, using <CODE>jephem.astro.SolarSystemConstants</CODE> constants.
  */
  private static double[][] getData(int iBody, double precision) throws AstroException{
    if (_dataPath == null){
      throw new AstroException("Before Using VSOP87, you must indicate where VSOP data are located with setDataPath()");
    }

    double[][] data; // returned value

    try{
      // 1 - Not in applet context - data retrieved from binary files
      if(precision < LIMIT_TRUNCATED_PRECISION){
        if (_dataFull[iBody - MERCURY] == null){
          // need to fill data from binary files
          ObjectInputStream  ois = new ObjectInputStream(new FileInputStream(_dataPath + FILENAME_PREFIX + planetNames[iBody]));
          int totalTerms = getTotalTerms(iBody, precision);
          data = new double[totalTerms][3]; // 3 for A, B and C
          for (int i = 0; i < totalTerms; i++){
            data[i][0] = ois.readDouble();
            data[i][1] = ois.readDouble();
            data[i][2] = ois.readDouble();
          }// end for
          ois.close();
          // put data in static variable
          _dataFull[iBody - MERCURY] = data;
        }
        else{ // Already loaded, nothing to do
          data = _dataFull[iBody - MERCURY];
        }
      }// end if(precision < LIMIT_TRUNCATED_PRECISION)
      else{
        if (_dataJEphem[iBody - MERCURY] == null){
          // data[][] must be retrieved from a data class
          // Use reflection, as we don't know which data class to use until execution time.
          Class dataClass = Class.forName(CLASSNAME_PREFIX + planetNames[iBody]);
          data = (double[][])dataClass.getDeclaredField(STR_DATA).get(null);
        // put data in static variable
        _dataJEphem[iBody - MERCURY] = data;
        }
        else{ // Already loaded, nothing to do
          data = _dataJEphem[iBody - MERCURY];
        }
      }
      // return results
      return data;
    }
    catch (Exception e) {
      throw new AstroException(e);
    }

  }// end getData

  //**********************************************************
  /** Returns the nb of terms for a planet - use : nbTerms[iCoord][iAlpha]*/
  private static int[][] getNbTerms(int iBody, double precision) throws Exception{
    // reflection not used as slower (17%)
    if(precision < LIMIT_TRUNCATED_PRECISION){
      switch(iBody){
        case MERCURY : return nbTerms_A_Full_Mercury;
        case VENUS : return nbTerms_A_Full_Venus;
        case EARTH : return nbTerms_A_Full_Earth;
        case MARS : return nbTerms_A_Full_Mars;
        case JUPITER : return nbTerms_A_Full_Jupiter;
        case SATURN : return nbTerms_A_Full_Saturn;
        case URANUS : return nbTerms_A_Full_Uranus;
        case NEPTUNE : return nbTerms_A_Full_Neptune;
      }
    }
    else{
      switch(iBody){
        case MERCURY : return nbTerms_A_JEphem_Mercury;
        case VENUS : return nbTerms_A_JEphem_Venus;
        case EARTH : return nbTerms_A_JEphem_Earth;
        case MARS : return nbTerms_A_JEphem_Mars;
        case JUPITER : return nbTerms_A_JEphem_Jupiter;
        case SATURN : return nbTerms_A_JEphem_Saturn;
        case URANUS : return nbTerms_A_JEphem_Uranus;
        case NEPTUNE : return nbTerms_A_JEphem_Neptune;
      }
    }
    throw new IllegalArgumentException("'body' parameter incorrect");
  }// end getNbTerms

  //**********************************************************
  /** Returns the total nb of terms for a planet. */
  private static int getTotalTerms(int iBody, double precision) throws Exception{
    // reflection not used as slower (17%)
    if(precision < LIMIT_TRUNCATED_PRECISION){
      switch(iBody){
        case MERCURY : return totalTerms_A_Full_Mercury;
        case VENUS : return totalTerms_A_Full_Venus;
        case EARTH : return totalTerms_A_Full_Earth;
        case MARS : return totalTerms_A_Full_Mars;
        case JUPITER : return totalTerms_A_Full_Jupiter;
        case SATURN : return totalTerms_A_Full_Saturn;
        case URANUS : return totalTerms_A_Full_Uranus;
        case NEPTUNE : return totalTerms_A_Full_Neptune;
      }
    }
    else{
      switch(iBody){
        case MERCURY : return totalTerms_A_JEphem_Mercury;
        case VENUS : return totalTerms_A_JEphem_Venus;
        case EARTH : return totalTerms_A_JEphem_Earth;
        case MARS : return totalTerms_A_JEphem_Mars;
        case JUPITER : return totalTerms_A_JEphem_Jupiter;
        case SATURN : return totalTerms_A_JEphem_Saturn;
        case URANUS : return totalTerms_A_JEphem_Uranus;
        case NEPTUNE : return totalTerms_A_JEphem_Neptune;
      }
    }
    throw new IllegalArgumentException("'body' parameter incorrect");
  }// end getTotalTerms

  //=================================================================================
  //                     CONSTANTS
  //=================================================================================


  //***********************************************************************
  // Number of terms for version A, when generated with "JEPHEM" filter
  //***********************************************************************
  private static final int[][] nbTerms_A_JEphem_Mercury = {
    {25, 11, 8, 7, 1, 0},
    {26, 11, 8, 7, 2, 0},
    {10, 7, 6, 4, 2, 0}
  }; // end nbTerms_A_JEphem_Mercury[][]
  private static final int totalTerms_A_JEphem_Mercury = 135;

  private static final int[][] nbTerms_A_JEphem_Venus = {
    {85, 40, 22, 4, 4, 3},
    {84, 42, 22, 4, 4, 3},
    {30, 17, 6, 3, 3, 2}
  }; // end nbTerms_A_JEphem_Venus[][]
  private static final int totalTerms_A_JEphem_Venus = 378;

  private static final int[][] nbTerms_A_JEphem_Earth = {
    {57, 28, 13, 6, 4, 1},
    {57, 28, 13, 6, 4, 1},
    {3, 4, 3, 3, 2, 1}
  }; // end nbTerms_A_JEphem_Earth[][]
  private static final int totalTerms_A_JEphem_Earth = 234;

  private static final int[][] nbTerms_A_JEphem_Mars = {
    {128, 106, 65, 32, 16, 11},
    {128, 106, 65, 32, 16, 11},
    {34, 20, 10, 7, 4, 2}
  }; // end nbTerms_A_JEphem_Mars[][]
  private static final int totalTerms_A_JEphem_Mars = 793;

  private static final int[][] nbTerms_A_JEphem_Jupiter = {
    {57, 48, 32, 13, 8, 4},
    {56, 47, 32, 13, 8, 4},
    {18, 11, 6, 3, 0, 0}
  }; // end nbTerms_A_JEphem_Jupiter[][]
  private static final int totalTerms_A_JEphem_Jupiter = 360;

  private static final int[][] nbTerms_A_JEphem_Saturn = {
    {77, 48, 30, 21, 13, 5},
    {76, 49, 31, 21, 13, 5},
    {23, 15, 11, 8, 3, 0}
  }; // end nbTerms_A_JEphem_Saturn[][]
  private static final int totalTerms_A_JEphem_Saturn = 449;

  private static final int[][] nbTerms_A_JEphem_Uranus = {
    {75, 58, 41, 28, 8, 0},
    {73, 59, 40, 31, 8, 0},
    {19, 11, 5, 2, 0, 0}
  }; // end nbTerms_A_JEphem_Uranus[][]
  private static final int totalTerms_A_JEphem_Uranus = 458;

  private static final int[][] nbTerms_A_JEphem_Neptune = {
    {25, 15, 8, 5, 0, 0},
    {23, 15, 7, 5, 0, 0},
    {13, 5, 1, 1, 0, 0}
  }; // end nbTerms_A_JEphem_Neptune[][]
  private static final int totalTerms_A_JEphem_Neptune = 123;

  //***********************************************************************
  // Number of terms for version A, when generated with "FULL" filter
  //***********************************************************************

  private static final int[][] nbTerms_A_Full_Mercury = {
    {1449, 792, 299, 54, 15, 10},
    {1438, 782, 299, 59, 15, 10},
    {598, 351, 143, 28, 10, 7}
  }; // end nbTerms_A_Full_Mercury[][]
  private static final int totalTerms_A_Full_Mercury = 6359;

  private static final int[][] nbTerms_A_Full_Venus = {
    {548, 338, 99, 5, 4, 3},
    {565, 325, 99, 5, 4, 3},
    {190, 108, 45, 10, 3, 3}
  }; // end nbTerms_A_Full_Venus[][]
  private static final int totalTerms_A_Full_Venus = 2357;

  private static final int[][] nbTerms_A_Full_Earth = {
    {843, 491, 204, 18, 15, 6},
    {854, 496, 202, 17, 15, 6},
    {178, 120, 53, 12, 6, 2}
  }; // end nbTerms_A_Full_Earth[][]
  private static final int totalTerms_A_Full_Earth = 3538;

  private static final int[][] nbTerms_A_Full_Mars = {
    {1584, 956, 387, 135, 41, 21},
    {1612, 969, 384, 136, 44, 21},
    {355, 232, 122, 51, 16, 7}
  }; // end nbTerms_A_Full_Mars[][]
  private static final int totalTerms_A_Full_Mars = 7073;

  private static final int[][] nbTerms_A_Full_Jupiter = {
    {1055, 488, 255, 140, 58, 11},
    {1037, 499, 259, 136, 60, 11},
    {216, 104, 65, 27, 10, 3}
  }; // end nbTerms_A_Full_Jupiter[][]
  private static final int totalTerms_A_Full_Jupiter = 4434;

  private static final int[][] nbTerms_A_Full_Saturn = {
    {1652, 892, 481, 215, 87, 31},
    {1658, 917, 465, 201, 88, 32},
    {420, 217, 87, 44, 19, 6}
  }; // end nbTerms_A_Full_Saturn[][]
 private static final int totalTerms_A_Full_Saturn = 7512;

  private static final int[][] nbTerms_A_Full_Uranus = {
    {1464, 649, 249, 84, 12, 0},
    {1447, 659, 255, 80, 12, 0},
    {235, 98, 33, 12, 0, 0}
  }; // end nbTerms_A_Full_Uranus[][]
  private static final int totalTerms_A_Full_Uranus = 5289;

  private static final int[][] nbTerms_A_Full_Neptune = {
    {772, 330, 102, 33, 7, 0},
    {746, 325, 97, 34, 7, 0},
    {133, 37, 11, 2, 0, 0}
  }; // end nbTerms_A_Full_Neptune[][]
  private static final int totalTerms_A_Full_Neptune = 2636;

  //=================================================================================
  //                     BUILD (to comment after execution)
  //=================================================================================
/*
  public static void main(String[] args){
    buildTotalNbTerms();
  }// end main

  private static void buildTotalNbTerms(){
    try{
      int[][] nbTerms;
      int total, i, j, k;

      String[] strFilter = {"Full", "JEphem"};
      for(k = 0; k < 2; k++){
        System.out.println(strFilter[k]);
        Class dataClass = Class.forName("jephem.astro.planets.vsop87.VSOP87");
        for (int iBody = 0; iBody < NB_PLANETS; iBody++){
          nbTerms = (int[][])dataClass.getDeclaredField("nbTerms_A_" + strFilter[k] + "_" + planetNames[iBody + MERCURY]).get(null);
          total = 0;
          for(i = 0; i < NB_COORDS; i++){
            for(j = 0; j <= ALPHA_MAX; j++){
              total += nbTerms[i][j];
            }
          }
          System.out.println("  private static final int totalTerms_A_" + strFilter[k] + "_" + planetNames[iBody + MERCURY] + " = " + total + ";");
        } // iBody
      } // k
    }
    catch(Exception e){
      e.printStackTrace();
    }
  } // end buildTotalNbTerms
*/
} //end class VSOP87