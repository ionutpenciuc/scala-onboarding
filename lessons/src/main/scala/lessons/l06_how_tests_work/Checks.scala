package lessons.l06_how_tests_work

/** Lesson 6 — the code under test.
  *
  * A test calls a function and checks the result.
  * You already know that idea: setup, execute, expected result.
  * MUnit is the tool that runs those checks. See `ChecksShould`.
  */
object Checks {
  def double(n: Int): Int = n * 2

  def requirePositive(n: Int): Int = {
    if (n <= 0) throw new IllegalArgumentException("n must be positive")
    n
  }
}
