package exercises.ex11_report

class Ex11MiniReportShould extends munit.FunSuite {
  private val rates = Map(
    "EUR" -> BigDecimal("1"),
    "USD" -> BigDecimal("0.92"),
    "RON" -> BigDecimal("0.20"),
    "GBP" -> BigDecimal("1.17")
  )

  test("sum valid rows in EUR by supplier") {
    // setup

    val lines = List(
      "INV-001,Acme SRL,EUR,120.50",
      "INV-002,Beta SA,RON,500.00",
      "INV-003,Acme SRL,USD,75.00"
    )

    // execute

    val totals = MiniReport.totalsBySupplier(lines, rates)

    // verify

    assertEquals(totals("Acme SRL"), BigDecimal("189.50"))
    assertEquals(totals("Beta SA"), BigDecimal("100.00"))
  }

  test("skip an invalid row") {
    // setup

    val lines = List(
      "INV-001,Acme SRL,EUR,10.00",
      ",Missing Co,EUR,10.00",
      "INV-NAN,Delta,EUR,nope"
    )

    // execute

    val totals = MiniReport.totalsBySupplier(lines, rates)

    // verify

    assertEquals(totals, Map("Acme SRL" -> BigDecimal("10.00")))
  }

  test("skip a currency that has no rate") {
    // setup

    val lines = List("INV-009,Nord Ltd,CHF,40.00")

    // execute

    val totals = MiniReport.totalsBySupplier(lines, rates)

    // verify

    assertEquals(totals, Map.empty[String, BigDecimal])
  }

  test("return an empty map when every row is blank") {
    // execute

    val totals = MiniReport.totalsBySupplier(Nil, rates)

    // verify

    assertEquals(totals, Map.empty[String, BigDecimal])
  }
}
