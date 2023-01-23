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

## Difference between fetch and axios
> What is fetch?
- The Fetch API provides a fetch() method defined on the window object. It also provides a JavaScript interface for accessing and manipulating parts of the HTTP pipeline (requests and responses). The fetch method has one mandatory argument- the URL of the resource to be fetched. This method returns a Promise that can be used to retrieve the response of the request.
```
fetch('path-to-the-resource-to-be-fetched')
  .then((response) => {
 
    // Code for handling the response
  })
  .catch((error) => {
 
    // Code for handling the error
  });
```
> What is Axios
- Axios is a Javascript library used to make HTTP requests from node.js or XMLHttpRequests from the browser and it supports the Promise API that is native to JS ES6. It can be used intercept HTTP requests and responses and enables client-side protection against XSRF. It also has the ability to cancel requests. 

| Axios                                                                    | Fetch                                                                       |
|--------------------------------------------------------------------------|-----------------------------------------------------------------------------|
| Axios is a stand-alone third party package that can be easily installed. | Axios is a stand-alone third party package that can be easily installed.    |
| Axios enjoys built-in XSRF protection.	                                  | No such built in protection                                                 |
| It used data property to send something in the header                    | uses body property to send something in the header                          |
| Its data property is an object                                           | the body property needs to be stringified                                   |
| Axios request is ok when **status** is 200 and **statusText** is ‘OK’.	  | 200 Fetch request is ok when response object contains the **ok** property.  |
| automatically response is converted to json                              | its a 2 step process. 1. make the request 2. convert response to json       |
| can cancel request and timeout                                           | no such process                                                             |
| intercept HTTP request                                                   | no way to intercept a request                                               |
| built in support for download progress                                   | no way to intercept a request                                               |
| axios get calls ignore data in the request                               | fetch can have body content with a GET call                                 |

> The immutability of a settled promise is an important feature.

