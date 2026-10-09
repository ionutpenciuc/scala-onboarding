package lessons.l03_case_classes_traits

import java.time.LocalDate

class InvoiceShould extends munit.FunSuite {
  private val today = LocalDate.parse("2026-10-09")

  private def sample: Invoice =
    Invoice(
      number = "INV-001",
      supplier = "Acme SRL",
      total = Money.eur("120.50"),
      issuedOn = LocalDate.parse("2026-01-15"),
      dueDate = LocalDate.parse("2026-02-15"),
      status = InvoiceStatus.Overdue
    )

  test("treat two invoices with the same fields as equal") {
    // setup

    val left = sample
    val right = sample.copy()

    // execute

    val same = left == right

    // verify

    assert(same)
  }

  test("copy an invoice with a new status and keep the number") {
    // setup

    val open = sample.copy(status = InvoiceStatus.Open)

    // execute

    val paid = open.copy(status = InvoiceStatus.Paid)

    // verify

    assertEquals(paid.status, InvoiceStatus.Paid)
    assertEquals(paid.number, "INV-001")
    assertEquals(paid.supplier, open.supplier)
  }

  test("mark a past due date as overdue") {
    // setup

    val invoice = sample

    // execute

    val overdue = invoice.isOverdue(today)

    // verify

    assert(overdue)
  }

  test("keep a due date of today as not overdue") {
    // setup

    val invoice = sample.copy(dueDate = today, status = InvoiceStatus.Open)

    // execute

    val overdue = invoice.isOverdue(today)

    // verify

    assert(!overdue)
  }

  test("expose the invoice total as the billable amount") {
    // setup

    val invoice = sample

    // execute

    val amount = invoice.amount

    // verify

    assertEquals(amount, Money.eur("120.50"))
  }

  test("choose Overdue when the due date is before today") {
    // execute

    val status = Invoice.statusOn(LocalDate.parse("2026-02-15"), today)

    // verify

    assertEquals(status, InvoiceStatus.Overdue)
  }
}
