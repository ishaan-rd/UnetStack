class AddDistance {
  int f, i

  public void add(int af, int ai, int bf, int bi) {
    f = af+bf
    i = ai+bi
    if (i >= 12) {
      f = f+(i/12)
      i = i%12
    }
  }
}

def d1 = new AddDistance()

println("Enter feet and inches input 1")
int af = System.in.newReader().readLine() as int
println("feet = ${af}")
int ai = System.in.newReader().readLine() as int
println("inches = ${ai}")

println("\nEnter feet and inches input 2")
int bf = System.in.newReader().readLine() as int
println("feet = ${bf}")
int bi = System.in.newReader().readLine() as int
println("inches = ${bi}")

d1.add(af, ai, bf, bi)

println("Result is ${d1.f} feet, ${d1.i} inches")
