package xenomity.acmicpc

import scala.collection.mutable.ListBuffer

/*
 * No. 1002
 * 
 * <pre>
 * 이석원은 조규현과 백승환에게 상대편 마린(류재명)의 위치를 계산하라는 명령을 내렸다.
 * 조규현과 백승환은 각각 자신의 터렛 위치에서 현재 적까지의 거리를 계산했다.
 * 조규현의 좌표 (x1, y1)와 백승환의 좌표 (x2, y2)가 주어지고,
 * 조규현이 계산한 류재명과의 거리 r1과 백승환이 계산한 류재명과의 거리 r2가 주어졌을 때,
 * 류재명이 있을 수 있는 좌표의 수를 출력하는 프로그램을 작성하시오.
 * 
 * 첫째 줄에 테스트 케이스의 개수 T가 주어짂다. 각 테스트 케이스는 다음과 같이 구성되어있다.
 * 첫째 줄에 x1, y1, r1, x2, y2, r2가 주어진다.
 * x1, y1, x2, y2는 -10,000보다 크거나 같고, 10,000보다 작거나 같은 정수이고,
 * r1, r2는 10,000보다 작거나 같은 자연수이다.
 * 각 테스트 케이스마다 류재명이 있을 수 있는 위치의 수를 출력한다.
 * 만약 류재명이 있을 수 있는 위치의 개수가 무한대일 경우에는 -1을 출력한다.
 * 
 * -- input
 * 0 0 13 40 0 37
 * 0 0 3 0 7 4
 * 1 1 1 1 1 5
 * 
 * -- output
 * 2
 * 1
 * 0
 * </pre>
 */
class No1002() {
  
  private final var INFINITY = -1;
  
  private def generateNodes(xPoint: Int, yPoint: Int, distance: Int): ListBuffer[Point] = {
    var nodeList = new ListBuffer[Point];
    var currentY = -1;
    
    for (x <- xPoint - distance to xPoint + distance) {
      if (x > xPoint) {
        currentY -= 1;
        
        nodeList += new Point(x, yPoint + currentY);
        nodeList += new Point(x, yPoint - currentY);
      } else {
        currentY += 1;
        
        nodeList += new Point(x, yPoint + currentY);
        nodeList += new Point(x, yPoint - currentY);
      }
      
      // 중복 제거.
      for (i <- 0 to nodeList.length - 2) {
        if (nodeList(i) equals nodeList(i + 1)) {
          nodeList -= nodeList(i + 1);
        }
      }
    }
    
    // debug
    /*for (i <- 0 to nodeList.length - 1) {
      printf("Node [%d, %d]\n", nodeList(i).getX, nodeList(i).getY);
    }*/
    
    nodeList;
  }
  
  def searchNode(input: Array[Int]): Int = {
    if (input.length != 6) {
      throw new IllegalArgumentException;
    }
    
    // 조규환의 후보 노드.
    var 조규환_list = generateNodes(input(0), input(1), input(2));
    
    // 백승환의 후보 노드.
    var 백승환_list = generateNodes(input(3), input(4), input(5));
    
    // 조규환과 백승환의 후보 노드 교집합.
    var duplicated = 0;

    for (i <- 0 to 조규환_list.length - 1) {
      for (j <- 0 to 백승환_list.length - 1) {
        if (조규환_list(i) equals 백승환_list(j)) {
          printf("duplicated point: [%d, %d]\n", 백승환_list(j).getX, 백승환_list(j).getY);
          
          duplicated += 1;
        }
      }
    }
    
    return duplicated;
  }
  
  class Point(x: Int, y: Int) {
    def getX(): Int = x;
    def getY(): Int = y;
    def equals(obj: Point): Boolean = {
      this.x == obj.getX && this.y == obj.getY
    }
  }
  
}

object Resolver {
  def main(args: Array[String]) {
    var problem = new No1002;
    
    printf("1st test: %d\n", problem.searchNode(Array(0, 0, 13, 40, 0, 37)));
    printf("2nd test: %d\n", problem.searchNode(Array(0, 0, 3, 0, 7, 4)));
    printf("3rd test: %d\n", problem.searchNode(Array(1, 1, 1, 1, 1, 5)));
  }
}