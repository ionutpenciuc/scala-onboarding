package exercises.ex02_vat

class Ex02VatShould extends munit.FunSuite {
  test("take 19 percent of 100") {
    // execute

    val vat = Vat.vatOf(BigDecimal("100.00"), 19)

    // verify

    assertEquals(vat, BigDecimal("19.00"))
  }

  test("return 0.00 when the percent is 0") {
    // execute

    val vat = Vat.vatOf(BigDecimal("10.00"), 0)

    // verify

    assertEquals(vat, BigDecimal("0.00"))
  }

  test("return 0.00 when the net is 0") {
    // execute

    val vat = Vat.vatOf(BigDecimal("0.00"), 19)

    // verify

    assertEquals(vat, BigDecimal("0.00"))
  }

  test("take 21 percent of 10") {
    // execute

    val vat = Vat.vatOf(BigDecimal("10.00"), 21)

    // verify

    assertEquals(vat, BigDecimal("2.10"))
  }

  test("round half up to two decimals") {
    // execute

    val vat = Vat.vatOf(BigDecimal("1.01"), 19)

    // verify

    assertEquals(vat, BigDecimal("0.19"))
  }
}
