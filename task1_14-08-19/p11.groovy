String grade(int m) {
  if(m > 90 && m <=100)
    return "AA"
  else if(m > 80 && m < 91)
    return "AB"
  else if(m > 70 && m < 81)
    return "BB"
  else if(m > 60 && m < 71)
    return "BC"
  else if(m > 50 && m < 61)
    return "CC"
  else if(m > 40 && m < 51)
    return "CD"
  else if(m <= 40 && m >= 0)
    return "Fail"
  else
    return "Invalid marks"
}

println("Enter your marks")
int marks = System.in.newReader().readLine() as int
String res = grade(marks)
if(res == "Invalid marks")
  println("${res} entered")
else if(res == "Fail")
  println("You failed")
else
  println("Grade is ${res}")