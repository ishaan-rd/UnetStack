double product(double a, double b) {
  return a*b
}

println("Enter two numbers")
double a = System.in.newReader().readLine() as double
println("a = ${a}")
double b = System.in.newReader().readLine() as double
println("b = ${b}")

double prod = product(a, b)
println("Product of ${a} and ${b} is ${prod}")
