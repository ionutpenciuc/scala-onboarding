package exercises.ex10_validate

/** Check three fields. Stop at the first problem.
  *
  * Return `Right(number)` when all of these are true:
  * - number is not blank (trim spaces)
  * - supplier is not blank
  * - total is a number and is >= 0
  *
  * Otherwise return `Left` with exactly one of:
  * - `number is blank`
  * - `supplier is blank`
  * - `total is not a number`
  * - `total is negative`
  *
  * Check in that order. Zero is allowed.
  *
  * Hint: a `for` comprehension stops at the first `Left`. Lesson 4 does this.
  * Hint: `BigDecimal(text)` throws `NumberFormatException` on bad text. Catch it.
  */
object Check {
  def validate(number: String, supplier: String, total: String): Either[String, String] = ???
}
