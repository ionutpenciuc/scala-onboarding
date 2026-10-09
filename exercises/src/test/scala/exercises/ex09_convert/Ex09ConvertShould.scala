package exercises.ex09_convert

class Ex09ConvertShould extends munit.FunSuite {
  private val rates = Map(
    "EUR" -> BigDecimal("1.00"),
    "USD" -> BigDecimal("0.92"),
    "RON" -> BigDecimal("0.20")
  )

  test("convert USD to EUR with the rate") {
    // execute

    val eur = Convert.toEur(BigDecimal("100.00"), "USD", rates)

    // verify

    assertEquals(eur, Some(BigDecimal("92.00")))
  }

  test("keep EUR when the rate is 1") {
    // execute

    val eur = Convert.toEur(BigDecimal("10.50"), "EUR", rates)

    // verify

    assertEquals(eur, Some(BigDecimal("10.50")))
  }

  test("return None when the currency has no rate") {
    // execute

    val eur = Convert.toEur(BigDecimal("10.00"), "CHF", rates)

    // verify

    assertEquals(eur, None)
  }

  test("convert a zero amount") {
    // execute

    val eur = Convert.toEur(BigDecimal("0.00"), "USD", rates)

    // verify

    assertEquals(eur, Some(BigDecimal("0.00")))
  }
}
