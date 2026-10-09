package exercises.ex06_discount

import scala.math.BigDecimal.RoundingMode

object Discount {
  def payable(status: String, amount: BigDecimal): BigDecimal = {
    val scaled = amount.setScale(2, RoundingMode.HALF_UP)
    status match {
      case "OPEN" if scaled >= BigDecimal(100) =>
        (scaled * BigDecimal("0.90")).setScale(2, RoundingMode.HALF_UP)
      case _ => scaled
    }
  }
}
