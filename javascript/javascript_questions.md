# Javascript interview questions
Reference:
1. https://github.com/sudheerj/javascript-interview-questions
2. https://www.w3docs.com/learn-javascript.html
3. 

## Why js is a dynamic language?

```
var x = 100
console.log(typeof (x)) 
// number

x = "100"
console.log(typeof (x)) 
// string
```

## Data types in js?
1. primitive
    - string
    - number
    - null
    - undefined
    - boolean 
    - big int
    - symbol
2. Objects

## explain undefined ?
undefined means var has been declared but not assigned a value

## explain null ?
intentional absence of data
The value null represents the intentional absence of any object value.

```
var user = null;
console.log(typeof user); //object
```
## explain null versus undefined ?
undefined means not assigned a value

## js hoisting?
where function and variable declaration moved to the top of the scope
example:
```
    console.log(y)
    // undefined
    var y = 10;
```
y outputs undefined because variable declaration is moved to the top of the scope. 
initialization is not moved and thats why it outputs undefined



## if variable is not declared or not initialized. what error do you see?
Reference error.

## Global variables
accessible throughout the web page.
cons:
    - buggy code

## Declaring a variable without the 'var' keyword
It makes the variable global even if its declared in a local function
```
    function f1() {
        y = 10;
    }
    console.log(y);
    // 10
```
## " use strict "
checks if the variable is declared with the var keyword. It'll throw an exception.
```
    "use strict";
    function f1() {
        y = 10;
        // will throw an error here
    }
    
```
## How to avoid or handle global variable?
We can avoid multiple global variables. 
Handling global variables: 
1. Create a namespace and then use the variables so that it doesn't get populated incorrectly
```
    <script>
        var global = {};
        global.mydbconnection = "test";
    </script>
    
```
2. Use closures and return the value through the inner function
```
    <script>
       function dbConnection()  {
            var connString = "test";
       
            function getConnectionString() {
                return connString;
            }
            return {getConnectionString};
       }
       dbConnection.getConnectionString
       
       
    </script>
    
```

## What is a closure?
Its a function inside function and they make the function stateful.
A function along with its lexical environments becomes a closure.

```
    <script>
        function outer() {
            var a = 10;
            function inner() {
                console.log(a);
            }
            return inner;
        
        }
        
        outer()();
        // prints 10, to put it simply it remembers the value of a
        
    </script>
    
```
will run same if I move the variable declaration anywhere else

```
    <script>
        function outer() {
           
            function inner() {
                console.log(a);
            }
             var a = 10;
            return inner;
        
        }
        
        outer()();
        // prints 10, to put it simply it remembers the value of a
        
    </script>
    
```

will run same if I change it from var to let

Lets introduce one more variable here called b

```
    <script>
        function outer(b) {
           
            function inner() {
                console.log(a, b);
            }
             var a = 10;
            return inner;
        
        }
        
        outer("hello ")();
        // prints  hello 10, to put it simply it remembers the value of a and b as they both are part of the closure now
        
    </script>
    
```
Nested closures

```
    <script>
    
    function wrapper () {
            var c = 20
            function outer(b) {
                 var a = 10;
                function inner() {
                    console.log(a, b, c);
                }
                return inner;
        
            }
            
            return outer;
    }
        
        
        wrapper()(" world ")();
        // prints  hello 10 20, to put it simply it remembers the value of a, b and c as they both are part of the closure now
        
    </script>
    
```

What if the there is a conflicting global variable with the same name as 'a'. In that case what does a prints, does the value gets overridden?

```
    <script>
    var a = 100;
    
    function wrapper () {
            var c = 20;
            
            function outer(b) {
                 var a = 10;
           
                function inner() {
                    console.log(a, b, c);
                }
               
                return inner;
        
            }
            
            return outer;
    }
    wrapper()(" world ")();
    // it still prints "hello 10 20"
        
    </script>
    
```

## DisAdvantages of closures?
1. consumes a lot of memory
   - variables are not garbage collected until program expires

2. can lead to memory leaks


## Advantages of closures?
1. module pattern
2. function currying
3. higher order functions like memoization
4. Data hiding and encaspulation


## Data hiding and encapsulation
```
    <script>
    var counter = 100;
    
    function incrementCounter () {
           counter++;
    }
    </script>
```
In this example, counter can be incremented or changed throughout anywhere in the code.But if I put counter in the closure then we hide the data from unnecessary changes.
```
<script>
    
    function Counter () {
        var count = 0;
        
        return function incrementCounter() {
            count++;
            console.log(count);
        }
        
    }
    console.log(count); // reference error
    var counter1 = Counter();
    counter1(); // prints 1
    counter1(); // prints 2
    
   // lets call counter fn again
   var counter2 = Counter(); // this line gets reintialized and resets the value of count to 0
   counter2(); // prints 1
    
    
</script>
```
## How would you design a counter functionality in js?

```
<script>
    
    // this is called a constructor pattern
    function Counter () {
        var count = 0;
        
        this.incrementCounter = function () {
            count++;
            console.log(count);
        }
        this.decrementCounter = function () {
            count++;
            console.log(count);
        }
        
    }
    
    
   // lets create a new counter instance
   var counter2 = new Counter(); // this line gets reintialized and resets the value of count to 0
   counter2.incrementCounter(); // prints 1
   counter2.decrementCounter(); // prints 0
    
    
</script>
```
## GC in js?
- high level languagues, js has its own GC
- free up memory when variables are not used

## Relation between GC and closures
the variables in closure are not garbage collected because the inner function is still referencing the variable. Modern browsers garbage collect variables smartly.
For example,
```
<script>
        function outer(b) {
           var a = 10, x = 100;
            function inner() {
                console.log(a, b);
            }
             
            return inner;
        
        }
        
        outer("hello ")();
        // modern browsers smartly garbage collect var x becacuse its actually not in use
        
</script>
```
## Explain IIFE - Immediately Invoked Function Expression
Its annonymous function which gets invoked immediately. Any variables declared are local to it
```
<script>
        (function outer(b) {
           var a = 10, x = 100;
           console.log(a);
        
        })()
         console.log(a); // ref error
</script>
```
## What is name collision?
same name variable and function exist in the same context
```
<script>
   var Init  = 0;
   function Init() {
   }
   Init(); // ref error : its a variable and not a function
</script>
```
When we have anonymous functions, then it solves this problem

## Design patterns in JS
1. Module Design Pattern
   - self contained / independent components 
   - provides encaspulation and abstraction
   - Module Pattern = IIFE + closure

## Ways to create a JS objects?
```
<script>
   // 1. literal
   var man = {"abc": "shgs" }
   
   // 2. Object.create
   var newMan = Object.create(man);
   
   // 3. constructor
   function Patient () {
      this.name = "";
      this.age  = "";
   }
   var pat1 = new Patient ();
   
   //4. Class
   class Patient {
      constructor (name, address) {
         this.name = "";
         this.address  = "";
      }
   }
   var pat2 = new Patient ();
</script>
```

## Inheritance in js
using prototype object. its object based and not class based inheritance

```
<script>
   
   class Emp {
      constructor (name, address) {
         this.name = "";
         this.address  = "";
      }
      this.doWork = () => {
         alert("basic work")
      }
   }
    class Manager {
      constructor (name) {
         this.teamname = "";
      }
      this.doWork = () => {
         alert("manages team")
      }
   }
   Manager.prototype = Emp;
</script>
```
every js object has a prototype object. prototype object works like a linked list.

## What is prototype chaining?
prototype chaining is the process where the property/ methods are first checked in current object. if not found it goes up the hierarchy and checks the prototype object.

## Explain let
helps you create immediate block level local scope. 

## Are let variables hoisted?
Yes let variables are hoisted but not initialized, whereas var variables are hoisted and declared with undefined
```
<script>
   
  console.log(x) // ref error: var not initialized
  console.log(y) // undefined
  let x = 10
  var y = 100 
</script>
```

## Temporal dead zone
period or state where variables are named in the memory but not initialized with a value

```
<script>
  console.log(x) // Temporal dead zone
  let x = 10  // end of Temporal dead zone
</script>
```

## Difference between let and var
|                   | var                                 | let                                |
|-------------------|-------------------------------------|------------------------------------|
| Scope             | O(scope to immediate function body) | scope to immediate enclosing block |
| Initialized value | value Initialized undefined         | value Initialized nothing          |
```
<script>
      function test () {
         if (1==1) {
            let x = 10
            var y = 100
         }
         console.log(y) // 100
         console.log(x) // reference error
      
      }
</script>
```

## Differences between let,  var and const
- var declarations are globally scoped or function scoped while let and const are block scoped.
- var variables can be updated and re-declared within its scope; let variables can be updated but not re-declared; const variables can neither be updated nor re-declared.
- They are all hoisted to the top of their scope. But while var variables are initialized with undefined, let and const variables are not initialized.
- While var and let can be declared without being initialized, const must be initialized during declaration.

## what would be output?
airthmetic and then concatenation
```
<script>
      console.log(1 + 1 + "world" )
      // 2world
</script>
```
## What is the difference between Call, Apply and Bind
Call: The call() method invokes a function with a given ```this``` value and arguments provided one by one
```
var employee1 = { firstName: "John", lastName: "Rodson" };
var employee2 = { firstName: "Jimmy", lastName: "Baily" };

function invite(greeting1, greeting2) {
  console.log(
    greeting1 + " " + this.firstName + " " + this.lastName + ", " + greeting2
  );
}

invite.call(employee1, "Hello", "How are you?"); // Hello John Rodson, How are you?
invite.call(employee2, "Hello", "How are you?"); // Hello Jimmy Baily, How are you?
```
Apply: Invokes the function with a given this value and allows you to pass in arguments as an array
```
invite.apply(employee1, ["Hello", "How are you?"]); // Hello John Rodson, How are you?
invite.apply(employee2, ["Hello", "How are you?"]); // Hello Jimmy Baily, How are you?
```
bind: returns a new function, allowing you to pass any number of arguments

```
var inviteEmployee1 = invite.bind(employee1);
var inviteEmployee2 = invite.bind(employee2);
inviteEmployee1("Hello", "How are you?"); // Hello John Rodson, How are you?
inviteEmployee2("Hello", "How are you?"); // Hello Jimmy Baily, How are you?
```

## What is the difference between == and === operators?
JavaScript provides both strict(===, !==) and type-converting(==, !=) equality comparison. The strict operators take type of variable in consideration, while non-strict operators make type correction/conversion based upon values of variables. The strict operators follow the below conditions for different types,
  - Two strings are strictly equal when they have the same sequence of characters, same length, and same characters in corresponding positions.
  - Two numbers are strictly equal when they are numerically equal. i.e, Having the same number value. There are two special cases in this,
  - NaN is not equal to anything, including NaN.
  - Positive and negative zeros are equal to one another.
  - Two Boolean operands are strictly equal if both are true or both are false.
  - Two objects are strictly equal if they refer to the same Object.
  - Null and Undefined types are not equal with ===, but equal with ==. i.e, null===undefined --> false but null==undefined --> true
```
0 == false   // true
0 === false  // false
1 == "1"     // true
1 === "1"    // false
null == undefined // true
null === undefined // false
'0' == false // true
'0' === false // false
[]==[] or []===[] //false, refer different objects in memory
{}=={} or {}==={} //false, refer different objects in memory
```
## the difference between lambda or arrow functions ?
1. arrow functions dont have a reference to this
2. they cannot be used as constructors

## Difference between normal and arrow functions

1. Normal Functions
```
// function declaration
function sum(a, b) {
   return a+b;
}
// function expression
const add = function (a, b) {
   return a+b;
}
```
> The main difference between Function declaration and Function expression is we can invoke the function add(2,3) before its declaration also, but the function sum(2,3) needs to invoke after it is defined.

2. Normal Functions
- more concise way to write function expressions
- no declaration approach
```
const add = (a, b) => a+b;
```
- No reference to arguments array. **Normal functions have access to arguments array.**
- ```
  function calcMax() {
   return Math.max(...arguments);
  }
  const arr = [5,4,9,1];
  console.log(calcMax(arr));
  // 9
  ```
- No prototype object for Arrow Functions
- Arrow functions cannot be invoked with a new keyword
- Doesn't have reference to this. if we use this in the arrow function it ll point to the this of the closest non-arrow parent function
  ```
  const user = {
  name: "Jai",
  getUSername: () => { 
      return this.name;
      //refers to window object instead of user object
  }
  }
    ```
- arrow functions do not allow multiple arguments with same name
   ```
  function calcSum(a,a,a)  {
      console.log(a); //3
  }
  calcSum(1,2,3);
  
  //causes syntax error: duplicate parameter name not allowed
  const arrowFn = (a,a,a) => {console.log(a)}
  
  ```
- 



## Difference between rest versus spread operator
> The main difference between rest and spread is that the rest operator puts the rest of some specific user-supplied values into a JavaScript array. But the spread syntax expands iterables into individual elements.

## What is a first class function
In Javascript, functions are first class objects. First-class functions means when functions in that language are treated like any other variable.
For example, in such a language, a function can be passed as an argument to other functions, can be returned by another function and can be assigned as a value to a variable. For example, in the below example, handler functions assigned to a listener

## What is a first order function
First-order function is a function that doesn’t accept another function as an argument and doesn’t return a function as its return value.

const firstOrder = () => console.log("I am a first order function!");

## What is a higher order function
Higher-order function is a function that accepts another function as an argument or returns a function as a return value or both.

## What is a unary function
Unary function (i.e. monadic) is a function that accepts exactly one argument. It stands for a single argument accepted by a function.

## What is the currying function
Currying is the process of taking a function with multiple arguments and turning it into a sequence of functions each with only a single argument. Currying is named after a mathematician Haskell Curry. By applying currying, a n-ary function turns it into a unary function.
```
const multiArgFunction = (a, b, c) => a + b + c;
console.log(multiArgFunction(1, 2, 3)); // 6

const curryUnaryFunction = (a) => (b) => (c) => a + b + c;
curryUnaryFunction(1); // returns a function: b => c =>  1 + b + c
curryUnaryFunction(1)(2); // returns a function: c => 3 + c
curryUnaryFunction(1)(2)(3); // returns the number 6
```
## What is a pure function?
Pure function is a function whose return value is determined by only its aguments without any side feects

## What is memoization?
Memoization is a programming technique which attempts to increase a function’s performance by caching its previously computed results. Each time a memoized function is called, its parameters are used to index the cache. If the data is present, then it can be returned, without executing the entire function. Otherwise the function is executed and then the result is added to the cache. Let's take an example of adding function with memoization,
```
const memoizAddition = () => {
let cache = {};
return (value) => {
if (value in cache) {
console.log("Fetching from cache");
return cache[value]; // Here, cache.value cannot be used as property name starts with the number which is not a valid JavaScript  identifier. Hence, can only be accessed using the square bracket notation.
} else {
console.log("Calculating result");
let result = value + 20;
cache[value] = result;
return result;
}
};
};
// returned function from memoizAddition
const addition = memoizAddition();
console.log(addition(20)); //output: 40 calculated
console.log(addition(20)); //output: 40 cached
```

## What is a service worker
rich offline experience
background sync


## How would you optimize imports in javascript
3 Tips to clean your ES6 imports
> Barrel Pattern: A barrel is a way to rollup exports from several modules into a single convenient module. The barrel itself is a module file that re-exports selected exports of other modules

// structure
- components
-   ---------Accordion.js
-   ---------Button.js

Normally imports would look like:
- import Button from 'components/Button'

But with barrel pattern:
- components
-   ---------Accordion.js
-   ---------Button.js
-   ---------index.js
//index.js
- export {default as Button} from ./Button

- This is how importing looks like:
- import {Button} from "components"

> Use babel.config.js to shorten paths by specifying paths in module-resolver section

## If javascript is single threaded, how does it support async nature
- Js is single threaded
- It has 1 call stack and 1 memory heap
- So how do we get asynchronous code with Javascript then?
- we can thank js engine for the same. Web API recognizes these tasks and handles them to the browser. Once these tasks are finished by the browser, they are returned and pushed back to the call stack.
```
console.log("first")
setTimeout(() => {
console.log("second")
}, 1000)
console.log("third")

this outputs:
first
third
undefined
second
```
How did this work?
- console.log("first") is on the stack first, so it gets printed. Next, the engine notices setTimeout, which isn't handled by Javascript and pushes it off to the WebAPI to be done asynchronously. The call stack moves on without caring about the code handed off to the Web APIs and console.log("three") is printed.
- Next, the Javascript engine's event loop kicks in, like a little kid asking "Are we there yet?" on a road trip. It starts firing, waiting for events to be pushed into it. Since the setTimeout isn't finished, it returns undefined, as the default, well because it hasn't been given the value yet. Once the callback finally does hits we get console.log("second") printed.

## What are child process in Node?
- The fact that Node.js runs in a single thread does not mean that we can’t take advantage of multiple processes and, of course, multiple machines as well.
- Using multiple processes is the best way to scale a Node application. Node.js is designed for building distributed applications with many nodes. This is why it’s named Node. Scalability is baked into the platform and it’s not something you start thinking about later in the lifetime of an application.

## What is indexedDB?

## What is debouncing and throttling

👉 What is DOCTYPE in HTML?

👉 What are the new HTML5 features?

👉 What is Flexbox, Difference between flex and grid?

👉 CSS Frameworks you have used?

👉 What is Rest and Spread operator? show with example.

👉 Difference between map and foreach?

👉 What is the slice and splice method in javascript?

👉 What is Hoisting, and how to avoid hoisting?

👉 Have you worked with promises? what are promises?

👉 What is the difference between promises and async await?

👉 Difference between useMemo and React.memo?

👉 What do you understand by Virtual DOM? Explain its works.

👉 Explain the lifecycle methods of React components?

👉 What is prop drilling and how to avoid it, What is Context API?

👉 Write a code to fetch a list of data from a given API (Using fetch or Axios).

👉 Write a code to remove duplicates from an array Input: [1, 2, 3, 4, 5, 1, 3] => Output: [1, 2, 3, 4, 5].
