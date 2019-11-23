import scala.language.postfixOps

object FoodChain {
  val animals: Vector[(String, String)] = Vector(
    "fly" -> "",
    "spider" -> "\nIt wriggled and jiggled and tickled inside her.",
    "bird" -> "\nHow absurd to swallow a bird!",
    "cat" -> "\nImagine that, to swallow a cat!",
    "dog" -> "\nWhat a hog, to swallow a dog!",
    "goat" -> "\nJust opened her throat and swallowed a goat!",
    "cow" -> "\nI don't know how she swallowed a cow!",
    "horse" -> "\nShe's dead, of course!"
  )

  val swallowed: Vector[String] = Vector(
    "She swallowed the cow to catch the goat.\n",
    "She swallowed the goat to catch the dog.\n",
    "She swallowed the dog to catch the cat.\n",
    "She swallowed the cat to catch the bird.\n",
    "She swallowed the bird to catch the spider that wriggled and jiggled and tickled inside her.\n",
    "She swallowed the spider to catch the fly.\n",
    "I don't know why she swallowed the fly. Perhaps she'll die.\n"
  )

  def recite(start: Int, end: Int): String =
    (start - 1) until end map { n =>
      val (animal, eaten) = animals(n)

      s"""
        |I know an old lady who swallowed a $animal.$eaten
        |${if (n <= 6) swallowed.drop(6 - n).mkString else ""}
        |""".stripMargin.stripPrefix("\n")

    } mkString
}