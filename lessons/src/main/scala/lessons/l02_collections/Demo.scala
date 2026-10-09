package lessons.l02_collections

/** Run this lesson with: sbt "lessons/run 2" */
object Demo {
  def run(): Unit = {
    println("Lesson 2 — Collections")
    println()

    val amounts = List(BigDecimal("10.00"), BigDecimal("2.50"), BigDecimal("10.00"))
    println(s"total = ${Collections.total(amounts)}")
    println(s"at least 10 = ${Collections.atLeast(amounts, BigDecimal("10.00"))}")
    println(s"unique = ${Collections.unique(List("Acme SRL", "Beta SA", "Acme SRL"))}")

    val rows = List(
      "Acme SRL" -> BigDecimal("120.50"),
      "Beta SA" -> BigDecimal("10.00"),
      "Acme SRL" -> BigDecimal("69.00")
    )
    println(s"by supplier = ${Collections.totalsByName(rows)}")
  }
}
