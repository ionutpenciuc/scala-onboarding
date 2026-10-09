package lessons.l03_case_classes_traits

import java.time.LocalDate

/** Run this lesson with: sbt "lessons/run 3" */
object Demo {
  def run(): Unit = {
    println("Lesson 3 — Case classes and traits")
    println()

    val left = Money.eur("10.50")
    val right = Money.eur("1.25")
    val sum = left.plus(right)
    println(s"${left.show} + ${right.show} = ${sum.show}")
    println(s"same value? ${sum == Money.eur("11.75")}")

    val today = LocalDate.parse("2026-10-09")
    val invoice = Invoice(
      number = "INV-001",
      supplier = "Acme SRL",
      total = Money.eur("120.50"),
      issuedOn = LocalDate.parse("2026-01-15"),
      dueDate = LocalDate.parse("2026-02-15"),
      status = Invoice.statusOn(LocalDate.parse("2026-02-15"), today)
    )
    val paid = invoice.copy(status = InvoiceStatus.Paid)
    println(s"${invoice.number} status ${invoice.status}, overdue=${invoice.isOverdue(today)}")
    println(s"copy keeps the number: ${paid.number}, new status: ${paid.status}")
    println(s"billable amount: ${invoice.amount.show}")
  }
}
