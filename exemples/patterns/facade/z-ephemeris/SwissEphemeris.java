//*********************************************************************************
// class jephem.astro.solarsystem.SwissEphemeris
// Software released under the General Public License (version 2 or later), available at
// http://www.gnu.org/copyleft/gpl.html
//*********************************************************************************
package jephem.astro.solarsystem;

import swisseph.*;

import jephem.GlobalVar;

import jephem.astro.Body;
import jephem.astro.solarsystem.SolarSystemConstants;
import jephem.astro.AstroException;
//import jephem.astro.solarsystem.ComputationException;
import jephem.astro.spacetime.SpaceConstants;
import jephem.astro.spacetime.TimeConstants;
import jephem.astro.spacetime.Units;
import jephem.astro.spacetime.UnitsConstants;

import tig.GeneralConstants;

/******************************************************************************
Class serving to interface JEphem and the java port of SwissEphemeris.
@author Thierry Graff
@history feb 02 2002 : creation.

@todo To be able to get an ComputationException from calcBodyCoords, class SwissEphe should be modified.
*********************************************************************************/
public abstract class SwissEphemeris
  implements GeneralConstants, SolarSystemConstants, SpaceConstants, UnitsConstants{

  //=================================================================================
  //                                      CLASS VARIABLES
  //=================================================================================
  /** path to SwissEphemeris data. */
  private static String _dataPath;

  /** The only SwissEphemeris used to perform the computations. */
  private static SwissEph _se;

  //=================================================================================
  //                                      CONSTANTS
  //=================================================================================

  /** Path to SwissEphemeris data, relative to JEphem/data. */
  private static final String PATH_TO_SWISS = "astro" + FS + "swissEphem" + FS;

  //=================================================================================
  //                                      PUBLIC METHODS
  //=================================================================================

  //***************** calcBodyCoords *******************************
  /** Computation of body coordinates, using Swiss Ephemeris. The results are stored in 'bodies'.
  @post Elements of 'bodies' are respect the parameters (fram, sphereCart, units...).
  */
  public static void calcBodyCoords(double  jd,
                                    Body[]  bodies,
                                    int     frame,
                                    int     sphereCart,
                                    double  precision,
                                    boolean velocities,
                                    int[]   units
                                  ) throws AstroException{
    //traceCalcBodyCoordsParameters(jd, bodies, frame, sphereCart, precision, velocities, units);
    if (_dataPath == null){
      throw new AstroException("Before Using SwissEphemeris, you must indicate where data are located with setDataPath()");
    }
    if (_se == null){
      //System.out.println("SwissEphemeris.calcBodyCoords() - build swiwsseph : " + _dataPath);
      _se = new SwissEph(_dataPath);
    }

    int iPlanet; // 'planet' = moving body
    int flag;
    StringBuffer err;
    double[] res = new double[6];

    for(int iBody = 0; iBody < bodies.length; iBody++){
      // build iPlanet
      iPlanet = getPlanetIndex(bodies[iBody].getIndex());
      // build flag
      flag = SweConst.SEFLG_SWIEPH;
      if(sphereCart == CARTESIAN) flag += SweConst.SEFLG_XYZ;
      if(velocities) flag += SweConst.SEFLG_SPEED;
      if(frame == FRAME_THEORY){
        //flag += SweConst.SEFLG_BARYCTR;
        flag += SweConst.SEFLG_HELCTR;
        flag += SweConst.SEFLG_J2000;
        flag += SweConst.SEFLG_NOABERR;
        flag += SweConst.SEFLG_NOGDEFL;
        flag += SweConst.SEFLG_NONUT;
        flag += SweConst.SEFLG_TRUEPOS;
      }
      else if(frame == FRAME_EC_HELIO_GEOMETRIC){
        flag += SweConst.SEFLG_TRUEPOS;
        flag += SweConst.SEFLG_HELCTR;
      }
      else if(frame == FRAME_EQUATORIAL){
        flag += SweConst.SEFLG_EQUATORIAL;
      }
      //else if(frame == FRAME_ECLIPTIC) // nothing to do, default result

      // call swiss ephemeris
      err = new StringBuffer(); //err.delete(0, err.length() - 1);
      _se.swe_calc_ut(jd, iPlanet, flag, res, err);
      //System.out.println("values from swisseph : " + tig.Strings.doubleArrayToString(res));

      // fill bodies
      if (sphereCart == CARTESIAN){
        bodies[iBody].setPositionCoords(res[0], res[1], res[2]);
        bodies[iBody].setPositionUnits(UNITGROUP_AU_AU_AU);
        if (velocities){
          bodies[iBody].setVelocityCoords(res[3], res[4], res[5]);
          bodies[iBody].setVelocityUnits(UNITGROUP_AUD_AUD_AUD);
        }
      }
      else{ // SPHERICAL
        bodies[iBody].setPositionCoords(res[2], res[0], res[1]);
        bodies[iBody].setPositionUnits(new int[]{DISTANCE_UNIT_AU,
                                                 ANGULAR_UNIT_DEG,
                                                 ANGULAR_UNIT_DEG});
        if (velocities){
          bodies[iBody].setVelocityCoords(res[5], res[3], res[4]);
          bodies[iBody].setVelocityUnits(new int[]{LINEAR_SPEED_UNIT_AU_PER_D,
                                                   ANGULAR_SPEED_UNIT_DEG_PER_DAY,
                                                   ANGULAR_SPEED_UNIT_DEG_PER_DAY});
        }
      }
      bodies[iBody].setFrame(frame);
      bodies[iBody].setCoordinateExpression(sphereCart);

      // Convert pos units
      bodies[iBody].setPositionCoords(Units.convertUnits(
              bodies[iBody].getPositionCoords(),
              bodies[iBody].getPositionUnits(),
              new int[]{units[0], units[1], units[2]}
      ));
      bodies[iBody].setPositionUnits(new int[]{units[0], units[1], units[2]});

      // Convert vel units
      if (velocities){
        bodies[iBody].setVelocityCoords(Units.convertUnits(
                bodies[iBody].getVelocityCoords(),
                bodies[iBody].getVelocityUnits(),
                new int[]{units[3], units[4], units[5]}
        ));
      bodies[iBody].setVelocityUnits(new int[]{units[3], units[4], units[5]});
      }

      // handle error returned from swiss eph.
      if (err.length() != 0)
        throw new AstroException("Error coming from SwissEphemeris : " + LS + err.toString());
    }// end for iBody
  }// end calcBodyCoords()

  //**************************** setDataPath *****************************************
  /** Sets the path to data ; SwissEphem data are in <dataPath>/astro/swissEphem. */
  public static void setDataPath(String dataPath){
    //System.out.println("SwissEphemeris.setDataPath() : " + dataPath);
    _dataPath = dataPath;
  }// end

  //=================================================================================
  //                                      PRIVATE METHODS
  //=================================================================================

  /** Converts a JEphem body index to a SwissEphemeris planet index. */
  private static int getPlanetIndex(int iBody){
    switch(iBody){
      case SUN :        return SweConst.SE_SUN;
      case MOON :       return SweConst.SE_MOON;
      case MERCURY :    return SweConst.SE_MERCURY;
      case VENUS :      return SweConst.SE_VENUS;
      case EARTH :      return SweConst.SE_EARTH;
      case MARS :       return SweConst.SE_MARS;
      case JUPITER :    return SweConst.SE_JUPITER;
      case SATURN :     return SweConst.SE_SATURN;
      case URANUS :     return SweConst.SE_URANUS;
      case NEPTUNE :    return SweConst.SE_NEPTUNE;
      case PLUTO :      return SweConst.SE_PLUTO;
      default :         return NO_SPECIF; // I checked that no swiss eph planet index are = -1.
    }
  }// end getPlanetIndex


  //=================================================================================
  //=================================================================================
  //                                      TESTS
  //=================================================================================
  //=================================================================================

/*
  // **************** For tests only ****************
  public static void main(String[] args){
    // no complete argument checking
    if(args[0].equalsIgnoreCase("testUnitType"))
      testUnitType();
    else if(args[0].equalsIgnoreCase("testConversion"))
      testConversion(args[1]);
    else if(args[0].equalsIgnoreCase("testGetUnitLabel"))
      testGetUnitLabel(args[1]);
    else
      System.out.println("first argument must be 'testUnitType' or 'testConversion' " +
      "or 'testGetUnitLabel'");
  }// end main
*/
  // **************** For tests only ****************
  private static void traceCalcBodyCoordsParameters(double  jd,
                                                   Body[]  bodies,
                                                   int     frame,
                                                   int     sphereCart,
                                                   double  precision,
                                                   boolean velocities,
                                                   int[]   units
                                  ){
    System.out.println("========== SwissEphemeris.traceCalcBodyCoordsParameters() ====================");
    int[] bodyIndices = new int[bodies.length];
    for (int i = 0; i < bodies.length; i++) bodyIndices[i] = bodies[i].getIndex();
    System.out.println("bodies : " + tig.Strings.intArrayToString(bodyIndices));
    System.out.println("frame : " + frame);
    System.out.println("sphereCart : " + sphereCart);
    System.out.println("precision : " + precision);
    System.out.println("velocities : " + velocities);
    System.out.println("units : " + tig.Strings.intArrayToString(units));
  }//end traceCalcBodyCoordsParameters

}// end class SwissEphemeris