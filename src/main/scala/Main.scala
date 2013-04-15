
/**User: jason
  * Date: 4/14/13
  * Provides a main class.
  */
object Main {

  def main(args: Array[String]){

    print("START: ")
    val t0 = makeAClock()

    print("STOP: ")
    val t1 = makeAClock()

    val degreeTravel = new ClockSynchronizer(t0, t1).degreesBetween()
    println("The minute hand must travel " + degreeTravel + " degrees to get from " + t0 + " to " + t1 + ".")

  }

 /** @return keep asking the user for input until s/he types in a valid time..
   */
  def makeAClock():Clock = {
    println("Please enter a time with the following format: HH:mm AM|PM). Then hit enter.")
    try{
      new  Clock(new AmPmTimeFormat(readLine()).minuteOfDay())
    } catch {
      case e: IllegalArgumentException =>
        println(e.getMessage)
        makeAClock()
    }
  }

}
