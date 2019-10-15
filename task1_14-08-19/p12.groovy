int fib(int n) {
  if(n == 0)
    return 0
  return n <= 2 ? 1 : fib(n-1) + fib(n-2)
}

println("Enter n to get nth Fibonacci number")
int n = System.in.newReader().readLine() as int
println("n = ${n}")
int x = fib(n)
println("Fibonacci number is ${x}")
