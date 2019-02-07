//*********************************************************************************
// class jephem.astro.solarsystem.SolarSystem
// Software released under the General Public License (version 2 or later), available at
// http://www.gnu.org/copyleft/gpl.html
//*********************************************************************************
package jephem.astro.solarsystem;

import jephem.astro.solarsystem.SolarSystemConstants;

/******************************************************************************
This class contains general static method related to solar system matters. Related constants are in
{@link SolarSystemConstants}.
@author Thierry Graff
@history feb 18 2002 : creation just for body names.
@todo
*********************************************************************************/
public abstract class SolarSystem implements SolarSystemConstants{

  //=================================================================================
  //                                      CONSTANTS
  //=================================================================================

  /** Array containig English body names (only planets for the moment) ; use constants of this class
  designating planets to access to the names.*/
  private static final String[] ENGLISH_BODY_NAMES = {"Sun", "Moon", "Mercury", "Venus", "Earth",
                                                       "Mars", "Jupiter", "Saturn",
                                                       "Uranus", "Neptune", "Pluto"};
  //=================================================================================
  //                                      METHODS
  //=================================================================================

  /** Returns the English label of a body. Use {@link SolarSystemConstants} constants to designate the body.
  <BR>Equivalent to method <CODE>getName()</CODE> of class <CODE>Body</CODE> ; this method is however
  useful as it can be used without instantiating biodies.
  */
  public static String getBodyName(int bodyIndex){
    return ENGLISH_BODY_NAMES[bodyIndex];
  }// end getBodyName

}// end class SolarSystem