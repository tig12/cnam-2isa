//*********************************************************************************
// class jephem.astro.solarsystem.ComputationException
// Software released under the General Public License (version 2 or later), available at
// http://www.gnu.org/copyleft/gpl.html
//*********************************************************************************
package jephem.astro.solarsystem;

import jephem.astro.spacetime.TimeConstants;
import jephem.astro.spacetime.Time;
/******************************************************************************
Exception to throw when the computation of a planet can't be done correctly.
<BR>This exception may be thrown in two cases :
<LI>When the precision asked for the computation can't be reached.</LI>
<LI>When a computation is asked for a date that planetary theories can't handle.</LI>

<BR><BR>A computationException is characterized by :
<LI>its <B>type</B> (precision or date limit);</LI>
<LI>the <B>body index</B> of the body whose computation raised the exception;</LI>
<LI>the <B>julian day</B> for which it occured.</LI>
@author Thierry Graff
@history mar 11 2002 : Creation from AstroException.
*********************************************************************************/
public class ComputationException extends RuntimeException{

  //=================================================================================
  //                            CONSTANTS
  //=================================================================================
  /** Constant to indicate that this exception is due to a precision problem. */
  public static final int PRECISION_ERROR = 0;
  /** Constant to indicate that this exception is due to a date out of range problem. */
  public static final int DATE_LIMIT_ERROR = 1;

  private int _errorType;
  private int _bodyIndex;
  private double _jd;
  private int _timeFrame;

  /** Constructor
  @param errorType To specify what caused this exception ; use constants of this class to specify it.
  @param bodyIndex The body concerned by this exception.
  @param julianDay The julian day for which this exception occured.
  @param timeFrame The time frame used to express 'julianDay. Use {@link jephem.astro.spacetime.TimeConstants} for it.
  */
  public ComputationException(int errorType, int bodyIndex, double julianDay, int timeFrame){
    super();
    _errorType = errorType;
    _bodyIndex = bodyIndex;
    _jd = julianDay;
    _timeFrame = timeFrame;
  }// end constructor

  /** Returns the error type of this exception. */
  public int getErrorType(){return _errorType; }

  /** Returns the body index of this exception. */
  public int getBodyIndex(){return _bodyIndex; }

  /** Returns the julian day concerned by this exception.
  @param timeFrame The time frame (UTC or TT/TDB) in which the julian day must be returned ; use
  {@link jephem.astro.spacetime.TimeConstants} constants for it.
  */
  public double getJulianDay(int timeFrame){
    if(timeFrame == TimeConstants.TT_TDB){
      if(_timeFrame == TimeConstants.TT_TDB) return _jd;
      else return Time.getTT(_jd);
    }
    else if(timeFrame == TimeConstants.UTC){
      if(_timeFrame == TimeConstants.UTC) return _jd;
      else return Time.getUTC(_jd);
    }
    else throw new IllegalArgumentException("Illegal parameter 'timeFrame' - must correspond to constants of TimeConstants.");
  }// end getJulianDay

}//end class ComputationException