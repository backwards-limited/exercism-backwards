import java.util.concurrent.atomic.AtomicReference
import scala.language.postfixOps

class Robot(implicit RobotName: RobotName = DefaultRobotName) {
  private var _name: String = RobotName.name

  def name: String = _name

  def reset(): Unit =
    _name = RobotName.name
}

trait RobotName {
  val names: LazyList[String]

  lazy val letters: LazyList[String] =
    LazyList.from('A' to 'Z').map(_.toString)

  lazy val digits: LazyList[Int] =
    LazyList.from(1 to 9)

  val random = new scala.util.Random()

  private lazy val availableNames: AtomicReference[LazyList[String]] =
    new AtomicReference[LazyList[String]](random shuffle names)

  def name: String = {
    val h #:: t = availableNames.get()
    availableNames set t
    h
  }
}

object DefaultRobotName extends RobotName {
  val names: LazyList[String] = for {
    letter1 <- letters
    letter2 <- letters
    digit1 <- digits
    digit2 <- digits
    digit3 <- digits
  } yield s"$letter1$letter2$digit1$digit2$digit3"
}