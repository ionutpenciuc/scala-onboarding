package lessons.l06_how_tests_work

/** Run this lesson with: sbt "lessons/run 6"
  *
  * Then open the test file and run: sbt "lessons/testOnly *ChecksShould"
  */
object Demo {
  def run(): Unit = {
    println("Lesson 6 — How tests work")
    println()
    println("A test class name ends with Should. Example: ChecksShould.")
    println("The test name continues the sentence. It does not start with 'should'.")
    println()
    println("Inside the test, three comments mark the steps you already use:")
    println("  // setup    — build the inputs")
    println("  // execute  — call the code")
    println("  // verify   — assert the result")
    println()
    println("assertEquals(actual, expected) fails when the values differ.")
    println("assert(condition) fails when the condition is false.")
    println("intercept[SomeException] fails when that exception is not thrown.")
    println()
    println("Green means every assertion passed. Red means at least one failed.")
    println("Read the test name first. Then read expected vs actual.")
    println()
    println(s"double(21) = ${Checks.double(21)}")
  }
}
