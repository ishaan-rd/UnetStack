abstract class parent {
  parent() {
    println("This is constructor of abstract class")
  }

  abstract public void a_method()

  public void method() {
    println("This is a normal method of abstract class")
  }
}

class SubClass extends parent {
  public void a_method() {
    println("This is an abstract method")
  }
}

def sc = new SubClass()
sc.a_method()
sc.method()
