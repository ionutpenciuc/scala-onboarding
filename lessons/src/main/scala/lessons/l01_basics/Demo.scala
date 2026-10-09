package lessons.l01_basics

/** Run this lesson with: sbt "lessons/run 1" */
object Demo {
  def run(): Unit = {
    println("Lesson 1 — Basics")
    println()

    // val is a fixed name. You cannot assign it again.
    val course = "Scala"
    // var can change. Prefer val. Use var only when a value must move.
    var step = 1
    step = step + 1

    println(s"Course: $course, step: $step")
    println(Basics.greet("Ana"))
    println(s"2 + 3 = ${Basics.add(2, 3)}")
    println(s"-4 is ${Basics.describeSize(-4)}")
    println(s"day 5 is ${Basics.weekday(5)}")
    println(s"4! = ${Basics.factorial(4)}")
  }
}
