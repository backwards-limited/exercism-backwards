import scala.language.postfixOps

object BeerSong {
  val verse: Int => String = {
    case 0 =>
      """
        |No more bottles of beer on the wall, no more bottles of beer.
        |Go to the store and buy some more, 99 bottles of beer on the wall.
        |""".stripMargin.stripLeading

    case 1 =>
      """
        |1 bottle of beer on the wall, 1 bottle of beer.
        |Take it down and pass it around, no more bottles of beer on the wall.
        |""".stripMargin.stripLeading

    case x =>
      val remainder = x - 1 + (if (x - 1 == 1) " bottle" else " bottles")

      s"""
         |$x bottles of beer on the wall, $x bottles of beer.
         |Take one down and pass it around, $remainder of beer on the wall.
         |""".stripMargin.stripLeading
  }

  def recite(verses: Int, playback: Int): String =
    Stream.from(verses, -1) map verse take playback mkString "\n"
}