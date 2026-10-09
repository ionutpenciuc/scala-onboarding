package exercises.ex04_sum

import scala.math.BigDecimal.RoundingMode

object Totals {
  def sumAmounts(amounts: List[BigDecimal]): BigDecimal =
    amounts.foldLeft(BigDecimal("0.00"))(_ + _).setScale(2, RoundingMode.HALF_UP)
}
