import org.junit.runner.RunWith
import org.scalatest.FunSuite
import org.scalatest.junit.JUnitRunner

/**
 * Created by IntelliJ IDEA.
 * User: jason
 * Date: 4/10/13
 * Time: 12:57 AM
 * Provides...
 */
@RunWith(classOf[JUnitRunner])
sealed class AmPmTimeFormatTest extends FunSuite {

  val testInstance = new Object with AmPmTimeFormat

  test("happy formats parse") {
    val good = Array("11:11 PM", "7:01 am", " 9:13 PM")

    val t = testInstance.localTime(good(0))
    val u = testInstance.localTime(good(1))
    val v = testInstance.localTime(good(2))

    assert( t.getSecondOfMinute == 0 )
    assert( u.getSecondOfMinute == 0 )
    assert( v.getSecondOfMinute == 0 )

    assert( t.getMinuteOfHour == 11 )
    assert( u.getMinuteOfHour == 1 )
    assert( v.getMinuteOfHour == 13 )

    assert( t.getHourOfDay == 23 )
    assert( u.getHourOfDay == 7 )
    assert( v.getHourOfDay == 21 )

  }

  def verifyIAE(badString: String) {
    try {
      testInstance.localTime(badString)
      assert(false, "Should have thrown already")
    } catch {
      case e: IllegalArgumentException => {
        // pass
      }
      case _ => {
        assert(false, "failed in an unexpected manner")
      }
    }
  }

  test("naughty formats do not parse") {

    val bad = Array("13;13", "1111", "12:23:23")

    verifyIAE(bad(0))
  }

}
