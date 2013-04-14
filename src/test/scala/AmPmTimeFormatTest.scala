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

  test("happy formats parse") {
    val good = Array("11:11 PM", "7:01 am", " 9:13 PM", "12:01 aM", "12:00 am")

    val t = new AmPmTimeFormat(good(0))
    val u = new AmPmTimeFormat(good(1))
    val v = new AmPmTimeFormat(good(2))
    val w = new AmPmTimeFormat(good(3))
    val x = new AmPmTimeFormat(good(4))

    assert( t.minuteOfDay() === 23 * 60 + 11 )
    assert( u.minuteOfDay() === 7 * 60 + 1 )
    assert( v.minuteOfDay() === 21 * 60 + 13 )
    assert( w.minuteOfDay() === 1 )
    assert( x.minuteOfDay() === 0 )

  }

  def verifyIAE(badString: String) {
    try {
      new AmPmTimeFormat(badString)
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

    Array("13;13", "1111", "12:23:23").map( verifyIAE(_) )

  }

}
