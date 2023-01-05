# Questions on Promises

## What is a promise?

promise is an object that may produce a single value (some time in the future).
It has 3 possible states:
 -  fulfilled 
 - rejected 
 - pending

```
const promise = new Promise(function (resolve, reject) {
// promise description
});

// usage
const promise = new Promise(
  (resolve) => {
    setTimeout(() => {
      resolve("I'm a Promise!");
    }, 5000);
  },
  (reject) => {}
);

promise.then((value) => console.log(value));
```
Promises are used to handle asynchronous operations. They provide an alternative approach for callbacks by reducing the callback hell and writing the cleaner code.

## ways to avoid async await
1. Callbacks: callbacks are used in a way to make sure that certain code doesn’t execute until the other code finishes execution.

## What is promise chaining
The process of executing a sequence of asynchronous tasks one after another using promises is known as Promise chaining. Let's take an example of promise chaining for calculating the final result,

## What is promise.all
Promise.all is a promise that takes an array of promises as an input (an iterable), and it gets resolved when all the promises get resolved or any one of them gets rejected. For example, the syntax of promise.all method is below,

## What is the purpose of the race method in promise
Promise.race() method will return the promise instance which is firstly resolved or rejected. Let's take an example of race() method where promise2 is resolved first

```
var promise1 = new Promise(function (resolve, reject) {
setTimeout(resolve, 500, "one");
});
var promise2 = new Promise(function (resolve, reject) {
setTimeout(resolve, 100, "two");
});

Promise.race([promise1, promise2]).then(function (value) {
console.log(value); // "two" // Both promises will resolve, but promise2 is faster
});
```


