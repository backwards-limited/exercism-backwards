import java.util.concurrent.atomic.AtomicReference
import scala.language.postfixOps

class Robot(implicit RobotName: RobotName = DefaultRobotName) {
  private var _name: String = RobotName.name

  def name: String = _name

  def reset(): Unit = _name = RobotName.name
}

trait RobotName {
  val names: Stream[String]

  lazy val letters: Stream[String] =
    ('A' to 'Z').toStream.map(_.toString)

  lazy val digits: Stream[Int] =
    (1 to 9).toStream

  val random = new scala.util.Random()

  private lazy val availableNames: AtomicReference[Stream[String]] =
    new AtomicReference[Stream[String]](random shuffle names)

  def name: String = {
    val h #:: t = availableNames.get()
    availableNames set t
    h
  }
}

object DefaultRobotName extends RobotName {
  val names: Stream[String] = for {
    letter1 <- letters
    letter2 <- letters
    digit1 <- digits
    digit2 <- digits
    digit3 <- digits
  } yield s"$letter1$letter2$digit1$digit2$digit3"
}