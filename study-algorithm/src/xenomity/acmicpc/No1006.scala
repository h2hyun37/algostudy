package xenomity.acmicpc

import scala.collection.mutable.MutableList

object No1006 {
  private class InputData(val n: Int, val w: Int, val innerLineEnermies: Array[Int], val outerLineEnermies: Array[Int]) {}

  def resolve(input: InputData): Int = {
    // initialize
    var result: Int = 0
    val markedList: MutableList[Boolean] = MutableList()
    
    for (i <- 0 until input.n * 2) {
      markedList += false
    }
    
    // horizontal search
    if (input.innerLineEnermies(0) + input.innerLineEnermies(input.n - 1) <= input.w && !markedList(0) && !markedList(input.n - 1)) {
      mark(0, input.n - 1)
    }
    
    if (input.outerLineEnermies(0) + input.outerLineEnermies(input.n - 1) <= input.w && !markedList(input.n) && !markedList(input.n * 2 - 1)) {
      mark(input.n, input.n * 2 - 1)
    }
    
    for (i <- 0 until input.n - 1) {
      for (j <- i + 1 until input.n) {
        if (input.innerLineEnermies(i) + input.innerLineEnermies(j) <= input.w && !markedList(i) && !markedList(j)) {
          mark(i, j)
        }
        
        if (input.outerLineEnermies(i) + input.outerLineEnermies(j) <= input.w && !markedList(i + input.n) && !markedList(j + input.n)) {
          mark(i + input.n, j + input.n)
        }
      }
    }
    
    // vertical search
    for (i <- 0 until input.n) {
      if (input.innerLineEnermies(i) + input.outerLineEnermies(i) <= input.w && !markedList(i) && !markedList(i + input.n)) {
        mark(i, input.n + i)
      }
    }
    
    def mark(i: Int, j: Int) {
      markedList(i) = true
      markedList(j) = true
      
      result += 1
    }
    
    // calculate
    result += markedList.count(_ == false)
    
    result
  }
  
  def main(args: Array[String]) {
    val inputData = new InputData(8, 100, Array(70, 60, 55, 43, 57, 60, 44, 50), Array(58, 40, 47, 90, 45, 52, 80, 40))

    println(resolve(inputData))
  }
}