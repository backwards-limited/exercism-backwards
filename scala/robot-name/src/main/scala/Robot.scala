import scala.annotation.tailrec
import scala.collection.mutable

class Robot(implicit N: RobotName = DefaultRobotName) {
  private var _name: String = N.name

  def name: String = _name

  def reset(): Unit = _name = N.name
}

trait RobotName {
  val allowedNames: Seq[String]

  lazy val letters: Seq[String] =
    ('A' to 'Z').map(_.toString)

  lazy val digits: Seq[Int] =
    1 to 9

  val random = new scala.util.Random()

  private val usedIndexes = mutable.HashSet.empty[Int]

  def name: String = synchronized {
    @tailrec
    def newName: String = {
      val index = random.nextInt(allowedNames.size) + 1

      if (usedIndexes contains index) {
        newName
      } else {
        val name: String = allowedNames(index)
        usedIndexes += index
        name
      }
    }

    newName
  }
}

object DefaultRobotName extends RobotName {
  val allowedNames: Seq[String] = for {
    letter1 <- letters
    letter2 <- letters
    digit1 <- digits
    digit2 <- digits
    digit3 <- digits
  } yield s"$letter1$letter2$digit1$digit2$digit3"
}