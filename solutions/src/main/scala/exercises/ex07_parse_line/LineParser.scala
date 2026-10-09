package exercises.ex07_parse_line

import scala.math.BigDecimal.RoundingMode

case class CsvLine(number: String, supplier: String, currency: String, total: BigDecimal)

object LineParser {
  def parse(line: String): Either[String, CsvLine] = {
    val parts = line.split(",", -1).map(_.trim)
    if (parts.length != 4) Left("expected 4 columns")
    else if (parts(0).isEmpty) Left("number is blank")
    else
      try Right(CsvLine(parts(0), parts(1), parts(2), BigDecimal(parts(3)).setScale(2, RoundingMode.HALF_UP)))
      catch {
        case _: NumberFormatException => Left("total is not a number")
      }
  }
}
