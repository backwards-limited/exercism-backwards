import scala.language.postfixOps

object CollatzConjecture {
  val steps: Int => Option[Int] = {
    case n if n < 1 => None

    case n => Option {
      Stream.iterate(n) {
        case x if x % 2 == 0 => x / 2
        case x => 3 * x + 1
      } takeWhile (_ > 1) length
    }
  }
}