package lessons.l04_option_either_errors

import java.time.LocalDate
import scala.util.{Failure, Success}

/** Run this lesson with: sbt "lessons/run 4" */
object Demo {
  def run(): Unit = {
    println("Lesson 4 — Option, Either, Try")
    println()

    println(s"amount 10.50 -> ${Parse.parseAmount("10.50")}")
    println(s"amount nope  -> ${Parse.parseAmount("nope")}")

    val rates = Map("EUR" -> BigDecimal(1), "USD" -> BigDecimal("0.92"))
    println(s"rate USD -> ${Parse.rateFor("USD", rates)}")
    println(s"rate CHF -> ${Parse.rateFor("CHF", rates)}")

    Parse.readWholeNumber("12") match {
      case Success(n)  => println(s"whole number $n")
      case Failure(ex) => println(s"not a whole number: ${ex.getMessage}")
    }

    val today = LocalDate.parse("2026-10-09")
    val good = Parse.validateInvoice(
      "INV-001",
      "Acme SRL",
      "EUR",
      "120.50",
      "2026-01-15",
      "2026-02-15",
      today
    )
    val bad = Parse.validateInvoice(
      "INV-BAD",
      "Gamma",
      "XXX",
      "10.00",
      "2026-01-01",
      "2026-02-01",
      today
    )
    println(s"valid   -> $good")
    println(s"invalid -> $bad")
  }
}
