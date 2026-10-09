package lessons.l02_collections

/** Lesson 2 — lists, sets, and maps.
  *
  * A List keeps order and allows duplicates.
  * A Set keeps each value once. Order is not the point.
  * A Map pairs a key with a value. A supplier name can map to a total.
  *
  * These collections are immutable. `filter` and `map` return a new collection.
  * The old one stays as it was. That makes a test repeatable.
  */
object Collections {

  /** Add every amount. An empty list totals 0.00.
    * `foldLeft` starts at the zero and adds each item.
    */
  def total(amounts: List[BigDecimal]): BigDecimal =
    amounts.foldLeft(BigDecimal("0.00"))(_ + _).setScale(2, BigDecimal.RoundingMode.HALF_UP)

  /** Keep amounts that are greater than or equal to the limit. */
  def atLeast(amounts: List[BigDecimal], limit: BigDecimal): List[BigDecimal] =
    amounts.filter(_ >= limit)

  def unique(names: List[String]): Set[String] =
    names.toSet

  /** `map` turns each pair into just the amount, then `sum` adds them.
    * `groupBy` puts rows with the same name in one bucket.
    */
  def totalsByName(rows: List[(String, BigDecimal)]): Map[String, BigDecimal] =
    rows.groupBy(_._1).map { case (name, pairs) =>
      val sum = pairs.map(_._2).foldLeft(BigDecimal("0.00"))(_ + _)
      name -> sum.setScale(2, BigDecimal.RoundingMode.HALF_UP)
    }
}
