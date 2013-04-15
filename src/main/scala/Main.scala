
/** User: jason
  * Date: 4/14/13
  * Provides a main class.
  */
object Main {

  /** Asks the user for two times and then calculates the number of degrees the minute hand
    * would need to move to get from the first time to the second. Reports the calculated result.
    * @param args ignored, if any
    */
  def main(args: Array[String]) {

    println("\nThis application calculates the amount of travel (in degrees) required to move the minute hand on an " +
      "abstract clock from one time to another. You will need to provide a start and stop time.\n")

    val t0 = makeAClock("Provide start time: ")
    val t1 = makeAClock("Provide stop time: ")

    val degreeTravel = new ClockSynchronizer(t0, t1).degreesBetween()
    println("The minute hand must travel " + degreeTravel + " degrees to get from " + t0 + " to " + t1 + ".")

  }

  /** @return keep asking the user for input until s/he types in a valid time. */
  def makeAClock(str:String): Clock = {
    println(str+"Please enter a time with the following format: HH:mm AM|PM. Then hit enter.")
    try {
      new Clock(new AmPmTimeFormat(readLine()).minuteOfDay())
    } catch {
      case e: IllegalArgumentException =>
        println(e.getMessage)
        makeAClock(str)
    }
  }

}
