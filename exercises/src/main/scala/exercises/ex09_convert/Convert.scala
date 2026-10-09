package exercises.ex09_convert

/** Convert an amount to EUR.
  *
  * `rates` maps a currency code to "how many EUR is 1 unit".
  * Example: `USD -> 0.92` means 1 USD = 0.92 EUR.
  *
  * Return `Some(eur)` when the code is in the map.
  * Return `None` when the code is missing. Do not throw.
  * Use two decimal places, half up.
  *
  * Hint: `rates.get(currency)` is already an `Option`.
  * Hint: `option.map(rate => amount * rate)` changes the value inside `Some`.
  */
object Convert {
  def toEur(amount: BigDecimal, currency: String, rates: Map[String, BigDecimal]): Option[BigDecimal] = ???
}
