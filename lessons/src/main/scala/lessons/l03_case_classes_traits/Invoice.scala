package lessons.l03_case_classes_traits

import java.time.LocalDate

/** One supplier invoice.
  *
  * Due today is not overdue. Only a due date before today is overdue.
  * `copy(status = InvoiceStatus.Paid)` keeps every other field.
  */
case class Invoice(
    number: String,
    supplier: String,
    total: Money,
    issuedOn: LocalDate,
    dueDate: LocalDate,
    status: InvoiceStatus
) extends Billable {
  def amount: Money = total

  def isOverdue(today: LocalDate): Boolean =
    dueDate.isBefore(today)
}

object Invoice {
  def statusOn(dueDate: LocalDate, today: LocalDate): InvoiceStatus =
    if (dueDate.isBefore(today)) InvoiceStatus.Overdue else InvoiceStatus.Open
}
