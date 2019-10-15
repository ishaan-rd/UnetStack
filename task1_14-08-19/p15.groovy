class Rectangle {
  double length, breadth

  Rectangle(len, bre) {
    this.length = len
    this.breadth = bre
  }

  public void perimeter() {
    println("${2*(length+breadth)}")
  }

  public void area() {
    println("${length*breadth}")
  }
}

class Square extends Rectangle {
  double side

  Square(s) {
    super(s, s)
  }
}

println("Enter length and breadth of rectangle")
double length = System.in.newReader().readLine() as double
println("Length = ${length}")
double breadth = System.in.newReader().readLine() as double
println("Breadth = ${breadth}")

def rec = new Rectangle(length, breadth)
println("Perimeter of rectangle = ")
rec.perimeter()
println("Area of rectangle = ")
rec.area()

// ----------
println("----------\nEnter side of square")
double side = System.in.newReader().readLine() as double
println("Side = ${side}")

def sq = new Square(side)
println("Perimeter of square = ")
sq.perimeter()
println("Area of square = ")
sq.area()
