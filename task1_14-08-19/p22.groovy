long fact(int n) {
  return (n < 2) ? 1 : n*fact(n-1)
}

println("Enter number for which you want to find the factorial")
int n = System.in.newReader().readLine() as int

println("Factorial of ${n} is ${fact(n)}")
