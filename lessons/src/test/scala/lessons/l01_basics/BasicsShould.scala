package lessons.l01_basics

class BasicsShould extends munit.FunSuite {
  test("greet a person by name") {
    // execute

    val text = Basics.greet("Ana")

    // verify

    assertEquals(text, "Hello, Ana")
  }

  test("add two whole numbers") {
    // execute

    val sum = Basics.add(2, 3)

    // verify

    assertEquals(sum, 5)
  }

  test("describe a negative number") {
    // execute

    val label = Basics.describeSize(-4)

    // verify

    assertEquals(label, "negative")
  }

  test("describe zero") {
    // execute

    val label = Basics.describeSize(0)

    // verify

    assertEquals(label, "zero")
  }

  test("describe a positive number") {
    // execute

    val label = Basics.describeSize(8)

    // verify

    assertEquals(label, "positive")
  }

  test("name Friday for day 5") {
    // execute

    val name = Basics.weekday(5)

    // verify

    assertEquals(name, "Friday")
  }

  test("return unknown for a day outside 1 to 7") {
    // execute

    val name = Basics.weekday(0)

    // verify

    assertEquals(name, "unknown")
  }

  test("return 1 for factorial of 0") {
    // execute

    val result = Basics.factorial(0)

    // verify

    assertEquals(result, 1)
  }

  test("compute factorial of 5") {
    // execute

    val result = Basics.factorial(5)

    // verify

    assertEquals(result, 120)
  }

  test("reject a negative factorial") {
    // execute & verify

    intercept[IllegalArgumentException] {
      Basics.factorial(-1)
    }
  }
}
