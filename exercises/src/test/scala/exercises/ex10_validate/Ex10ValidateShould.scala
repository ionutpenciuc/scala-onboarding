package exercises.ex10_validate

class Ex10ValidateShould extends munit.FunSuite {
  test("accept a complete row and return the number") {
    // execute

    val result = Check.validate("INV-001", "Acme SRL", "120.50")

    // verify

    assertEquals(result, Right("INV-001"))
  }

  test("accept a total of zero") {
    // execute

    val result = Check.validate("INV-000", "Acme SRL", "0")

    // verify

    assertEquals(result, Right("INV-000"))
  }

  test("reject a blank number before later fields") {
    // execute

    val result = Check.validate("  ", "", "nope")

    // verify

    assertEquals(result, Left("number is blank"))
  }

  test("reject a blank supplier") {
    // execute

    val result = Check.validate("INV-001", "  ", "10.00")

    // verify

    assertEquals(result, Left("supplier is blank"))
  }

  test("reject a total that is not a number") {
    // execute

    val result = Check.validate("INV-NAN", "Delta", "nope")

    // verify

    assertEquals(result, Left("total is not a number"))
  }

  test("reject a negative total") {
    // execute

    val result = Check.validate("INV-NEG", "Delta", "-1.00")

    // verify

    assertEquals(result, Left("total is negative"))
  }
}
