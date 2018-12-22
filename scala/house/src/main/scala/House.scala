import scala.annotation.tailrec

object House {
  val verses: Vector[String] = Vector(
    "the house that Jack built.",
    "the malt that lay in",
    "the rat that ate",
    "the cat that killed",
    "the dog that worried",
    "the cow with the crumpled horn that tossed",
    "the maiden all forlorn that milked",
    "the man all tattered and torn that kissed",
    "the priest all shaven and shorn that married",
    "the rooster that crowed in the morn that woke",
    "the farmer sowing his corn that kept",
    "the horse and the hound and the horn that belonged to"
  )

  def recite(startLine: Int, endLine: Int): String = {
    @tailrec
    def go(startLine: Int, lines: Vector[String]): Vector[String] = {
      if (startLine == endLine) {
        lines ++ Vector((startLine - 1 to 0 by - 1).map(verses.apply).mkString("This is ", " ", ""))
      } else {
        go(startLine + 1, lines ++ Vector((startLine - 1 to 0 by - 1).map(verses.apply).mkString("This is ", " ", "\n")))
      }
    }

    go(startLine, Vector.empty[String]).mkString("", "", "\n\n")
  }
}