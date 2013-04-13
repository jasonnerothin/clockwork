/**
 * Created by IntelliJ IDEA.
 * User: jason
 * Date: 4/13/13
 */
class Clock(time: Int) extends Clockwork{

 /** @return a clock that is one minute ahead of this clock
   */
  def moveMinuteHand(): Clock = {
    new Clock(tickTock(time))
  }

 /** define two clocks as equal iff they correspond to the same nubmer of seconds from midnight
   * @param that to which we compare
   * @return if that is a clock with the same time as this
   */
  override def equals(that: Any) : Boolean = {
    that.isInstanceOf[Clock] && this.hashCode() == that.asInstanceOf [Clock].hashCode()
  }

 /** All most clocks care about is what time it is
   * @return hash this class' hashCode by time and time only
   */
  override def hashCode = time.hashCode % MINUTES_PER_DAY

 /** @return the degrees that the minute hand has moved from midnight (turning clockwise)
   */
  def degrees(): Int = {
    degreesOf(time) % 360
  }

}