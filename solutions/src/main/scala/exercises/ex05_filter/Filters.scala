package exercises.ex05_filter

object Filters {
  def atLeast(amounts: List[BigDecimal], limit: BigDecimal): List[BigDecimal] =
    amounts.filter(_ >= limit)
}
