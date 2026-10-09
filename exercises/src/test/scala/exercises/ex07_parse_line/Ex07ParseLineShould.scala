package exercises.ex07_parse_line

class Ex07ParseLineShould extends munit.FunSuite {
  test("parse a valid row") {
    // execute

    val row = LineParser.parse("INV-001,Acme SRL,EUR,120.50")

    // verify

    assertEquals(row, Right(CsvLine("INV-001", "Acme SRL", "EUR", BigDecimal("120.50"))))
  }

  test("trim spaces around the columns") {
    // execute

    val row = LineParser.parse(" INV-001 , Acme SRL , EUR , 10.5 ")

    // verify

    assertEquals(row, Right(CsvLine("INV-001", "Acme SRL", "EUR", BigDecimal("10.50"))))
  }

  test("reject a row that does not have 4 columns") {
    // execute

    val row = LineParser.parse("INV-001,Acme SRL,EUR")

    // verify

    assertEquals(row, Left("expected 4 columns"))
  }

  test("reject a blank number") {
    // execute

    val row = LineParser.parse(",Missing Co,EUR,10.00")

    // verify

    assertEquals(row, Left("number is blank"))
  }

  test("reject a total that is not a number") {
    // execute

    val row = LineParser.parse("INV-NAN,Delta,EUR,nope")

    // verify

    assertEquals(row, Left("total is not a number"))
  }
}
