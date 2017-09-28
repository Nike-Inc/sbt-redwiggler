import java.io.File

object Main {
  def main(args : Array[String]): Unit = {
    val file = File.createTempFile("sbt-redwiggler", "restassured")
    file.delete()
    val filter = new com.nike.redwiggler.restassured.RedwigglerLoggingFilter(file)
  }
}