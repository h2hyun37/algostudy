package com.xenomity.spark

import org.apache.spark.SparkConf
import org.apache.spark.SparkContext
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.Assert
import org.junit.Before
import org.junit.After
import org.apache.spark.rdd.RDD
import org.apache.spark.Accumulator
import org.apache.spark.broadcast.Broadcast

class SparkTest {
  private final val APP_NAME: String = "test-spark"
	private final val MODE_LOCAL: String = "local"
	private final var sc: SparkContext = _
	
	@Before
	def setUp {
    val config = new SparkConf().setAppName(APP_NAME).setMaster(MODE_LOCAL)
		sc = new SparkContext(config)
  }
  
  @Test
  def testParallelizedCollections {
    val data: Range = 1 to 1000000000
    val distData: RDD[Int] = sc parallelize data
    
    // assertion.
    Assert.assertEquals(distData count, data length)
  }
  
  @Test
  def testRddOperations {
    val data: RDD[String] = sc.textFile(this.getClass().getClassLoader().getResource("data.txt").getFile())
    
    // #1. total size.
    val lineLengths: RDD[Int] = data map { d => d.length }
    //lineLengths.persist()
    val size: Int = lineLengths reduce { (a, b) => a + b }
    
    printf("total size: %d\n", size)
    
    // #2. word grouping size.
    data.map(x => (x, 1)).countByKey().foreach(x => println(x))
  }
  
  @Test
  def testAccumulators {
	  var sum: Int = 0  // closure free variable.
    val accum: Accumulator[Int] = sc accumulator 0
    
    sc.parallelize(1 to 1000).foreach(x => sum += x)
    sc.parallelize(1 to 1000).foreach(x => accum += x)
    
    printf("accumulator sum: %d, closure free variable sum: %d\n", accum.value, sum)
    
    // assertion.
    Assert.assertNotEquals(accum.value, sum)
  }
  
  @Test
  def testBroadcastVariables {
    val data: Range = 1 to 1000
    val commons: Broadcast[Range] = sc broadcast data
    
    // assertion.
    Assert.assertEquals(commons.value, data)
  }
  
  @After
  def tearDown {
    if (sc != null) {
      sc stop
    }
  }
}