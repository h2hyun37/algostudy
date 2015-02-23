package xenomity.acmicpc

/**
 * ACMICPC No.1004
 */
class No1004 {
  def resolve(myPoints: Array[Point], planetPoints: Array[Circle]): Int = {
    planetPoints.count((planetPoint) => validate(myPoints(0), planetPoint) || validate(myPoints(1), planetPoint))
  }
  
  private def validate(myPoint: Point, planetPoint: Circle): Boolean = {
    val leftSide = Math.pow(myPoint.x - planetPoint.x, 2) + Math.pow(myPoint.y - planetPoint.y, 2)
    val rightSide = Math.pow(planetPoint.radius, 2)
    
    leftSide < rightSide
  }
}
  
private class Point(val x: Int, val y: Int) {}

private class Circle(override val x: Int, override val y: Int, val radius: Int) extends Point(x, y) {}

object No1004Test {
  def main(args: Array[String]) {
    val no1004 = new No1004

    println(no1004.resolve(
        Array(new Point(-5, 1), new Point(12, 1)),
        Array(new Circle(1, 1, 8), new Circle(-3, -1, 1), new Circle(2, 2, 2), new Circle(5, 5, 1), new Circle(-4, 5, 1), new Circle(12, 1, 1), new Circle(12, 1, 2))))
        
    println(no1004.resolve(
        Array(new Point(-5, 1), new Point(5, 1)),
        Array(new Circle(0, 0, 2))))
  }
}