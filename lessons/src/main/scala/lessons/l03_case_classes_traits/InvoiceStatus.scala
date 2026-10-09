package lessons.l03_case_classes_traits

/** Open: not paid, and the due date is today or later.
  * Overdue: not paid, and the due date is before today.
  * Paid: the money was received. The sample file has no paid rows.
  */
enum InvoiceStatus {
  case Open, Paid, Overdue
}
