/**
  * Created by IntelliJ IDEA.
  * User: jason
  * Date: 4/9/13
  */
trait Clockwork {

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

}
