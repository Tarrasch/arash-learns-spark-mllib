package arash.mllib

import org.apache.spark.ml.classification.ClassificationModel
import org.apache.spark.ml.PipelineModel
import org.apache.spark.ml.classification.NaiveBayesModel

class SingleInstanceClassifier {

  def main(args: Array[String]): Unit = {
    println(MyCrossValidator.pathToSavedModel)
    val myModel: NaiveBayesModel = NaiveBayesModel.load("hello")
  }
}
