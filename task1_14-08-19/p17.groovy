class AddAmount {
  double amount = 50

  AddAmount() {}

  AddAmount(double am) {
    this.amount += am
  }

  public double getAmount() {
    return this.amount
  }
}

println("Do you want to add amount to piggy bank? (y/n)")
char ans = System.in.newReader().readLine() as char

if(ans == 'y') {
  println("Enter the amount to add")
  double am = System.in.newReader().readLine() as double
  def a = new AddAmount(am)
  println("Amount in piggy bank = \$${a.getAmount()}")
}
else if(ans == 'n') {
  def a = new AddAmount()
  println("Amount in piggy bank = \$${a.getAmount()}")
}
else {
  println("Invalid option letter: ${ans}")
}
