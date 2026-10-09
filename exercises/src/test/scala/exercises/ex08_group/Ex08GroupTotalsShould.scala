package exercises.ex08_group

class Ex08GroupTotalsShould extends munit.FunSuite {
  test("return an empty map for an empty list") {
    // execute

    val totals = GroupTotals.bySupplier(Nil)

    // verify

    assertEquals(totals, Map.empty[String, BigDecimal])
  }

  test("keep a single supplier") {
    // setup

    val rows = List("Acme SRL" -> BigDecimal("10.00"))

    // execute

    val totals = GroupTotals.bySupplier(rows)

    // verify

    assertEquals(totals, Map("Acme SRL" -> BigDecimal("10.00")))
  }

  test("add amounts that share a supplier") {
    // setup

    val rows = List(
      "Acme SRL" -> BigDecimal("10.00"),
      "Acme SRL" -> BigDecimal("2.50")
    )

    // execute

    val totals = GroupTotals.bySupplier(rows)

    // verify

    assertEquals(totals("Acme SRL"), BigDecimal("12.50"))
  }

  test("keep two suppliers apart") {
    // setup

    val rows = List(
      "Acme SRL" -> BigDecimal("10.00"),
      "Beta SA" -> BigDecimal("3.00")
    )

    // execute

    val totals = GroupTotals.bySupplier(rows)

    // verify

    assertEquals(totals("Acme SRL"), BigDecimal("10.00"))
    assertEquals(totals("Beta SA"), BigDecimal("3.00"))
  }
}
