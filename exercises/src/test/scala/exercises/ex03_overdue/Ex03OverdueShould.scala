package exercises.ex03_overdue

import java.time.LocalDate

class Ex03OverdueShould extends munit.FunSuite {
  test("mark a due date before today as overdue") {
    // setup

    val due = LocalDate.parse("2026-10-08")
    val today = LocalDate.parse("2026-10-09")

    // execute

    val overdue = Due.isOverdue(due, today)

    // verify

    assert(overdue)
  }

  test("keep a due date of today as not overdue") {
    // setup

    val today = LocalDate.parse("2026-10-09")

    // execute

    val overdue = Due.isOverdue(today, today)

    // verify

    assert(!overdue)
  }

  test("keep a future due date as not overdue") {
    // setup

    val due = LocalDate.parse("2026-12-01")
    val today = LocalDate.parse("2026-10-09")

    // execute

    val overdue = Due.isOverdue(due, today)

    // verify

    assert(!overdue)
  }

  test("mark the last day of the previous month as overdue") {
    // setup

    val due = LocalDate.parse("2026-09-30")
    val today = LocalDate.parse("2026-10-01")

    // execute

    val overdue = Due.isOverdue(due, today)

    // verify

    assert(overdue)
  }
}
