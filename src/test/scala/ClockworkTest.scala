import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
import org.scalatest.FunSuite
import testutil.Generator

/**
 * Created by IntelliJ IDEA.
 * User: jason
 * Date: 4/9/13
 */
@RunWith(classOf[JUnitRunner])
sealed class ClockworkTest extends FunSuite {

  val testInstance = new Object with Clockwork
  val generator = new Generator

  test("degreesOf is 6 times minutes") {

    val min = generator.randomPositiveInt()
    val actual = testInstance.degreesOf(min)

    assert(actual === min * 6, "360/60 is still 6, right?")
  }

  test("minutesOf divides by 6") {

    val degrees = (generator.randomPositiveInt() % 360) * 6 // make sure it's an even multiple
    val actual = testInstance.minutesOf(degrees)

    assert(actual === degrees / 6)

  }

  test("minutesOf rounds appropriately") {

    val degrees = 9
    val actual = testInstance.minutesOf(degrees)

    System.err.println("actual is: " + actual)

    assert(actual == 2.0)
  }


}
