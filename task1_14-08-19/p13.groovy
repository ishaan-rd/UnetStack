boolean perfect(int n) {
  int sum = 0
  for(int i=1; i<=(n/2); i++) {
    if(n % i == 0)
      sum += i
  }

  if(sum == n)
    return true
  return false
}

for(int i=1; i<=33550336; i++) {
  boolean x = perfect(i)
  //printf("${x} ")
  if(x)
    println("${i}")
}
