//*********************************************************************************
// class jephem.astro.solarsystem.ELP82
// Software released under the General Public License (version 2 or later), available at
// http://www.gnu.org/copyleft/gpl.html
//*********************************************************************************

package jephem.astro.solarsystem;

import jephem.astro.AstroException;
import jephem.astro.Body;
import jephem.astro.solarsystem.ComputationException;
import jephem.astro.solarsystem.SolarSystemConstants;
import jephem.astro.solarsystem.PlanetaryTheory;
import jephem.astro.spacetime.SpaceConstants;
import jephem.astro.spacetime.TimeConstants;
import jephem.astro.spacetime.UnitsConstants;

import tig.Formats;
import tig.maths.Maths;
import tig.maths.Vector3;

import java.lang.reflect.Method;
import java.io.*;
/******************************************************************************
Calculation of the Moon coordinates with ELP-2000 82B theory.

@author Thierry Graff.
@history aug 18 2001 : creation

@todo handle AstroException
@todo handle Exception propagation in loadData()
*********************************************************************************/
public class ELP82 implements PlanetaryTheory{

  // Implementation with exactly the notations of fortran file elp82_1.

  //*********************************************************************************
  //*************************** INSTANCE VARIABLES **********************************
  //*********************************************************************************
  private double    _jd;
  private Body      _body;
  private double    _precision;
  private boolean   _velocities;
  private double[]  _pre; // array for precision.

  /** Time and its powers ; _t[i] = t^i */
  private double[] _t;

  //*********************************************************************************
  //********************************** CONSTANTS ************************************
  //*********************************************************************************

  //*********************************************************************************
  // 1 - Variables for calculations ; notations of fortran file elp82_1
  //*********************************************************************************

  /** Number of coordinates. */
  private final static int NB_COORD = 3;

  /** Max degree of time. */
  private static final int MAXALPHA	= 4;

  /** Same notations as in the original files. */
  private static final double cpi   = Math.PI;
  private static final double cpi2  = Maths.TWOPI;
  private static final double pis2  = cpi / 2.0;
  private static final double rad   = 648000.0 / cpi;
  private static final double deg   = cpi / 180.0;
  private static final double c1    = 60.0;
  private static final double c2    = 3600.0;
  private static final double ath   = 384747.9806743165;
  private static final double a0    = 384747.9806448954;
  private static final double am    = 0.074801329518;
  private static final double alfa  = 0.002571881335;
  private static final double dtasm = 2.0*alfa/(3.0*am);

  // Lunar arguments
  private static final double[][] w = new double[3][5];
  static{
    // terms for W1
    w[0][0] = (218.0 + 18.0/c1 + 59.95571/c2)*deg;
    w[0][1] = 1732559343.73604/rad;
    w[0][2] = -5.8883/rad;
    w[0][3] = 0.6604E-2/rad;
    w[0][4] = -0.3169E-4/rad;
    // terms for W2
    w[1][0] = (83.0 + 21.0/c1 + 11.67475/c2)*deg;
    w[1][1] = 14643420.2632/rad;
    w[1][2] = -38.2776/rad;
    w[1][3] = -0.45047E-1/rad;
    w[1][4] = 0.21301E-3/rad;
    // terms for W3
    w[2][0] = (125.0 + 2.0/c1 + 40.39816/c2)*deg;
    w[2][1] = -6967919.3622/rad;
    w[2][2] = 6.3622/rad;
    w[2][3] = 0.7625E-2/rad;
    w[2][4] = -0.3586E-4/rad;
  }
  private static final double[] eart = new double[5];
  static{
    eart[0] = (100.0 + 27.0/c1 + 59.22059/c2)*deg;
    eart[1] = 129597742.2758/rad;
    eart[2] = -0.0202/rad;
    eart[3] = 0.9E-5/rad;
    eart[4] = 0.15E-6/rad;
  }
  private static final double[] peri = new double[5];
  static{
    peri[0] = (102.0 + 56.0/c1 + 14.42753/c2)*deg;
    peri[1] = 1161.2283/rad;
    peri[2] = 0.5327/rad;
    peri[3] = -0.138E-3/rad;
    peri[4] = 0.0;
  }

  // Precession constant
  private static final double preces = 5029.0966/rad;

  // Planetary arguments
  private static final double[][] p = new double[8][2];
  static{
    //Mercury
    p[0][0] = (252.0 + 15.0/c1 + 3.25986/c2)*deg;
    p[0][1] = 538101628.68898/rad;
    //Venus
    p[1][0] = (181.0 + 58.0/c1 + 47.28305/c2)*deg;
    p[1][1] = 210664136.43355/rad;
    // Earth
    p[2][0] = eart[0];
    p[2][1] = eart[1];
    // Mars
    p[3][0] = (355.0 + 25.0/c1 + 59.78866/c2)*deg;
    p[3][1] = 68905077.59284/rad;
    // Jupiter
    p[4][0] = (34.0 + 21.0/c1 + 5.34212/c2)*deg;
    p[4][1] = 10925660.42861/rad;
    // Saturn
    p[5][0] = (50.0 + 4.0/c1 + 38.89694/c2)*deg;
    p[5][1] = 4399609.65932/rad;
    // Uranus
    p[6][0] = (314.0 + 3.0/c1 + 18.01841/c2)*deg;
    p[6][1] = 1542481.19393/rad;
    // Neptune
    p[7][0] = (304.0 + 20.0/c1 + 55.19575/c2)*deg;
    p[7][1] = 786550.32074/rad;
  }

  // Corrections of the constants (fit to DE200/LE200).
  private static final double delnu = +0.55604/rad/w[0][1];
  private static final double dele  = +0.01789/rad;
  private static final double delg  = -0.08066/rad;
  private static final double delnp = -0.06424/rad/w[0][1];
  private static final double delep = -0.12879/rad;

  // Delaunay's arguments.
  private static final double[][] del = new double[4][5];
  static{
    for (int i = 0; i < 5; i++){
      del[0][i] = w[0][i]-eart[i];
      del[1][i] = eart[i]-peri[i];
      del[2][i] = w[0][i]-w[1][i];
      del[3][i] = w[0][i]-w[2][i];
    }
    del[0][0] = del[0][0] + cpi;
  }

  // zeta.
  private static final double[] zeta = new double[2];
  static{
    zeta[0] = w[0][0];
    zeta[1] =   w[0][1] + preces;
  }

  // Precession matrix.
  private static final double p1 =  0.10180391E-4;;;
  private static final double p2 =  0.47020439E-6;
  private static final double p3 = -0.5417367E-9;
  private static final double p4 = -0.2507948E-11;
  private static final double p5 =  0.463486E-14;
  private static final double q1 = -0.113469002E-3;
  private static final double q2 =  0.12372674E-6;
  private static final double q3 =  0.1265417E-8;
  private static final double q4 = -0.1371808E-11;
  private static final double q5 = -0.320334E-14;

  //*********************************************************************************
  // 2 - Variables to retrieve the terms ; notations local to JEphem
  //*********************************************************************************

  /** Path to the files containing ELP terms. */
  private static String _dataPath;
  /** Indicates if the data have been loaded . */
  private static boolean _dataLoaded = false;

  /** Number of terms contained in the files.
  <BR><CODE>nbTerms[i][j]</CODE> contains terms of file ELPXX where XX = i*NB_COORD + j.
  <BR><B>WARNING</B> : the indication 'Records' in README specifies the nb of <B>lines</B> of
  a file, which is nbTerms + 1 for data files.
  <BR>This array was built putting 'records' - 1
  */
  private static final int[][] nbTerms = {
    {1023, 918, 704},       // nb terms in ELP1, ELP2, ELP3
    {347, 316, 237},        // nb terms in ELP4, ELP5, ELP6
    {14, 11, 8},
    {14328, 5233, 6631},
    {4384, 833, 1715},
    {170, 150, 114},
    {226, 188, 169},        // etc ...
    {3, 2, 2},
    {6, 4, 5},
    {20, 12, 14},
    {11, 4, 10},
    {28, 13, 19}            // nb terms in ELP34, ELP35, ELP36
  }; // total 37872

  /** Array indicating the the time degree by which terms from a group of 3 files must be multiplied.
  <BR>timeDegree[0] concerns ELP1, ELP2, ELP3 ; timeDegree[1] concerns ELP4, ELP5, ELP6 etc... */
  // USELESS NOW...
  private static final int[] timeDegree = {0, 0, 1, 0, 1, 0, 1, 0, 1, 0, 0, 2};

  /** Number of data files. */
  private final static int NB_FILES = 36;
  /** Prefix of data file names. */
  private final static String INPUTFILENAME_PREFIX = "dataELP";
  /** Suffix of data file names (original files don't have, I added '.txt' for convenience under windows */
  private final static String INPUTFILENAME_SUFFIX = ".txt";

  /** The 36 data files can be grouped ; each group share the same format and the summation
  done on terms of a file of a group uses the same formula.
  <BR>Fisrt group contains ELP1, ELP2, ELP3 ; second group contains ELP4 ... ELP9 etc... */
  private static final int[] fileGroups = {4, 10, 16, 22, 37};

  /** Array to indicate how many columns files contain.
  <BR><CODE>nbColInfileGroups[][0]</CODE> represent the nb of columns of integers ;
  <BR><CODE>nbColInfileGroups[][1]</CODE> represent the nb of columns of doubles ;
  <BR>For example, files ELP1, 2 and 3 (first group) contain 4 columns of integers and 1 of double
  (this example is particular : files contain 7 cols of doubles, but only 1 is used in the formulae). */
  private static final int[][] nbColsInFileGroup = { {4,  6},
                                                     {5,  2},
                                                     {11, 2},
                                                     {11, 2},
                                                     {5,  2}
                                                   };
/** For each FileGroup, col sizes of doubles. */
  private static final int[][] doubleColSizes = { {15, 12, 12, 12, 12, 12 },
                                                  {10, 10},
                                                  {10, 10},
                                                  {10, 10},
                                                  {10, 10}
                                                };

  /** Number of characters occupied by an integer in ELP data files*/
  private static final int INT_SIZE = 3;
  /** Number of characters occupied by a double in ELP data files*/
  private static final int DOUBLE_SIZE = 10;

  /** Terms of the summation.
  <BR>if we have : intTerms[i][j][k],
  <LI>'i' would be the index of the file (0 - 35)</LI>
  <LI>'j' would be the line in this file (expressed with 'nbTerms'</LI>
  <LI>'k' would be the column in the file (expressed with 'nbColsInFileGroup')</LI>
  */
  private static int[][][] intTerms;
  private static double[][][] dblTerms;

  //=================================================================================
  //                                 PUBLIC METHODS
  //=================================================================================

  /** Returns the precision of the calculation for a given julian day and a given body.
  @param bodyIndex Integer specifying for which Body the precision is asked ; use
  @param jd The julian day for which the precision is asked.
  {@link jephem.astro.solarsystem.SolarSystemConstants}.
  */
  public static double getPrecision(int bodyIndex, double jd){
    return 0.01; // TEMP CODE ; to implement precisely
  }// end getPrecision

  /** Sets the path to data used by ELP82 to perform the computations. */
  public static void setDataPath(String dataPath){
    _dataPath = dataPath;
  }// end setDataPath

  //******************* calcCoord(jd, body, precision, velocities) *************
  /** Calculation of Moon coordinates.
  @param jd julian date ; time scale : dynamical time TDB.
  @param body a <CODE>Body</CODE> whose index is at <CODE>SolarSystemConstants.MOON</CODE>.
  @param prec Precision required for calculations in <B>arc seconds</B>.
  @param velocities Flag indicating if velocities must be also calculated.
  @throws ComputationException if a computation was asked for an instant not handled by ELP82.
  @throws AstroException if the data for the computations are not loaded.
  ********************************************************************************/
  public static void calcCoord(double jd, Body body, double precision, boolean velocities) throws AstroException{

    if (!_dataLoaded){
      try { loadData(); }
      catch(AstroException ae){ throw ae; }
    }
    // Check validity of parameters
    if (body.getIndex() != SolarSystemConstants.MOON)
      throw new IllegalArgumentException("'body' argument must represent the moon");

    // ComputationException checking
    if (precision < getPrecision(SolarSystemConstants.MOON, jd))
      body.setComputationException(new ComputationException(ComputationException.PRECISION_ERROR,
                                                            body.getIndex(), jd, TimeConstants.TT_TDB));

    ELP82 elp = new ELP82();
    elp.initVariables(jd, body, precision, velocities);

    double[] res = new double[3]; // contains the results (long., lat., dist.)
    res[0] = res[1] = res[2] = 0.0;

    // iFile represents here a group of 3 files (1 - 12)
    for(int iFile = 0; iFile < NB_FILES/NB_COORD; iFile++){
      for(int iCoord = 0; iCoord < NB_COORD; iCoord++){
        res[iCoord] += elp.sum(iFile, iCoord);
      }
    }

    res = elp.endCalculation(res);

    // Set the fields of Body
    body.setFrame(SpaceConstants.FRAME_THEORY);
    body.setCoordinateExpression(SpaceConstants.CARTESIAN);
    body.setPositionUnits(UnitsConstants.UNITGROUP_KM_KM_KM);
    //if(velocities) body.setVelocityUnits(UNITGROUP_AUD_AUD_AUD);
    body.setPositionCoords(res[0], res[1], res[2]);
    if (velocities){
      //body.setVelocityCoords(res[3], res[4], res[5]);
      body.setVelocityCoords(10, 10, 10);
      body.setVelocityUnits(UnitsConstants.UNITGROUP_AUD_AUD_AUD);
    }
//System.out.println("res[0] = " + res[0]);
//System.out.println("res[1] = " + res[1]);
//System.out.println("res[2] = " + res[2]);

  }// end calcCoord(jd, body, precision, velocities)


  //=================================================================================
  //                                 PRIVATE METHODS
  //=================================================================================

  //******************* initVariables(jd, body, precision, velocities) *************
  /** Initializes the instance variables. **/
  private void initVariables(double jd, Body body, double precision, boolean velocities){

    _jd = jd;
    _body = body;
    _precision = precision;
    _velocities = velocities;
    _pre = new double[3];
    _pre[0] = _precision*rad - 1E-12;
    _pre[1] = _precision*rad - 1E-12;
    _pre[2] = _precision*ath;

    // Time and its powers ; _t[i] = t^i
    _t = new double[MAXALPHA + 1];
    _t[0] = 1.0;
    _t[1] = (jd - TimeConstants.JD2000)/TimeConstants.DAYS_PER_CENTURY;
    for (int i = 2; i<= MAXALPHA; i++)
      _t[i] = _t[i-1] * _t[1];

  } // end initVariables()


  //******************* sum(iFile, iCoord) **************************
  /** Performs the summation for all terms of a file.
  @param iFile Index of the group of 3 files (0-11).
  @param iCoord Index of the coordinate concerned by the file
  */
  private double sum(int iFile, int iCoord){

    double res = 0.0;
    int curFile = iFile * NB_COORD + iCoord + 1; // real index of the file (1 - 36)
    int i,j,k; // used to loop

    // ***** ELP1, ELP2, ELP3
    // ***** Main problem.
    if (curFile < 4){
      double x, y;
      double tgv, coef1;
      for (i = 0; i < nbTerms[iFile][iCoord]; i++){
//System.out.println("case 1-3 curFile = " + curFile + " i = " + i);
//System.out.println("iFile = " + iFile + " iCoord = " + iCoord + " i = " + i);
        x = dblTerms[curFile-1][i][0];
        if(Math.abs(x) < _pre[iCoord]) continue; // precision filter

        tgv = dblTerms[curFile-1][i][1] + dtasm*dblTerms[curFile-1][i][5];;
        coef1 = dblTerms[curFile-1][i][0];
        if (curFile == 3) coef1 -= 2.0 * coef1*delnu/3.0;
        x = coef1 + tgv*(delnp-am*delnu) + dblTerms[curFile-1][i][2]*delg
          + dblTerms[curFile-1][i][3]*dele + dblTerms[curFile-1][i][4]*delep;

        y = 0.0;
        for (j = 0; j < 5; j++){
          for (k = 0; k < 4; k++){
            y += intTerms[curFile-1][i][k] * del[k][j] * _t[j];
          }// end for k
        }// end for j
        if (iCoord == 2) y += pis2;
        y = Maths.modX(y, cpi2);

        res += x*Math.sin(y);
      }// end for i
    }// end ELP1 -> ELP3

    // ***** ELP4 -> ELP9 and ELP22 -> ELP36
    // ***** Figures - Tides - Relativity - Solar eccentricity.
    else if (curFile < 10 || curFile > 21){
      double x, y;
      for (i = 0; i < nbTerms[iFile][iCoord]; i++){
//System.out.println("case 4-9 22-36 curFile = " + curFile + " i = " + i);
        x = dblTerms[curFile-1][i][1];
        if(Math.abs(x) < _pre[iCoord]) continue; // precision filter

        if (iFile > 6 && iFile < 10) x*= _t[1];
        if (iFile > 24 && iFile < 28) x*= _t[1];
        if (iFile > 33) x*= _t[2];

        y = dblTerms[curFile-1][i][0] * deg;
        for (j = 0 ; j < 2; j++){
          y += intTerms[curFile-1][i][0] * zeta[j] * _t[j];
          for (k = 0; k < 4; k++){
            y += intTerms[curFile-1][i][k+1] * del[k][j] * _t[j];
          }// end for k
        }// end for j
        y = Maths.modX(y, cpi2);

        res += x*Math.sin(y);
      }// end for i
    }// end ELP4 -> ELP9 and ELP22 -> ELP36

    // ***** ELP10 -> ELP21
    // ***** Planetary perturbations
    else if (curFile < 22){
      double x, y, z;
      for (i = 0; i < nbTerms[iFile][iCoord]; i++){
//System.out.println("case 10 -21 curFile = " + curFile + " i = " + i);
        x = dblTerms[curFile-1][i][1];
        if(Math.abs(x) < _pre[iCoord]) continue; // precision filter

        if( (iFile > 12 && iFile < 16) || (iFile > 18 && iFile < 22) )
          x *= _t[1];

        y = dblTerms[curFile-1][i][0] * deg;

        if (iFile < 16){
          for (j = 0 ; j < 2; j++){
            z = intTerms[curFile-1][i][8] * del[0][j]
              + intTerms[curFile-1][i][9] * del[2][j]
              + intTerms[curFile-1][i][10] * del[3][j];
            y += z*_t[j];
            for (k = 0; k < 8; k++){
              y += intTerms[curFile-1][i][k] * p[k][j] * _t[j];
            }// end for k
          }// end for j
        }
        else{
          for (j = 0 ; j < 2; j++){
            for (k = 0; k < 4; k++){
              y += intTerms[curFile-1][i][k+7] * del[k][j] * _t[j];
            }// end for k
            for (k = 0; k < 7; k++){
              y += intTerms[curFile-1][i][k] * p[k][j] * _t[j];
            }// end for k
          }// end for j
        }
        y = Maths.modX(y, cpi2);
        res += x*Math.sin(y);

      }// end for i
    }// end ELP10 -> ELP21

    return res;

  } // end sum


  //******************* endCalculation *************
  /** Finalizes the calculation after the main sum.
  @return An array containing the 3 cartesian coordinates expressed in km.
  **/
  private double[] endCalculation(double[] res){
    // convert longitude given by the series in radians and add mean longitude
    res[0] = res[0]/rad + w[0][0] + w[0][1]*_t[1] + w[0][2]*_t[2] + w[0][3]*_t[3] + w[0][4]*_t[4];
    // convert latitude to radians
    res[1] = res[1]/rad;
    // slightly modify distance (why ??????)
    res[2] = res[2]*a0/ath;

    // Here res are expressed in ELP natural frame

    // transform to cartesian
    double x1 = res[2]*Math.cos(res[1]);
    double x2 = x1*Math.sin(res[0]);
    x1 = x1*Math.cos(res[0]);
    double x3 = res[2]*Math.sin(res[1]);

    // Change frame (to inertial mean ecliptic and equinox JD2000)
    double pw = (p1 + p2*_t[1] + p3*_t[2] + p4*_t[3] + p5*_t[4]) * _t[1];
    double qw = (q1 + q2*_t[1] + q3*_t[2] + q4*_t[3] + q5*_t[4]) * _t[1];
    double ra = 2.0*Math.sqrt(1.0 - pw*pw - qw*qw);
    double pwqw = 2.0*pw*qw;
    double pw2 = 1.0 - 2.0*pw*pw;
    double qw2 = 1.0 - 2.0*qw*qw;
    pw = pw*ra;
    qw = qw*ra;

    res[0] = pw2*x1 + pwqw*x2 + pw*x3;
    res[1] = pwqw*x1 + qw2*x2 - qw*x3;
    res[2] = -pw*x1 + qw*x2 + (pw2 + qw2 - 1.0) * x3;
    return res;

  } // end endCalculation()

  //******************* loadData() **********************************
  /** Loads the data in arrays intTerms[][][] and dblTerms[][][]. */
  private static void loadData() throws AstroException{
    if(_dataPath == null){
      throw new AstroException("Before Using ELP82, you must indicate where VSOP data are located with setDataPath()");
    }
    int i, j; // for loops
    int k; // index for the parsing of the current line of current file
    try{
      // path to the files
      intTerms = new int[NB_FILES][][];
      dblTerms = new double[NB_FILES][][];
      String curFileName; // current file parsed.

      int iCurFile; // real index of current file read (1 - 36).
      int curFileGroup;
      int curNbTerms;

      LineNumberReader lnr;
      String line;

//FileOutputStream fos = new FileOutputStream(new File("loadELP200.txt"));
//String ls = System.getProperty("line.separator");
//String strTemp;

      for (int iFile = 0; iFile < NB_FILES/NB_COORD; iFile++){ // iFile in [0 - 11]
        for (int iCoord = 0; iCoord < NB_COORD; iCoord++){
//strTemp = "";
          iCurFile = iFile*NB_COORD + iCoord + 1;
          curFileGroup = findFileGroup(iCurFile);
          curNbTerms = nbTerms[iFile][iCoord];
          intTerms[iCurFile - 1] = new    int[curNbTerms][nbColsInFileGroup[curFileGroup][0]];
          dblTerms[iCurFile - 1] = new double[curNbTerms][nbColsInFileGroup[curFileGroup][1]];

          curFileName = _dataPath + INPUTFILENAME_PREFIX + Formats.addZero(iCurFile) + INPUTFILENAME_SUFFIX;
          lnr = new LineNumberReader(new FileReader(curFileName));
//System.out.println("loading terms from " + curFileName);
//strTemp += "======= first terms of " + curFileName + " : " + ls;
//strTemp += "int : [" + String.valueOf(curNbTerms) + "]" + "[" + String.valueOf(nbColsInFileGroup[curFileGroup][0]) + "]" + ls;
//strTemp += "double : [" + String.valueOf(curNbTerms) + "]" + "[" + String.valueOf(nbColsInFileGroup[curFileGroup][1]) + "]" + ls;
//fos.write(strTemp.getBytes());
          // Skip first line (header);
          line = lnr.readLine();
          // Read input file line after line and fill arrays.
          for (i = 0; i < curNbTerms; i++){
            line = lnr.readLine();
            // Parse integers
            k = 0;
            for (j = 0; j < nbColsInFileGroup[curFileGroup][0]; j++){
              intTerms[iCurFile - 1][i][j] = Integer.parseInt(line.substring(k, k + INT_SIZE).trim());
              k += INT_SIZE;
//if (i < 2) strTemp += "intTerms[" + (iCurFile - 1) + "][" + i + "][" + j + "] = " + intTerms[iCurFile - 1][i][j] + ls;
//System.out.println("intTerms[" + (iCurFile - 1) + "][" + i + "][" + j + "] " + intTerms[iCurFile - 1][i][j]);
            }
            // Parse doubles
            for (j = 0; j < nbColsInFileGroup[curFileGroup][1]; j++){
              dblTerms[iCurFile - 1][i][j] = Double.parseDouble(line.substring(k, k + doubleColSizes[curFileGroup][j]).trim());
              k += doubleColSizes[curFileGroup][j];
//if (i < 2) strTemp += "dblTerms[" + (iCurFile - 1) + "][" + i + "][" + j + "] = " + dblTerms[iCurFile - 1][i][j] + ls;
            }
          }// end for (i = 0; i < curNbTerms; i++)

//fos.write(strTemp.getBytes());
        }// end for (int iCoord = 0; iCoord < NB_COORD; iCoord++)
      }// end for (int iFile = 0; iFile < NB_FILES/NB_COORD; iFile++)
//fos.close();

      _dataLoaded = true;
    }
    catch(Exception e){
      throw new AstroException(e);
    }
  }// end loadData

  //**************** findFileGroup ************************
  /** Auxiliary method used by <CODE>loadData</CODE>.
  @param fileIndex The index characterizing a file (1 - 36)
  @return the groupFile of <CODE>fileIndex</CODE>.
  */
  private static int findFileGroup(int fileIndex){
    for (int i = 0; i < fileGroups.length; i++){
      if (fileIndex < fileGroups[i]){
        return i;
      }
    }
    return -1; // should not happen
  }// end findFileGroup

} //end class ELP82

