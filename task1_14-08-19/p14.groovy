float taxCalculator(float salary, float savings) {
  float sv = savings
  if (sv > 100000)
    sv = 100000
  float taxin = salary - sv

  if(taxin <= 0)
    return -1

  float tax = 0
  if(taxin <= 100000)
    tax = 0
  else if(taxin <= 200000) {
    tax = 0.1 * (taxin - 100000)
  }
  else if(taxin <= 500000) {
    tax = 0.1 * (200000 - 100000) + 0.2 * (taxin - 200000)
  }
  else if(taxin > 500000) {
    tax = 0.1 * (100000) + 0.2 * (300000) +
          0.3 * (taxin - 500000)
  }

  return tax
}

println("Enter gross salary")
float salary = System.in.newReader().readLine() as float
println("Gross Salary = ${salary}")
println("Enter total savings")
float savings = System.in.newReader().readLine() as float
println("Total Savings = ${savings}")

float tax = taxCalculator(salary, savings)

if(tax == -1)
  println("Invalid salary and savings")
else
  println("Tax for \$${salary} and \$${savings} is \$${tax}")
