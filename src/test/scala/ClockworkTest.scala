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

  test("tickTock advances clock") {
    var min = generator.randomPositiveInt()
    min = min % 1440
    val actual = testInstance.tickTock(min)
    if ((min + 1) % 1440 == 0)
      assert(actual === 0)
    else
      assert(actual === min + 1)
  }

  test("tickTock + 1440 is the same value") {
    var min = generator.randomPositiveInt()
    min = min % 1440
    val orig = min
    for (i <- 1 to 1440) min = testInstance.tickTock(min)
    assert( orig === min)
  }

  test("tickTock crosses the date boundary correctly"){
    var min = 1439
    var t1 = testInstance.tickTock(min)
    var t2 = testInstance.tickTock(t1)
    assert( t2 === 1)
  }

}
