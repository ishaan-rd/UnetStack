class Average {
  double avg, n1, n2, n3

  public void calcAvg(double a, double b, double c) {
    n1 = a
    n2 = b
    n3 = c
    avg = (n1+n2+n3)/3
  }

  public void printAvg() {
    println("Average of ${n1}, ${n2} and ${n3} is ${avg}")
  }
}

def avg = new Average()
println("Enter the numbers")
double a = System.in.newReader().readLine() as double
println("a = ${a}")
double b = System.in.newReader().readLine() as double
println("b = ${b}")
double c = System.in.newReader().readLine() as double
println("c = ${c}")

avg.calcAvg(a, b, c)
avg.printAvg()
