import util.CommandLineOptions
import util.FileUtil
import org.apache.spark.{SparkConf, SparkContext}
import org.apache.spark.SparkContext._

/**
  * Created by bachi on 10/2/2016.
  */

object InvertedIndexSort {
  def main(args: Array[String]): Unit = {
    System.setProperty("hadoop.home.dir","C:\\Users\\bachi\\Downloads\\Pavan\\winutils")
    val options = CommandLineOptions(
      this.getClass.getSimpleName,
      CommandLineOptions.inputPath("output/crawl"),
      CommandLineOptions.outputPath("output/inverted-index"),
      CommandLineOptions.master("local"),
      CommandLineOptions.quiet)

    val argz   = options(args.toList)
    val master = argz("master")
    val quiet  = argz("quiet").toBoolean
    val out    = argz("output-path")
    if (master.startsWith("local")) {
      if (!quiet) println(s" **** Deleting old output (if any), $out:")
      FileUtil.rmrf(out)
    }

    val name = "Inverted Index (5b)"
    val conf = new SparkConf().
      setMaster(master).
      setAppName(name).
      set("spark.app.id", name)   // To silence Metrics warning.
    val sc = new SparkContext(conf)
    try { val lineRE = """^\s*\(([^,]+),(.*)\)\s*$""".r
    val input = sc.textFile(argz("input-path")).map {
      case lineRE(name, text) => (name.trim, text.toLowerCase)
      case badLine =>
        Console.err.println(s"Unexpected line: $badLine")
        // If any of these were returned, you could filter them out below.
        ("", "")
    }  // RDD[(String,String)] of (path,text) pairs

    if (!quiet) println(s"Writing output to: $out")

    // Split on non-alphabetci sequences of character as before.
    // Rather than map to "(word, 1)" tuples, we treat the words by values
    // and count the unique occurrences.
    input
      .flatMap {
        // all lines are two-tuples; extract the path and text into variables
        // named "path" and "text".
        case (path, text) =>
          // If we don't trim leading whitespace, the regex split creates
          // an undesired leading "" word!
          text.trim.split("""[^\p{IsAlphabetic}]+""").map(word => (word, path))
      }  // RDD[(String,String)] of (word,path) pairs
      .map {
      // We're going to use the (word, path) tuple as a key for counting
      // all of them that are the same. So, create a new tuple with the
      // pair as the key and an initial count of "1".
      case (word, path) => ((word, path), 1)
    }  // RDD[((String,String),Int)] of ((word,path),1) pairs
      .reduceByKey{    // Count the equal (word, path) pairs, as before
      (count1, count2) => count1 + count2
    }  // RDD[((String,String),Int)], now with unique (word,path) and int value >= 1
      // In the function passed to reduceByKey, we could use placeholder "_", one
      // for each argument: .reduceByKey(_ + _)
      .map {           // Rearrange the tuples; word is now the key we want.
      case ((word, path), n) => (word, (path, n))
    }  // RDD[(String,(String,Int))]
      .groupByKey      // There is a also a more general groupBy
      // New: sort by Key (word).
      .sortByKey(ascending = true)
      // RDD[(String, Iterable[(String,Int)]]
      // New: sort the sequence by count, descending,
      // and also by path, which isn't strictly necessary, but doing so
      // ensures that unit tests pass predictably!
      // Then, reformat the output; make a string of each group,
      // a sequence, "(path1, n1), (path2, n2), (path3, n3), ..."
      // mapValues is like the following map, but more efficient, as we skip
      // pattern matching on the key ("word"), etc.
      // .map {
      //   case (word, iterable) => (word, iterable.toSeq...mkString(", "))
      // }
      .mapValues { iterable =>
      iterable.toSeq.sortBy { case (path, n) => (-n, path) }.mkString(", ")
    }
      .saveAsTextFile(out)
    } finally {
      // This is a good time to look at the web console again:
      if (! quiet) {
        println("""
                  |========================================================================
                  |
                  |    Before closing down the SparkContext, open the Spark Web Console
                  |    http://localhost:4040 and browse the information about the tasks
                  |    run for this example.
                  |
                  |    When finished, hit the <return> key to exit.
                  |
                  |========================================================================
                """.stripMargin)
        Console.in.read()
      }
      sc.stop()
    }
  }
}