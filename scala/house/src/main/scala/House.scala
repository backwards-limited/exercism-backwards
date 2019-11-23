object House {
  val verses: Vector[String] = Vector(
    "house that Jack built.",
    "malt that lay in ",
    "rat that ate ",
    "cat that killed ",
    "dog that worried ",
    "cow with the crumpled horn that tossed ",
    "maiden all forlorn that milked ",
    "man all tattered and torn that kissed ",
    "priest all shaven and shorn that married ",
    "rooster that crowed in the morn that woke ",
    "farmer sowing his corn that kept ",
    "horse and the hound and the horn that belonged to "
  )

  def recite(start: Int, end: Int): String = {
    def recite(start: Int): String =
      s"""This is ${(start to 0 by -1).map(line => s"the ${verses(line)}").mkString}"""

    def recital(lines: Vector[String], verse: Int): Vector[String] =
      lines :+ recite(verse - 1)

    (start to end).foldLeft(Vector.empty[String])(recital).mkString("", "\n", "\n\n")
  }
}