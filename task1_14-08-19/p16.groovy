class Shape {
  public void Print() {
    println("This is shape")
  }
}

class Rectangle extends Shape {
  public void Print() {
    println("This is rectangular shape")
  }

  public void PrintShape() {
    super.Print()
  }
}

class Circle extends Shape {
  public void Print() {
    println("This is circular shape")
  }
}

class Square extends Rectangle {
  public void Print() {
    println("Square is a rectangle")
  }

  def PrintRectangle() {
    super.Print()
  }

  public void PrintShape() {
    super.PrintShape()
  }
}

def sq = new Square()
sq.Print()
sq.PrintRectangle()
sq.PrintShape()