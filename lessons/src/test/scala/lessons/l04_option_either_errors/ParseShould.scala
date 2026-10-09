package lessons.l04_option_either_errors

import lessons.l03_case_classes_traits.{Currency, InvoiceStatus, Money}

import java.time.LocalDate
import scala.util.Success

class ParseShould extends munit.FunSuite {
  private val today = LocalDate.parse("2026-10-09")

  test("parse a decimal amount") {
    // execute

    val amount = Parse.parseAmount("120.50")

    // verify

    assertEquals(amount, Some(BigDecimal("120.50")))
  }

  test("return None for an amount that is not a number") {
    // execute

    val amount = Parse.parseAmount("nope")

    // verify

    assertEquals(amount, None)
  }

  test("find a known rate") {
    // setup

    val rates = Map("USD" -> BigDecimal("0.92"))

    // execute

    val rate = Parse.rateFor("USD", rates)

    // verify

    assertEquals(rate, Some(BigDecimal("0.92")))
  }

  test("return None when the rate is missing") {
    // setup

    val rates = Map("EUR" -> BigDecimal(1))

    // execute

    val rate = Parse.rateFor("CHF", rates)

    // verify

    assertEquals(rate, None)
  }

  test("read a whole number") {
    // execute

    val parsed = Parse.readWholeNumber("12")

    // verify

    assertEquals(parsed, Success(12))
  }

  test("fail Try when the text is not a whole number") {
    // execute

    val parsed = Parse.readWholeNumber("12.5")

    // verify

    assert(parsed.isFailure)
  }

  test("reject an unknown currency") {
    // execute

    val currency = Parse.parseCurrency("XXX")

    // verify

    assertEquals(currency, Left("unknown currency XXX"))
  }

  test("accept EUR") {
    // execute

    val currency = Parse.parseCurrency("EUR")

    // verify

    assertEquals(currency, Right(Currency.EUR))
  }

  test("reject a date that is not yyyy-MM-dd") {
    // execute

    val date = Parse.parseDate("31-01-2026")

    // verify

    assertEquals(date, Left("bad date 31-01-2026"))
  }

  test("build an overdue invoice when every field is valid") {
    // execute

    val invoice = Parse.validateInvoice(
      "INV-001",
      "Acme SRL",
      "EUR",
      "120.50",
      "2026-01-15",
      "2026-02-15",
      today
    )

    // verify

    assert(invoice.isRight)
    assertEquals(invoice.toOption.get.total, Money.eur("120.50"))
    assertEquals(invoice.toOption.get.status, InvoiceStatus.Overdue)
  }

  test("stop at a blank number") {
    // execute

    val invoice = Parse.validateInvoice(
      "  ",
      "Missing Co",
      "EUR",
      "10.00",
      "2026-01-01",
      "2026-02-01",
      today
    )

    // verify

    assertEquals(invoice, Left("number is blank"))
  }

  test("stop at a bad amount and ignore the later fields") {
    // execute

    val invoice = Parse.validateInvoice(
      "INV-NAN",
      "Delta",
      "EUR",
      "nope",
      "not-a-date",
      "2026-02-01",
      today
    )

    // verify

    assertEquals(invoice, Left("bad amount nope"))
  }
}
