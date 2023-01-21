## Js Map
- The Map object holds key-value pairs and remembers the original insertion order of the keys

## Initialize and basic operations

```
const map1 = new Map();

map1.set('a', 1);
map1.set('b', 2);
map1.set('c', 3);

console.log(map1.get('a'));
// Expected output: 1

map1.set('a', 97);

console.log(map1.get('a'));
// Expected output: 97

console.log(map1.size);
// Expected output: 3

map1.delete('b');

console.log(map1.size);
// Expected output: 2

```

## Objects versus Map


| Map                                                                                | Objects                                                                                                       |
|------------------------------------------------------------------------------------|---------------------------------------------------------------------------------------------------------------|
| Map doesn't contains key be default. It only puts what you add                     | Object has a prototype so it contains default keys.                                                           |
| Map safe to use with user provided key values.	                                    | Not safe to use. can lead to object injection attacks. may allow an attacker to override the object prototype |
| Maps keys can be any value - function/string/object or any primitive               | only string literal or symbol  allowed                                                                        |
| Iterates based on Order of insertion                                               | no specific order. best not to reply on property order.                                                       |
| Number of items in a Map easily retrieved by size property.	                       | No direct way to determine size                                                                               |
| Map is iterable, can be directly iterated on                                       | not directly iterable                                                                                         |
| performs better with scenroios of frequent addition and removal of key-value pairs | not optimized for frequent addition and removals                                                              |
| No native support for serialization and parsing. JSON.stringify() / JSON.parse()   | Native support with JSON and JSON.stringify                                                                   |


## Setting object properties

> Important note:
* > const wrongMap = new Map();
* > wrongMap['bla'] = 'blaa';
* > wrongMap.has('bla') // false
  > Its important to understand that this is like setting a property on the object  and thats why operations like get or has will fail

## Iterating on Map
```
const myMap = new Map();
myMap.set(0, 'zero');
myMap.set(1, 'one');

for (const [key, value] of myMap) {
console.log(`${key} = ${value}`);
}

for (const key of myMap.keys()) {
  console.log(key);
}
// 0
// 1

for (const value of myMap.values()) {
  console.log(value);
}
// zero
// one

for (const [key, value] of myMap.entries()) {
  console.log(`${key} = ${value}`);
}
// 0 = zero
// 1 = one

myMap.forEach((value, key) => {
  console.log(`${key} = ${value}`);
});
// 0 = zero
// 1 = one

```