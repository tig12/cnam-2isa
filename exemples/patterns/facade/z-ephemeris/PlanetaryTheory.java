//*********************************************************************************
// interface jephem.astro.solarsystem.PlanetaryTheory
// Software released under the General Public License (version 2 or later), available at
// http://www.gnu.org/copyleft/gpl.html
//*********************************************************************************

package jephem.astro.solarsystem;

/******************************************************************************
Interface to be implemented by classes which compute planetary positions
<BR>This interface is empty because java doesn't allow to specify static methods in interfaces.
But all implementing classes of JEphem provide a method :
<BR><B><CODE>public static double getPrecision(int bodyIndex, double jd);</CODE></B>

<BR><BR>This interface is also used to define constants identifying planetary theories.

@author Thierry Graff.
@history oct 23 2001 : creation.
*********************************************************************************/

public interface PlanetaryTheory{

  //=================================================================================
  //                            CONSTANTS
  //=================================================================================

  //****************************************************
  // Constants to desingate planetary theories.
  // Values used for array purposes ; must be 0, 1, 2 ...
  //****************************************************

  /** Constant identifying full precision version of VSOP87A planetary theory. */
  public static final int VSOP87A_FULL = 0;

  /** Constant identifying Pluto99 planetary theory. */
  public static final int PLUTO99 = 1;

  /** Constant identifying ELP82b-2000 planetary theory. */
  public static final int ELP82 = 2;

  /** Array containing English names of planetary theories.
  Use constants identifying planetary theories to access to its elements. */
  public static final String[] THEORY_NAMES = { "VSOP87A", "Pluto99", "ELP82b-2000" };

}// end interface PlanetaryTheory
