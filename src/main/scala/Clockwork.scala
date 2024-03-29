/**
  * Created by IntelliJ IDEA.
  * User: jason
  * Date: 4/9/13
  */
trait Clockwork {

  val MINUTES_PER_DAY = 24 * 60

  /** @param minutesSinceMidnight absolute number since midnight
    * @return degrees of minute hand movement (since midnight, whole numbers only)
    */
  def degreesOf(minutesSinceMidnight: Int): Int =
    minutesSinceMidnight * 6

  /** @return the last minute of the model day  */
  def lastMinuteOfDay(): Int = MINUTES_PER_DAY - 1

  /** Calculate the next minute on the model clock
    * @param time some current position on the clock
    * @return the next (forward) location on the clock after min
    */
  def tickTock(time: Int): Int = {
    if (time >= MINUTES_PER_DAY)
      throw new IllegalArgumentException("Minute value {" + time + "} is greater than the number of minutes in a day {" + MINUTES_PER_DAY + "}")
    if (time < 0)
      throw new IllegalArgumentException("Minute value {" + time + "} is negative, which is not allowed.")
    if (time != lastMinuteOfDay()) time + 1
    else 0
  }

}
