import org.scalatest.FunSuite

/**
 * Created by IntelliJ IDEA.
 * User: jason
 * Date: 4/13/13
 */
sealed class ClockTest extends FunSuite{

  test("identically constructed Clocks have are equal and have the same hashCode"){
    val clock0 = new Clock(23)
    val clock1 = new Clock(23)
    assert( clock0 === clock1 )
    assert( clock0.hashCode === clock1.hashCode)
  }

  test("Clocks constructed slighly differently are not equal and do not share the same hashCodes"){
    val clock0 = new Clock(123)
    val clock1 = new Clock(344)
    assert( clock0 != clock1)
    assert( clock0.hashCode != clock1.hashCode)
  }

  test("Clocks cannot be instantiated with > 1439 minutes in them."){
    val thrown = intercept[IllegalArgumentException]{
      new Clock(1440)
    }
    assert( thrown != null )
  }

  test("Moving the minute hand returns a clock that is one minute ahead"){
    val clock0 = new Clock(123)
    val clock1 = clock0.moveMinuteHand()

    assert( clock1.degrees() === clock0.degrees() + 6 )
  }

  test("Moving the minute hand from 1 minute before midnight to one minute after midnight spans 12 degrees"){
    val dummy = new Clock(123)

    val clock0 = new Clock(dummy.lastMinuteOfDay())
    val clock1 = clock0.moveMinuteHand()
    val clock2 = clock1.moveMinuteHand()

    assert( clock2.degrees() + (360*24 - clock0.degrees()) === 12 )

  }

}
