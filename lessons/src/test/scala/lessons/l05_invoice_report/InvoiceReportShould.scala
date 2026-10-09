package lessons.l05_invoice_report

import lessons.l03_case_classes_traits.{Currency, InvoiceStatus}

import java.time.LocalDate

class InvoiceReportShould extends munit.FunSuite {
  private val today = LocalDate.parse("2026-10-09")

  test("parse exchange rates into EUR factors") {
    // setup

    val json = """{"base":"EUR","rates":{"EUR":{"numerator":1,"denominator":1},"USD":{"numerator":92,"denominator":100}}}"""

    // execute

    val rates = Rates.parse(json)

    // verify

    assertEquals(rates("EUR").setScale(2, BigDecimal.RoundingMode.HALF_UP), BigDecimal("1.00"))
    assertEquals(rates("USD").setScale(2, BigDecimal.RoundingMode.HALF_UP), BigDecimal("0.92"))
  }

  test("build supplier and status totals from the sample file") {
    // execute

    val report = InvoiceReport.fromResources(today)

    // verify

    assertEquals(report.valid.size, 5)
    assertEquals(report.rejected.size, 4)
    assertEquals(report.bySupplierEur("Acme SRL"), BigDecimal("189.50"))
    assertEquals(report.bySupplierEur("Beta SA"), BigDecimal("110.00"))
    assertEquals(report.bySupplierEur("Nord Ltd"), BigDecimal("46.80"))
    assertEquals(report.byStatusEur(InvoiceStatus.Overdue), BigDecimal("277.30"))
    assertEquals(report.byStatusEur(InvoiceStatus.Open), BigDecimal("69.00"))
  }

  test("record why a row was rejected") {
    // execute

    val report = InvoiceReport.fromResources(today)

    // verify

    assert(report.rejected.contains("number is blank"))
    assert(report.rejected.contains("unknown currency XXX"))
    assert(report.rejected.contains("bad amount nope"))
    assert(report.rejected.contains("bad date 31-01-2026"))
  }

  test("leave only INV-003 open on the sample day") {
    // execute

    val report = InvoiceReport.fromResources(today)
    val open = report.valid.filter(_.status == InvoiceStatus.Open).map(_.number)

    // verify

    assertEquals(open, List("INV-003"))
    assertEquals(report.valid.find(_.number == "INV-003").get.total.currency, Currency.USD)
  }

  test("skip a row that does not have 6 columns") {
    // setup

    val rates = Map("EUR" -> BigDecimal(1))

    // execute

    val report = InvoiceReport.build(List("only,three,columns"), rates, today)

    // verify

    assertEquals(report.valid, Nil)
    assertEquals(report.rejected, List("expected 6 columns: only,three,columns"))
  }

  test("include supplier lines in the printed report") {
    // execute

    val report = InvoiceReport.fromResources(today)
    val text = InvoiceReport.format(report)

    // verify

    assert(text.contains("Valid invoices: 5"))
    assert(text.contains("Rejected rows: 4"))
    assert(text.contains("Acme SRL: 189.50 EUR"))
    assert(text.contains("Open: 69.00 EUR"))
  }
}
