import scala.util.parsing.combinator._

object MatchingBrackets extends RegexParsers {
  lazy val noBrackets: Parser[String] = """[^\[\]{\}()]""".r

  lazy val `[]`: Parser[String ~ Boolean ~ String] = "[" ~ expr ~ "]"

  lazy val `{}`: Parser[String ~ Boolean ~ String] = "{" ~ expr ~ "}"

  lazy val `()`: Parser[String ~ Boolean ~ String] = "(" ~ expr ~ ")"

  lazy val expr: Parser[Boolean] = rep(`[]` | `{}` | `()` | noBrackets) ^^ { _ => true }

  val isPaired: String => Boolean =
    parseAll(expr, _) match {
      case Success(matched, _) =>
        matched

      case Failure(msg, _) =>
        println(s"FAILURE: $msg")
        false

      case Error(msg, _) =>
        println(s"ERROR: $msg")
        false
    }

  /*
  Alternative by someone that is quite nice.
  val isPaired: String => Boolean = { input =>
    input.replaceAll("""[^\[({\})\]]|\{\}|\(\)|\[\]""", "") match {
      case `input` => input.isEmpty
      case s => isPaired(s)
    }
  }*/
}