import scala.language.postfixOps

object BeerSong {
  def recite(verses: Int, playback: Int): String =
    (verses to 0 by -1) map verse take playback mkString "\n"

  def verse(number: Int): String = {
    val verse = number match {
      case 0 =>
        """
          |No more bottles of beer on the wall, no more bottles of beer.
          |Go to the store and buy some more, 99 bottles of beer on the wall.
        """

      case 1 =>
        s"""
          |1 bottle of beer on the wall, 1 bottle of beer.
          |Take it down and pass it around, no more bottles of beer on the wall.
        """

      case x =>
        val remainder = if (x - 1 == 1) "1 bottle" else s"${x - 1} bottles"

        s"""
          |$x bottles of beer on the wall, $x bottles of beer.
          |Take one down and pass it around, $remainder of beer on the wall.
        """
    }

    verse.stripMargin.stripLeading.trim.concat("\n")
  }
}