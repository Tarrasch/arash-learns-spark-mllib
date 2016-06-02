/* SimpleApp.scala */
package arash.mllib

import org.apache.spark.SparkContext
import org.apache.spark.SparkContext._
import org.apache.spark.SparkConf

object SimpleApp {
  def main(args: Array[String]) {
    val logFile = args(0) // Should be some file on your system
    val conf = new SparkConf().setAppName("Simple Application")
    val sc = new SparkContext(conf)
    val logData = sc.textFile(logFile, 2).cache()

    def numChar(substr: String): Long = {
      logData.filter(line => line.contains(substr)).count()
    }

    def infoAbout(substrs: List[String]) = {
      val numberValues = substrs.map(numChar)
      val csStrings = substrs.mkString("{", ", ", "}")
      val csValues = numberValues.mkString("{", ", ", "}")
      "Lines with %s: %s".format(csStrings, csValues)
    }

    println(infoAbout(List("a", "b", "c")))
    // Lines with {a,b,c}: {10,20,15}
  }
}
