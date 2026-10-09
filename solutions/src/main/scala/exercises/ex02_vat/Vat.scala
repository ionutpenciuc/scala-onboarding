package exercises.ex02_vat

import scala.math.BigDecimal.RoundingMode

object Vat {
  def vatOf(net: BigDecimal, percent: Int): BigDecimal =
    (net * BigDecimal(percent) / BigDecimal(100)).setScale(2, RoundingMode.HALF_UP)
}
