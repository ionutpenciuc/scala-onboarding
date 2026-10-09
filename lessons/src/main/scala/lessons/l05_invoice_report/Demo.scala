package lessons.l05_invoice_report

import java.time.LocalDate

/** Run this lesson with: sbt "lessons/run 5"
  *
  * "Today" is fixed so the report does not change every morning.
  */
object Demo {
  def run(): Unit = {
    println("Lesson 5 — Invoice report")
    println()
    val today = LocalDate.parse("2026-10-09")
    val report = InvoiceReport.fromResources(today)
    println(s"As of $today")
    println(InvoiceReport.format(report))
    if (report.rejected.nonEmpty) {
      println("Rejected:")
      report.rejected.foreach(message => println(s"  - $message"))
    }
  }
}
