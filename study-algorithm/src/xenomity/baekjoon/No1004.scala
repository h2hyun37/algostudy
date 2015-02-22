package xenomity.baekjoon

class No1004 {
  def resolve(myPoints: Array[Point], planetPoints: Array[Circle]): Int = {
    var result = 0;
    
    for (i <- 0 to planetPoints.length - 1) {
      if (validate(myPoints(0), planetPoints(i)) || validate(myPoints(1), planetPoints(i))) {
        result += 1
      }
    }
    
    def validate(myPoint: Point, planetPoint: Circle): Boolean = {
      var leftSide = Math.pow(myPoint.getX() - planetPoint.getX(), 2) + Math.pow(myPoint.getY() - planetPoint.getY(), 2)
      var rightSide = Math.pow(planetPoint.getRadius(), 2)
      
      leftSide < rightSide
    }
    
    result
  }
}
  
private class Point(val x: Int, val y: Int) {
  def getX() = x
  def getY() = y
}

private class Circle(override val x: Int, override val y: Int, r: Int) extends Point(x, y) {
  def getRadius() = r
}

object No1004Test {
  def main(args: Array[String]) {
    var no1004 = new No1004

    println(no1004.resolve(
        Array(new Point(-5, 1), new Point(12, 1)),
        Array(new Circle(1, 1, 8), new Circle(-3, -1, 1), new Circle(2, 2, 2), new Circle(5, 5, 1), new Circle(-4, 5, 1), new Circle(12, 1, 1), new Circle(12, 1, 2))))
        
    println(no1004.resolve(
        Array(new Point(-5, 1), new Point(5, 1)),
        Array(new Circle(0, 0, 2))))
  }
}