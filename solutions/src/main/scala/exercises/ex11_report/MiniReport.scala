package exercises.ex11_report

import scala.math.BigDecimal.RoundingMode

object MiniReport {
  def totalsBySupplier(lines: List[String], rates: Map[String, BigDecimal]): Map[String, BigDecimal] = {
    val converted = lines.flatMap { line =>
      parse(line).flatMap { row =>
        rates.get(row.currency).map { rate =>
          row.supplier -> (row.total * rate).setScale(2, RoundingMode.HALF_UP)
        }
      }
    }
    converted.groupBy(_._1).map { case (name, pairs) =>
      name -> pairs.map(_._2).foldLeft(BigDecimal("0.00"))(_ + _).setScale(2, RoundingMode.HALF_UP)
    }
  }

  private case class Row(supplier: String, currency: String, total: BigDecimal)

  private def parse(line: String): Option[Row] = {
    val parts = line.split(",", -1).map(_.trim)
    if (parts.length != 4 || parts(0).isEmpty) None
    else
      try Some(Row(parts(1), parts(2), BigDecimal(parts(3))))
      catch {
        case _: NumberFormatException => None
      }
  }
}
