package exercises.ex08_group

/** Sum amounts per supplier.
  *
  * Task: each pair is (supplier, amount). Add the amounts that share a name.
  * An empty list returns an empty map. Use two decimal places.
  *
  * Hint: `rows.groupBy(_._1)` buckets rows by the name.
  * Hint: lesson 2 `totalsByName` is this function.
  */
object GroupTotals {
  def bySupplier(rows: List[(String, BigDecimal)]): Map[String, BigDecimal] = ???
}
