package exercises.ex06_discount

class Ex06DiscountShould extends munit.FunSuite {
  test("take 10 percent off an open invoice of 200") {
    // execute

    val due = Discount.payable("OPEN", BigDecimal("200.00"))

    // verify

    assertEquals(due, BigDecimal("180.00"))
  }

  test("take 10 percent off an open invoice of exactly 100") {
    // execute

    val due = Discount.payable("OPEN", BigDecimal("100.00"))

    // verify

    assertEquals(due, BigDecimal("90.00"))
  }

  test("leave a small open invoice unchanged") {
    // execute

    val due = Discount.payable("OPEN", BigDecimal("50.00"))

    // verify

    assertEquals(due, BigDecimal("50.00"))
  }

  test("leave a paid invoice unchanged") {
    // execute

    val due = Discount.payable("PAID", BigDecimal("200.00"))

    // verify

    assertEquals(due, BigDecimal("200.00"))
  }

  test("leave an overdue invoice unchanged") {
    // execute

    val due = Discount.payable("OVERDUE", BigDecimal("200.00"))

    // verify

    assertEquals(due, BigDecimal("200.00"))
  }

  test("leave an unknown status unchanged") {
    // execute

    val due = Discount.payable("DRAFT", BigDecimal("200.00"))

    // verify

    assertEquals(due, BigDecimal("200.00"))
  }
}
