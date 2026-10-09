package exercises.ex11_report

/** A tiny supplier report.
  *
  * Each line has 4 columns: number, supplier, currency, total.
  * Same messages as exercise 7 if you want to reuse that idea.
  * You do not have to call exercise 7. This file should stand alone.
  *
  * Steps:
  * 1. Parse each line.
  * 2. Skip invalid lines.
  * 3. Convert the total to EUR with `rates`. Skip a line when the rate is missing.
  * 4. Sum EUR totals by supplier. Two decimal places, half up.
  *
  * `rates` means "how many EUR is 1 unit of that currency".
  *
  * Hint: `parse(...).toOption` turns `Right` into `Some` and `Left` into `None`.
  * Hint: lesson 5 does this with the full invoice file.
  */
object MiniReport {
  def totalsBySupplier(lines: List[String], rates: Map[String, BigDecimal]): Map[String, BigDecimal] = ???
}
