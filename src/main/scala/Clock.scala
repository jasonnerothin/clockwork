/** User: jason
  * Date: 4/13/13
  */
class Clock(time: Int) extends Clockwork {

  validate()

  def validate(){
    if( time >= MINUTES_PER_DAY ) throw new IllegalArgumentException("Time must not be greater than " + MINUTES_PER_DAY + ", but I received " + time + ".")
  }

  /** @return the degrees that the minute hand has moved from midnight (turning clockwise) */
  def degrees(): Int = {
    degreesOf(time)
  }

  /** @return minutes since midnight */
  def minutes(): Int = {
    time
  }

  /** @return the hour on a 12 hour clock */
  def hour(): Int = {
    val hrOfDay = hourOfDay()
    if (hrOfDay > 12) hrOfDay - 12
    else hrOfDay
  }

  /** @return the hour of the day, counting from zero */
  def hourOfDay(): Int = {
    time / 60
  }

  /** @return a clock that is one minute ahead of this clock */
  def moveMinuteHand(): Clock = {
    new Clock(tickTock(time))
  }

  /** @return the minute of the hour */
  def minuteOfHour(): Int = {
    time % 60
  }

  /** define two clocks as equal iff they correspond to the same nubmer of seconds from midnight
    * @param that to which we compare
    * @return if that is a clock with the same time as this
    */
  override def equals(that: Any): Boolean = {
    that.isInstanceOf[Clock] && this.hashCode() == that.asInstanceOf[Clock].hashCode()
  }

  /** All clocks care about is what time it is
    * @return hash this class' hashCode by time and time only
    */
  override def hashCode = time.hashCode

  /** @return the time in "[H]H:MM AM|PM" format */
  override def toString: String = {
    val buff = new StringBuffer()
    val hr = hour()
    if (hr > 0) buff.append(hour())
    else buff.append("12")
    buff.append(":")
    val min = minuteOfHour()
    if (min < 10) buff.append("0")
    buff.append(minuteOfHour()).append(" ")
    if (hourOfDay() < 12) buff.append("AM")
    else buff.append("PM")
    buff.toString
  }
}