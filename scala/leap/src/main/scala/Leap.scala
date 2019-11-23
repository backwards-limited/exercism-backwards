/**
 * on every year that is evenly divisible by 4
 *   except every year that is evenly divisible by 100
 *     unless the year is also evenly divisible by 400
 */
object Leap {
  private val divisibleBy4: Int => Boolean = divisibleBy(4)

  private val divisibleBy100: Int => Boolean = divisibleBy(100)

  private val divisibleBy400: Int => Boolean = divisibleBy(400)

  private def divisibleBy(denominator: Int)(numerator: Int): Boolean =
    numerator % denominator == 0

  def leapYear(year: Int): Boolean =
    divisibleBy4(year) && (divisibleBy400(year) || !divisibleBy100(year))
}