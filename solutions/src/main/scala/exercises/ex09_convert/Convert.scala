package exercises.ex09_convert

import scala.math.BigDecimal.RoundingMode

object Convert {
  def toEur(amount: BigDecimal, currency: String, rates: Map[String, BigDecimal]): Option[BigDecimal] =
    rates.get(currency).map(rate => (amount * rate).setScale(2, RoundingMode.HALF_UP))
}
