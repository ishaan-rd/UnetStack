class something {
  public void method(int n, char c) {
    println("This method takes int and char respectively")
    println("int = ${n} and char = ${c}")
  }

  public void method(char c, int n) {
    println("This method takes char and int respectively")
    println("char = ${c} and int = ${n}")
  }
}

def s = new something()

println("Enter an integer")
int n = System.in.newReader().readLine() as int
println("You entered: ${n}")

println("Enter a character")
char c = System.in.newReader().readLine() as char
println("You entered: ${c}")

s.method(n, c)
s.method(c, n)
