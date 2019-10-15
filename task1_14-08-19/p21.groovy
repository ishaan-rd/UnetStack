class A {
  public static void method() {
    println("Parent")
  }
}

class B extends A {
  public static void method() {
    println("Child")
  }
}

A a = new A()
a.method()

B b = new B()
b.method()

A obj = new B()
obj.method()
