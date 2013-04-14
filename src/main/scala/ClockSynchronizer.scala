/**
 * Created by IntelliJ IDEA.
 * User: jason
 * Date: 4/13/13
 * Time: 6:40 PM
 * Provides a mechanism for winding a clocks minute hand until the point that it matches with
 * another clocks minute hand.
 */
class ClockSynchronizer() extends Clockwork{

 /** @return the number of minutes we had to turn the from clock to match the toClock.
   */
  def synchronize(fromClock: Clock, toClock: Clock): Int = {
   if( fromClock == toClock ) 0
   else 1 + synchronize(fromClock.moveMinuteHand(), toClock)
  }

 /** Degree travel from the minute to travel from the time in clock0, to its position
   * in clock1
   *
   * @param clock0 the from clock
   * @param clock1 the to clock
   * @return the total number of degrees to travel the minute hand in clock0 to match
   *         the minute hand in clock1
   */
  def degreesBetween(clock0: Clock, clock1: Clock): Int = {
    val minutes = synchronize(clock0, clock1)
    degreesOf(minutes)
  }

}
