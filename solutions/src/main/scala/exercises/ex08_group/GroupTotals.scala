package exercises.ex08_group

import scala.math.BigDecimal.RoundingMode

object GroupTotals {
  def bySupplier(rows: List[(String, BigDecimal)]): Map[String, BigDecimal] =
    rows.groupBy(_._1).map { case (name, pairs) =>
      name -> pairs.map(_._2).foldLeft(BigDecimal("0.00"))(_ + _).setScale(2, RoundingMode.HALF_UP)
    }
}
