boolean isOdd(int a) {
  return a%2
}

println("Enter a number")
int a = System.in.newReader().readLine() as int
println("You've entered ${a}")
boolean x = isOdd(a)
if(x)
  println("${a} is Odd")
else
  println("${a} is Even")