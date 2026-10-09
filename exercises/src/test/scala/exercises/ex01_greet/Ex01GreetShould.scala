package exercises.ex01_greet

class Ex01GreetShould extends munit.FunSuite {
  test("greet a person by name") {
    // execute

    val text = Greet.hello("Ana")

    // verify

    assertEquals(text, "Hello, Ana")
  }

  test("keep the comma and the space when the name is empty") {
    // execute

    val text = Greet.hello("")

    // verify

    assertEquals(text, "Hello, ")
  }

  test("keep both parts of a two-word name") {
    // execute

    val text = Greet.hello("Ana Pop")

    // verify

    assertEquals(text, "Hello, Ana Pop")
  }

  test("start the message with Hello") {
    // execute

    val text = Greet.hello("QA")

    // verify

    assert(text.startsWith("Hello, "))
  }
}
