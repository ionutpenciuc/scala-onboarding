package lessons.l03_case_classes_traits

class MoneyShould extends munit.FunSuite {
  test("add two amounts in the same currency") {
    // setup

    val left = Money.eur("10.50")
    val right = Money.eur("1.25")

    // execute

    val sum = left.plus(right)

    // verify

    assertEquals(sum, Money.eur("11.75"))
  }

  test("reject addition of two currencies") {
    // setup

    val euros = Money.eur("10.00")
    val dollars = Money.of("10.00", Currency.USD)

    // execute & verify

    intercept[IllegalArgumentException] {
      euros.plus(dollars)
    }
  }

  test("treat two equal amounts as the same value") {
    // setup

    val left = Money.eur("10.00")
    val right = Money.eur("10.00")

    // execute

    val same = left == right

    // verify

    assert(same)
  }

  test("multiply an amount and round half up") {
    // setup

    val money = Money.eur("10.00")

    // execute

    val part = money.times(BigDecimal("0.10"))

    // verify

    assertEquals(part, Money.eur("1.00"))
  }

  test("show the amount and the currency") {
    // setup

    val money = Money.eur("120.50")

    // execute

    val text = money.show

    // verify

    assertEquals(text, "120.50 EUR")
  }
}
