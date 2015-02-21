package xenomity.baekjoon

object No1004 {
  private class Problem {
    def resolve(myPoints: Array[Point], planetPoints: Array[Circle]): Int = {
      var result = 0;
      
      for (i <- 0 to planetPoints.length - 1) {
        var leftSide = Math.pow(myPoints(0).getX() - planetPoints(i).getX(), 2) + Math.pow(myPoints(0).getY() - planetPoints(i).getY(), 2)
        var rightSide = Math.pow(planetPoints(i).getRadius(), 2)
        
        if (leftSide < rightSide) {
          result += 1
        } else {
          leftSide = Math.pow(myPoints(1).getX() - planetPoints(i).getX(), 2) + Math.pow(myPoints(1).getY() - planetPoints(i).getY(), 2)
          
          if (leftSide < rightSide) {
            result += 1
          }
        }
      }
      
      result
    }
  }
    
  private class Point(x: Int, y: Int) {
    def getX() = x
    def getY() = y
  }
  
  private class Circle(x: Int, y: Int, r: Int) {
    def getX() = x
    def getY() = y
    def getRadius() = r
  }
  
  private object AllDone extends Exception {}
  
  def main(args: Array[String]) {
    var problem = new Problem

    println(problem.resolve(
        Array(new Point(-5, 1), new Point(12, 1)),
        Array(new Circle(1, 1, 8), new Circle(-3, -1, 1), new Circle(2, 2, 2), new Circle(5, 5, 1), new Circle(-4, 5, 1), new Circle(12, 1, 1), new Circle(12, 1, 2))))
        
    println(problem.resolve(
        Array(new Point(-5, 1), new Point(5, 1)),
        Array(new Circle(0, 0, 2))))
  }
}