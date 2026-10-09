package exercises.ex12_write_test

import java.time.LocalDate
import java.time.temporal.ChronoUnit

/** This exercise is different. The function is already done.
  *
  * Your job is the missing test in `Ex12WriteTestShould`.
  * Read lesson 6 first. Copy the shape of the tests that already pass.
  *
  * `daysUntilDue` is the number of days from today until the due date.
  * A past due date is negative. Today is 0. A future date is positive.
  */
object DueDate {
  def daysUntilDue(due: LocalDate, today: LocalDate): Long =
    ChronoUnit.DAYS.between(today, due)
}
