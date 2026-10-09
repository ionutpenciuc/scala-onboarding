package exercises.ex05_filter

class Ex05FilterShould extends munit.FunSuite {
  test("keep amounts at or above the limit") {
    // setup

    val amounts = List(BigDecimal("1.00"), BigDecimal("10.00"), BigDecimal("10.50"))

    // execute

    val kept = Filters.atLeast(amounts, BigDecimal("10.00"))

    // verify

    assertEquals(kept, List(BigDecimal("10.00"), BigDecimal("10.50")))
  }

  test("return an empty list when the input is empty") {
    // execute

    val kept = Filters.atLeast(Nil, BigDecimal("1.00"))

    // verify

    assertEquals(kept, Nil)
  }

  test("return an empty list when nothing reaches the limit") {
    // setup

    val amounts = List(BigDecimal("1.00"), BigDecimal("2.00"))

    // execute

    val kept = Filters.atLeast(amounts, BigDecimal("5.00"))

    // verify

    assertEquals(kept, Nil)
  }

  test("leave the original list unchanged") {
    // setup

    val amounts = List(BigDecimal("1.00"), BigDecimal("20.00"))

    // execute

    val kept = Filters.atLeast(amounts, BigDecimal("10.00"))

    // verify

    assertEquals(kept, List(BigDecimal("20.00")))
    assertEquals(amounts, List(BigDecimal("1.00"), BigDecimal("20.00")))
  }
}
