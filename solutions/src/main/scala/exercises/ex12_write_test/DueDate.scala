package exercises.ex12_write_test

import java.time.LocalDate
import java.time.temporal.ChronoUnit

object DueDate {
  def daysUntilDue(due: LocalDate, today: LocalDate): Long =
    ChronoUnit.DAYS.between(today, due)
}
