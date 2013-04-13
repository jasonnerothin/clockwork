/**
  * Created by IntelliJ IDEA.
  * User: jason
  * Date: 4/9/13
  */
trait Clockwork {

  val MINUTES_PER_DAY = 24*60

  /** @param minutesSinceMidnight absolute number since midnight
    * @return degrees of minute hand movement (since midnight, whole numbers only)
    */
  def degreesOf(minutesSinceMidnight: Int): Int =
    minutesSinceMidnight * 6

  /** @param degrees amount of minute hand movement
    * @return equivalent value in minutes, whole minutes only
    */
  def minutesOf(degrees: Int): Int = {
    val deg = degrees / 6.0
    scala.math.round(deg).toInt
  }

 /** @return the last minute of the model day
   */
  def lastMinuteOfDay(): Int = MINUTES_PER_DAY - 1

 /** Calculate the next minute on the model clock
   * @param min some current position on the clock
   * @return the next (forward) location on the clock after min
   */
  def tickTock(min: Int): Int = {
    if( min >= MINUTES_PER_DAY )
      throw new IllegalArgumentException("Minute value {" + min + "} is greater than the number of minutes in a day {" + MINUTES_PER_DAY + "}")
   if( min < 0 )
     throw new IllegalArgumentException("Minute value {" + min + "} is negative, which is not allowed.")
    if( min != lastMinuteOfDay() ) min + 1
    else 0
  }

}
