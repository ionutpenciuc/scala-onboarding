package lessons.l03_case_classes_traits

/** A trait is a contract. Anything billable must expose an amount.
  * `Invoice` implements this contract below.
  */
trait Billable {
  def amount: Money
}
