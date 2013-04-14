import org.joda.time.format.{DateTimeFormat, DateTimeFormatter}
import org.joda.time.LocalTime

/**
 * Created by IntelliJ IDEA.
 * User: jason
 * Date: 4/9/13
 * TimeFormat mixin for the “[H]H:MM AM” requirement.
 */
trait AmPmTimeFormat {

  val format = DateTimeFormat.forPattern("hh:mm a")

  def localTime(dateStr: String): LocalTime = {
    val date = dateStr.trim
    try {
      format.parseLocalTime(date)
    } catch {
      case e: IllegalArgumentException =>
        throw new IllegalArgumentException("Invalid date format. Expected hh:mm a, but got '" + dateStr + "'.")
    }
  }

}
