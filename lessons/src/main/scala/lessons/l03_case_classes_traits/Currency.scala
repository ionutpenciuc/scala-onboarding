package lessons.l03_case_classes_traits

/** A Scala 3 enum is a closed list of values.
  * An invoice total is one of these. `XXX` is not in the list.
  */
enum Currency {
  case EUR, USD, RON, GBP
}
