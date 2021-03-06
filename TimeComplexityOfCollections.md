###### **Cracking the Coding Interview with Leetcode and oher resources**

**ArrayList in Java**
The time complexity of the common operations, at a high level:

add() – takes O(1) time. However, worst-case scenario, when a new array has to be created and all the elements copied to it, is O(n).
add(index, element) – in average runs in O(n) time
get() – is always a constant time O(1) operation
remove() – runs in linear O(n) time. We have to iterate the entire array to find the element qualifying for removal
indexOf() – also runs in linear time. It iterates through the internal array and checking each element one by one. So the time complexity for this operation always requires O(n) time
contains() – implementation is based on indexOf(). 
So it will also run in O(n) time

**LinkedList in Java**
the average estimate of the time we need to perform some basic operations:

add() – appends an element to the end of the list. 
So it only updates a tail, therefore O(1) constant-time complexity.
add(index, element) – in average runs in O(n) time
get() – searching for an element takes O(n) time
remove(element) – to remove an element, we first need to find it. 
This operation is O(n).
remove(index) – to remove an element by index, we first need to follow the links
from the begging , therefore the overall complexity is O(n)
contains() – also has O(n) time complexity

For HashSet, LinkedHashSet, and EnumSet the add(), remove() and contains() 
operations **cost constant O(1)** time. 
Thanks to the internal HashMap implementation.