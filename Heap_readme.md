# Heap Java

Constructing a Heap means initializing an instance of a Heap. All methods of Heap need to be performed on an instance. Therefore, we need to initialize an instance before applying the methods. When creating a Heap, we can simultaneously perform the heapify operation. Heapify means converting a group of data into a Heap.

Time complexity: O(N)
Space complexity: O(N)
```
// In Java, a Heap is represented by a Priority Queue
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Arrays;

// Construct an empty Min Heap
PriorityQueue<Integer> minHeap = new PriorityQueue<>();

// Construct an empty Max Heap
PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

// Construct a Heap with initial elements.
// This process is named "Heapify".
// The Heap is a Min Heap
PriorityQueue<Integer> heapWithValues= new PriorityQueue<>(Arrays.asList(3, 1, 2));
```

> Inserting values in to an already existing minHeap or max heap
> - // Insert an element to the Min Heap: > heapWithValues.add(5);
> - The above operating will take O(Log N) time complexity
> - The above operating will take O(1) space complexity

> Getting the top element:
> - Time Complexity : O(1)
> - heapWithValues.peek() // gets the smallest value since its minheap
> - maxHeap.peek() // gets the largest value since its maxHeap

> Deleting top element:
> - Time complexity: O(log N)
> - Space: O(1)
> - minHeap.poll()

> Getting the size of the heap:
> - minHeap.size() 
> - Time complexity: O(1)

| Heap Method        | Time complexity | Space Complexity |
|--------------------|-----------------|------------------|
| Construct a Heap   | O(N)            | O(N)             |
| Insert an element  | O(Log N)        | O(1)             |
| Delete top element | O(Log N)        | O(1)             |
| Get an element     | O(1)            | O(1)             |
| Get size of heap   | O(1)            | O(1)             |

## Most common use cases of heap:
Heap Sort
The Top-K problem
The K-th element

## Solving the top K problem
# Approach 1
1. Construct a heap - O(N)
2. Traversing and deleting the top element (using pop() or poll() for instance), and store the value into the result array T.

> - Deleting an element takes log N & we do this k times
> - that's why time complexity for this : K Log N
> - Total time complexity = O(N) + O(K log N)

# Approach 2
- Construct a Min Heap with size K.
- Add elements to the Min Heap one by one.
- When there are K elements in the “Min Heap”, compare the current element with the top element of the Heap:
- If the current element is no larger than the top element of the Heap, drop it and - proceed to the next element.
- If the current element is larger than the Heap’s top element, delete the Heap’s top element, and add the current element to the Min Heap .
- Repeat Steps 2 and 3 until all elements have been iterated.
- Time complexity O(N log K) 

