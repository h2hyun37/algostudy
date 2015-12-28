package com.xenomity.spark

import org.apache.spark.SparkContext
import org.apache.spark.SparkConf

object WordCount {
  def main(args: Array[String]) {
    if (args.length != 2) {
      throw new IllegalArgumentException("required two lanching parameters.")
    }
    
    val sc = new SparkContext(new SparkConf().setAppName("word count"))
    val threshold = args(1).toInt
 
    // split each document into words
    val tokenized = sc.textFile(args(0)).flatMap(_.split(" "))
 
    // count the occurrence of each word
    val wordCounts = tokenized.map((_, 1)).reduceByKey(_ + _)
 
    // filter out words with less than threshold occurrences
    val filtered = wordCounts.filter(_._2 >= threshold)
 
    // count characters
    val charCounts = filtered.flatMap(_._1.toCharArray).map((_, 1)).reduceByKey(_ + _)
 
    System.out.println(charCounts.collect().mkString(", "))
  }
}