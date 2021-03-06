/**
  * Created by Pavan on 12/30/2016.
  */

import org.apache.spark.{SparkConf,SparkContext}
import scala.annotation.tailrec
import scala.util.Random


object sort {
def main(args: Array[String]) {
    val conf = new SparkConf().setAppName("MergeSort").setMaster("local")
    val sc = new SparkContext(conf)
    val list = Seq.fill(50000)(Random.nextInt(500)).toList
    println(msort(list))
  }

  def msort[T <% Ordered[T]](xs: List[T]): List[T] = {  
    @tailrec
    def merge(res: List[T], xs: List[T], ys: List[T]): List[T] = (xs, ys) match {
      case (_, Nil) => res.reverse ::: xs
      case (Nil, _) => res.reverse ::: ys
      case (x :: xs1, y :: ys1) =>
        if (x < y) merge(x :: res, xs1, ys)
        else merge(y :: res, xs, ys1)
    }
    val n = xs.length / 2
    if (n == 0) xs
    else {
      val (ys, zs) = xs splitAt n
      merge(Nil, msort(ys), msort(zs))
    }
  }  
}
