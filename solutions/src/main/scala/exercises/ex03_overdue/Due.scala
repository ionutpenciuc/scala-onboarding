package exercises.ex03_overdue

import java.time.LocalDate

object Due {
  def isOverdue(due: LocalDate, today: LocalDate): Boolean =
    due.isBefore(today)
}
