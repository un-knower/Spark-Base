package com.cloudera.sparkwordcount

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

/**
  * Created by steven on 2017/7/31.
  */
object testRDD {
  def main(args: Array[String]): Unit = {
    val sc = new SparkContext(new SparkConf().setAppName("Steven005").setMaster("local"))

    //-----------------------------------------------------------------------------------
    val rdd03 = sc.parallelize(list, 1)
    val r03 = rdd03.map { x => x + 1 }
    println(r03.collect().mkString(","))

    val r04 = rdd03.filter { x => x > 3 }
    println(r04.collect().mkString(","))

    //新建Tuple
    val pair = (99, "Luftballons", sc.getConf.toString)
    println(pair._3)

    val rdd = sc.textFile("1.txt", 1);
    val r = rdd.flatMap { x => x.split(" ") }
    println(r.collect().mkString(","))
    //-----------------------------------------------------------------------------------
    /*Transformation &
    去重distinct()，合并union()，共同元素intersection()，去掉两个RDD相同的元素subtract()，
    笛卡尔积cartesian()
    */
    /* Action
    返回所有元素collect()，个数count()，各元素出现次数countByValue()，并行整合所有元素reduce()。
    fold(0)(func)，aggregate(0)(seqOp,combop)，对每个元素使用特定函数foreach(func)
    */

    val rddInt: RDD[Int] = sc.makeRDD(List(1, 2, 3, 4, 5, 6, 2, 5, 1))
    val rddStr: RDD[String] = sc.parallelize(Array("a", "b", "c", "d", "b", "a"), 1)
    val rddFile: RDD[String] = sc.textFile("1.txt", 1)

    val rdd01: RDD[Int] = sc.makeRDD(List(1, 3, 5, 3))
    val rdd02: RDD[Int] = sc.makeRDD(List(2, 4, 5, 1))

    /* map操作 */
    println("======map操作======")
    println(rddInt.map(x => x + 1).collect().mkString(","))
    println("======map操作======")


  }

}
