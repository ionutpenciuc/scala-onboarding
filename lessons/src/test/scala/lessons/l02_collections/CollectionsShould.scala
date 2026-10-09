package lessons.l02_collections

class CollectionsShould extends munit.FunSuite {
  test("total an empty list as 0.00") {
    // execute

    val sum = Collections.total(Nil)

    // verify

    assertEquals(sum, BigDecimal("0.00"))
  }

  test("total several amounts") {
    // setup

    val amounts = List(BigDecimal("10.00"), BigDecimal("2.50"), BigDecimal("0.25"))

    // execute

    val sum = Collections.total(amounts)

    // verify

    assertEquals(sum, BigDecimal("12.75"))
  }

  test("keep amounts at or above the limit") {
    // setup

    val amounts = List(BigDecimal("1.00"), BigDecimal("10.00"), BigDecimal("10.50"))

    // execute

    val kept = Collections.atLeast(amounts, BigDecimal("10.00"))

    // verify

    assertEquals(kept, List(BigDecimal("10.00"), BigDecimal("10.50")))
  }

  test("return an empty list when nothing reaches the limit") {
    // setup

    val amounts = List(BigDecimal("1.00"))

    // execute

    val kept = Collections.atLeast(amounts, BigDecimal("5.00"))

    // verify

    assertEquals(kept, Nil)
  }

  test("keep each name once") {
    // setup

    val names = List("Acme SRL", "Beta SA", "Acme SRL")

    // execute

    val once = Collections.unique(names)

    // verify

    assertEquals(once, Set("Acme SRL", "Beta SA"))
  }

  test("sum amounts that share a name") {
    // setup

    val rows = List(
      "Acme SRL" -> BigDecimal("10.00"),
      "Beta SA" -> BigDecimal("2.00"),
      "Acme SRL" -> BigDecimal("0.50")
    )

    // execute

    val totals = Collections.totalsByName(rows)

    // verify

    assertEquals(totals("Acme SRL"), BigDecimal("10.50"))
    assertEquals(totals("Beta SA"), BigDecimal("2.00"))
  }

  test("leave the original list unchanged after a filter") {
    // setup

    val amounts = List(BigDecimal("1.00"), BigDecimal("20.00"))

    // execute

    val kept = Collections.atLeast(amounts, BigDecimal("10.00"))

    // verify

    assertEquals(kept, List(BigDecimal("20.00")))
    assertEquals(amounts, List(BigDecimal("1.00"), BigDecimal("20.00")))
  }
}
