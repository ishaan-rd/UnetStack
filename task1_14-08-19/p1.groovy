class triangle {
  int perimeter, p
  double area

  triangle(side1, side2, side3) {
    this.perimeter = side1+side2+side3
    this.p = perimeter/2

    area = Math.sqrt(p*(p-side1)*(p-side2)*(p-side3))
  }
}

def t1 = new triangle(3, 4, 5)
println("Perimeter = ${t1.perimeter} and Area = ${t1.area}")