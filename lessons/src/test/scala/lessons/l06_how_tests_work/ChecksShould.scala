package lessons.l06_how_tests_work

/** Read this file as the lesson. The comments name the MUnit tools.
  *
  * Class name: `{Subject}Should`.
  * Test name: the rest of the sentence. Do not start it with "should".
  * Body: `// setup`, `// execute`, `// verify`. One empty line after each tag.
  */
class ChecksShould extends munit.FunSuite {
  test("double a number") {
    // setup

    val n = 21

    // execute

    val result = Checks.double(n)

    // verify

    // assertEquals(actual, expected) fails when the two values differ.
    assertEquals(result, 42)
  }

  test("accept a positive number") {
    // execute

    val result = Checks.requirePositive(3)

    // verify

    // assert(condition) fails when the condition is false.
    assert(result > 0)
  }

  test("reject zero") {
    // execute & verify

    // intercept fails the test when this exception is not thrown.
    intercept[IllegalArgumentException] {
      Checks.requirePositive(0)
    }
  }

  test("reject a negative number with a clear message") {
    // execute & verify

    val error = intercept[IllegalArgumentException] {
      Checks.requirePositive(-2)
    }
    assertEquals(error.getMessage, "n must be positive")
  }
}
