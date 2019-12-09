import scala.math.pow

object ArmstrongNumbers {
  val isArmstrongNumber: Int => Boolean = { n =>
    val ns = n.toString.map(_.asDigit)
    n == ns.map(pow(_, ns.length)).sum
  }
}