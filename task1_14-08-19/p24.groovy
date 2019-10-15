int i=1
def lst = []
println("${i++}: $lst")

// add some elements
lst.add('dog')
lst.add('cat')
lst.add('elephant')
lst.add('tiger')
lst.add('fox')
lst.add('zebra')
println("${i++}: $lst")

// insert a value at the beginning
lst.add(0, 'horse')
println("${i++}: $lst")

// get the third and last second element
println("${i++}: ${lst[2]}")
println("${i++}: ${lst[-2]}")

// update an element
lst[3] = 'rabbit'
println("${i++}: $lst")

// remove the third element
lst.remove(2)
println("${i++}: $lst")

// search for an element
println("${i++}: ${lst.find { it -> it == 'tiger' }}")
println("${i++}: ${lst.find { it -> it == 'monkey' }}")

// iterate through all elements
// using loop
println("-----\n${i++}: using loop\n-----")
for (int j=0; j<lst.size(); j++) {
  println("${lst[j]}")
}

// creating an iterator
println("-----\n${i++}: using iterator\n-----")
Iterator<Integer> it = lst.iterator()
while(it.hasNext()) {
  println("${it.next()}")
}

// using ListIterator
println("-----\n${i++}: using ListIterator\n-----")
lst.each {
  println("${it}")
}
