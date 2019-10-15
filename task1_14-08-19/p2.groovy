class Area {
  double length, breadth

  public void setDim(double len, double bre) {
    this.length = len
    this.breadth = bre
  }

  public double getArea() {
    return length*breadth
  }
}

def r1 = new Area()
println("Enter length")
double len = System.in.newReader().readLine() as double
println("Enter breadth")
double bre = System.in.newReader().readLine() as double

r1.setDim(len, bre)
double area = r1.getArea()

println("Area of rectangle with length = ${len} and breadth = ${bre} is ${area}")
