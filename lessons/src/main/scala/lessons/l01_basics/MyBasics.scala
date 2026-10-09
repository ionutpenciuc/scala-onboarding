package lessons.l01_basics

object MyBasics {

  /** 1. Return "Good morning, <name>!"*/
  def goodMorning(name: String): String = s"Good morning $name"

  /** 2. Return the bigger of two numbers using `if`*/
  def maxValue(x: Int, y: Int): Int = if (x < y) y else x

  /** 3. Return true if n is even. Hint: n % 2 == 0 */
  def isEven(n: Int): Boolean = if (n % 2 == 0) true else false

  /** 4. Grade a score using if / else if / else:
   * 90 or more -> "A", 70 or more -> "B", 50 or more -> "C", otherwise "F"
   */
  def grade(score: Int): String =
    if (score >= 90) "A"
    else if (score >=0) "B"
    else if (score >=50) "C"
    else "F"

  /** 5. Use `match`: "red" -> "stop", "yellow" -> "wait",
   * "green" -> "go", anything else -> "broken light"
   */
  def trafficLight(color: String): String = color match
    case "red" => "stop"
    case "yellow" => "wait"
    case "green" => "go"
    case _ => "broken light"

  /** 6. Recursion: sum of all numbers from 1 to n.
   * sumTo(4) = 4 + 3 + 2 + 1 = 10. Base case: sumTo(0) = 0
   */
  def sumTo(n: Int): Int =
    if (n == 0) n 
      else n + sumTo(n - 1)

}
