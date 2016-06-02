/* SimpleApp.scala */
package arash.mllib

import org.apache.spark.SparkContext
import org.apache.spark.SparkContext._
import org.apache.spark.SparkConf
import org.apache.spark.launcher.SparkAppHandle
import org.apache.spark.launcher.SparkLauncher;

object MyScalaLauncher {

  def main(args: Array[String]): Unit = {
    val jarpath = getClass().getProtectionDomain().getCodeSource().getLocation().getFile
    println(jarpath)
    val classToLoad = "arash.mllib.MyCrossValidator"
    println(classToLoad)
    val handle = new SparkLauncher()
      .setAppResource(jarpath)
      .setMainClass(classToLoad)
      .setMaster("local")
      .setSparkHome("/home/arashrk/Downloads/spark-1.6.1/")
      .addJar(jarpath)
      .startApplication()
    while (!handle.getState().isFinal()) {
      Thread.sleep(500)
      println(handle.getState())

    }
  }
}
