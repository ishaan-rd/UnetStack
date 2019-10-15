def map1 = [red: 1, blue: 2, green: 3, yellow: 4]
println("Your map = ${map1}")
println("Map size = ${map1.size()}")

// copy all values to another map
def map2 = map1
println("Cloned map = ${map2}")

map1 = [:]
println("Your map = ${map1}")

if(map1.size())
  println("Map not empty")
else
  println("Map is empty")
  