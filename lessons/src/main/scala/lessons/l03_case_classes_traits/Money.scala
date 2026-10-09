package lessons.l03_case_classes_traits

import scala.math.BigDecimal.RoundingMode

/** Money is an amount plus a currency.
  *
  * A case class gives you:
  * - a constructor
  * - equality by value (`==` compares the fields)
  * - `copy`, which makes a new value with one field changed
  *
  * We use BigDecimal, not Double. Double cannot store 0.10 exactly.
  * Amounts in this course use two decimal places and half-up rounding.
  *
  * The companion object (`object Money`) holds helpers that are not tied
  * to one money value. Call them as `Money.eur("10.00")`.
  */
case class Money(amount: BigDecimal, currency: Currency) {
  def plus(other: Money): Money = {
    if (currency != other.currency)
      throw new IllegalArgumentException(s"currency mismatch: $currency vs ${other.currency}")
    copy(amount = (amount + other.amount).setScale(2, RoundingMode.HALF_UP))
  }

  def times(factor: BigDecimal): Money =
    copy(amount = (amount * factor).setScale(2, RoundingMode.HALF_UP))

  def show: String = s"${amount.setScale(2, RoundingMode.HALF_UP)} $currency"
}

object Money {
  def of(amount: String, currency: Currency): Money =
    Money(BigDecimal(amount).setScale(2, RoundingMode.HALF_UP), currency)

  def eur(amount: String): Money = of(amount, Currency.EUR)
}
