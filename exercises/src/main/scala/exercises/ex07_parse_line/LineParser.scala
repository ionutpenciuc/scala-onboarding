package exercises.ex07_parse_line

/** One valid CSV row. Do not change this shape. The tests build it. */
case class CsvLine(number: String, supplier: String, currency: String, total: BigDecimal)

/** Parse one invoice row.
  *
  * The line has 4 columns: number, supplier, currency, total.
  * Trim spaces around each column.
  *
  * Return `Right(line)` when the row is usable.
  * Return `Left` with one of these exact messages:
  * - `expected 4 columns` when the comma count is wrong
  * - `number is blank` when the number is empty
  * - `total is not a number` when the total does not parse
  *
  * Check in that order. Store the total with two decimal places.
  *
  * Hint: `line.split(",", -1)` keeps empty columns.
  * Hint: lesson 4 shows `Either`, `Right`, and `Left`.
  */
object LineParser {
  def parse(line: String): Either[String, CsvLine] = ???
}
