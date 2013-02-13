import Chisel._

object Main {
def main(args: Array[String]): Unit = {
  val toBuild = () => new Arbiter1()

  chiselMain(args, toBuild)
}
}
