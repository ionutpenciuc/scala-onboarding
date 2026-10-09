# Exercises

Do these after the lesson in the table. Edit only the file named here.
Run the test command. Red means the code is not done yet.

`???` throws `NotImplementedError` on purpose. Replace it with your code.

Exercise 12 is different: the code is done. You write the missing test.

Try first. Open `solutions/` only after a real attempt.

| # | Goal | Read first | Edit | Test |
|---|------|------------|------|------|
| 1 | Return `Hello, Ana` | Lesson 1 | `exercises/src/main/scala/exercises/ex01_greet/Greet.scala` | `sbt "ex *Ex01*"` |
| 2 | VAT on a net amount, two decimals, half up | Lesson 1 | `exercises/src/main/scala/exercises/ex02_vat/Vat.scala` | `sbt "ex *Ex02*"` |
| 3 | Due date before today is overdue. Today is not | Lesson 3 | `exercises/src/main/scala/exercises/ex03_overdue/Due.scala` | `sbt "ex *Ex03*"` |
| 4 | Sum a list of amounts. Empty list is `0.00` | Lesson 2 | `exercises/src/main/scala/exercises/ex04_sum/Totals.scala` | `sbt "ex *Ex04*"` |
| 5 | Keep amounts greater than or equal to a limit | Lesson 2 | `exercises/src/main/scala/exercises/ex05_filter/Filters.scala` | `sbt "ex *Ex05*"` |
| 6 | Discount rules with `match` | Lesson 1 and 3 | `exercises/src/main/scala/exercises/ex06_discount/Discount.scala` | `sbt "ex *Ex06*"` |
| 7 | Parse one CSV line into `Either` | Lesson 4 | `exercises/src/main/scala/exercises/ex07_parse_line/LineParser.scala` | `sbt "ex *Ex07*"` |
| 8 | Sum amounts grouped by supplier | Lesson 2 | `exercises/src/main/scala/exercises/ex08_group/GroupTotals.scala` | `sbt "ex *Ex08*"` |
| 9 | Convert to EUR. Missing rate is `None` | Lesson 4 | `exercises/src/main/scala/exercises/ex09_convert/Convert.scala` | `sbt "ex *Ex09*"` |
| 10 | Validate number, supplier, and total | Lesson 4 | `exercises/src/main/scala/exercises/ex10_validate/Check.scala` | `sbt "ex *Ex10*"` |
| 11 | Mini report: skip bad rows, convert, group | Lesson 5 | `exercises/src/main/scala/exercises/ex11_report/MiniReport.scala` | `sbt "ex *Ex11*"` |
| 12 | Write the missing "due today" test | Lesson 6 | `exercises/src/test/scala/exercises/ex12_write_test/Ex12WriteTestShould.scala` | `sbt "ex *Ex12*"` |

Each stub has a short task comment and one or two hints.

Inside the `sbt` shell you can omit `sbt` and the quotes:

```text
ex *Ex01*
~ex *Ex01*
```

`~` runs the tests again each time you save.
