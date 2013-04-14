import java.util.Date
import java.util.regex.Pattern

/* jason
 * Date: 4/9/13
 * TimeFormat mixin for the “[H]H:MM AM” requirement.
 */
class AmPmTimeFormat(time: String) {

  val format = Pattern.compile("^([ 0]?[1-9]|1[0-2])(:)[0-5][0-9]( )(AM|am|aM|Am|PM|pm|pM|Pm)$")

  validate()

  def validate() {
    if (!format.matcher(time).matches()) {
      throw new IllegalArgumentException("Expected a time like '12:13 PM', but got '" + time + "' instead.")
    }
  }


  def minuteOfDay(): Int = {
    def beforeNoon() = time.contains("am") || time.contains("AM") || time.contains("Am") || time.contains("aM")
    def hourPart() = time.substring(0, time.indexOf(":")).trim
    def hourOfDay(): Int = {
      val hour = Integer.parseInt(hourPart())
      if (hour == 12 && beforeNoon()) 0
      else if (!beforeNoon()) hour + 12
      else hour
    }
    def minuteOfHour(): Int = Integer.parseInt(time.trim.substring(time.trim.indexOf(":") + 1, time.trim.indexOf(" ")))
    hourOfDay() * 60 + minuteOfHour()
  }

}
