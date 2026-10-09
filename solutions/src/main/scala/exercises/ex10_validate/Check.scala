package exercises.ex10_validate

object Check {
  def validate(number: String, supplier: String, total: String): Either[String, String] =
    if (number.trim.isEmpty) Left("number is blank")
    else if (supplier.trim.isEmpty) Left("supplier is blank")
    else
      try {
        val amount = BigDecimal(total.trim)
        if (amount < 0) Left("total is negative") else Right(number.trim)
      } catch {
        case _: NumberFormatException => Left("total is not a number")
      }
}
