import org.junit.runner.RunWith
import org.scalatest.FunSuite
import org.scalatest.junit.JUnitRunner

/**
 * Created by IntelliJ IDEA.
 * User: jason
 * Date: 4/13/13
 */
@RunWith(classOf[JUnitRunner])
sealed class ClockSynchronizerTest extends FunSuite{


//  test("Clock synchronization works"){
//    val from = new Clock(0)
//    val to = new Clock(1)
//
//    val result = testInstance.synchronize(from, to)
//
//    assert( result === 1)
//
//    val from0 = new Clock(1439)
//    val to0 = new Clock(1)
//
//    val result0 = testInstance.synchronize(from0, to0)
//
//    assert( result0 == 2 )
//  }

  test("Degrees between works"){
    var early = new Clock(1439)
    var late = new Clock(1)

    val actual = new ClockSynchronizer(early, late).degreesBetween()
    assert( actual === 12 )

    val result0 = new ClockSynchronizer( late, early).degreesBetween()
    assert( result0 === 1438 * 6 )

    val result1 = new ClockSynchronizer(late, late).degreesBetween()
    assert( result1 === 0)

  }

}
