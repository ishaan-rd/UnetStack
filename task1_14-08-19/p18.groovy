abstract class Parent {
  abstract public void message()
}

class first extends Parent {
  public void message() {
    println("This is the first subclass")
  }
}

class second extends Parent {
  public void message() {
    println("This is the second subclass")
  }
}

def f = new first()
f.message()

def s = new second()
s.message()
