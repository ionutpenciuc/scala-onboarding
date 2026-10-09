package lessons.l04_option_either_errors

import lessons.l03_case_classes_traits.{Currency, Invoice, InvoiceStatus, Money}

import java.time.LocalDate
import java.time.format.DateTimeParseException
import scala.math.BigDecimal.RoundingMode
import scala.util.Try

/** Lesson 4 — missing values and failures, without a crash.
  *
  * `Option` is a box that is either `Some(value)` or `None`.
  * Use it when a value may be missing. Example: no exchange rate for CHF.
  *
  * `Either` is a box with two sides.
  * `Left` is the error text. `Right` is the success value.
  * A validation test asserts `Left` or `Right`.
  *
  * `Try` catches an exception and stores it. `Success` or `Failure`.
  * Prefer `Either` when you write the error message yourself.
  *
  * A `for` comprehension walks the happy path. The first `Left` or `None` stops it.
  */
object Parse {

  def parseAmount(text: String): Option[BigDecimal] =
    try Some(BigDecimal(text.trim).setScale(2, RoundingMode.HALF_UP))
    catch {
      case _: NumberFormatException => None
    }

  def rateFor(currency: String, rates: Map[String, BigDecimal]): Option[BigDecimal] =
    rates.get(currency)

  def readWholeNumber(text: String): Try[Int] =
    Try(text.trim.toInt)

  def nonBlank(value: String, field: String): Either[String, String] =
    if (value.trim.isEmpty) Left(s"$field is blank") else Right(value.trim)

  def parseCurrency(code: String): Either[String, Currency] =
    Currency.values.find(_.toString == code.trim).toRight(s"unknown currency ${code.trim}")

  def parseDate(text: String): Either[String, LocalDate] =
    try Right(LocalDate.parse(text.trim))
    catch {
      case _: DateTimeParseException => Left(s"bad date ${text.trim}")
    }

  /** Check every field. Stop at the first problem.
    * The `yield` runs only when every step is `Right`.
    */
  def validateInvoice(
      number: String,
      supplier: String,
      currency: String,
      total: String,
      issuedOn: String,
      dueDate: String,
      today: LocalDate
  ): Either[String, Invoice] =
    for {
      checkedNumber <- nonBlank(number, "number")
      checkedSupplier <- nonBlank(supplier, "supplier")
      checkedCurrency <- parseCurrency(currency)
      amount <- parseAmount(total).toRight(s"bad amount ${total.trim}")
      issued <- parseDate(issuedOn)
      due <- parseDate(dueDate)
    } yield Invoice(
      number = checkedNumber,
      supplier = checkedSupplier,
      total = Money(amount, checkedCurrency),
      issuedOn = issued,
      dueDate = due,
      status = if (due.isBefore(today)) InvoiceStatus.Overdue else InvoiceStatus.Open
    )
}
