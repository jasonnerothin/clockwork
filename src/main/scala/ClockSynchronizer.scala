/** User: jason
  * Date: 4/13/13
  * Provides a mechanism for winding a clocks minute hand until the point that it matches with
  * another clocks minute hand.
  */
class ClockSynchronizer(clock0: Clock, clock1: Clock) extends Clockwork {

  /** Degree travel from the minute to travel from the time in clock0, to its position
    * in clock1.
    *
    * @return the total number of degrees to travel the minute hand in clock0 to match
    *         the minute hand in clock1
    */
  def degreesBetween(): Int = {
    /** @return the number of minutes we had to turn the from clock to match the toClock.
      */
    def synchronize(fromClock: Clock, toClock: Clock): Int = {
      if (fromClock == toClock) 0
      else 1 + synchronize(fromClock.moveMinuteHand(), toClock)
    }
    val minutes = synchronize(clock0, clock1)
    degreesOf(minutes)
  }

}