# Sets

## Initialize a set
```
const numSet = new Set();

numSet.add(1);
numSet.has(5) // false
numSet.has(1) // true
numSet.add(5);

numSet.delete(5);

for (const item of numSet) {
  console.log(item);
}
// 1

```

## converting between Set and Array
```
const mySet2 = new Set([1, 2, 3, 4]);
console.log(mySet2.size); // 4
console.log([...mySet2]); // [1, 2, 3, 4]
```

## forEach
```
new Set(['foo', 'bar']).forEach((element) => console.log(element)));
```

## Difference between arrays and set
* Arrays are an indexed collection. 
* Sets are an keyed collection.
* A Set’s elements are iterable in the order of insertion, and it cannot contain any duplicate data.
* Main benefits of Set over array:
  * Search for an Item:
    * includes and indexOf is used an array
    * has("val") is used by Set
  * Delete an item:
    * In Set, delete item by value
    * array needs to splice
  * Insert an item:
    * In arrays we use push or unshift to add elements
    * In set use "add"
  * Storing NaN:
    * Arrays cannot be used to store NaN. Cannot run indexOf(NaN) or includes(NaN) to find a NaN value
    * Set can be used to store NaN
  * Time Complexity:
    * The methods an array uses to search for items has a linear time complexity of O(N).
    *  the methods used by Sets to search for, delete and insert items all have a time complexity of just O(1) — that means the size of the data has virtually no bearing on the run-time of these methods!