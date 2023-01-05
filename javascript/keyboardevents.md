# Keyboard event questions

## How do you detect caps lock key turned on or not
var flag = e.getModifierState("CapsLock"); // returns true if on

Top to Bottom(Event Capturing)
Bottom to Top (Event Bubbling)

## Get platform details
console.log(navigator.platform);

## What are the tools or techniques used for debugging JavaScript code
    - Chrome Devtools
    - debugger statement
    - Good old console.log statement

## What is the purpose of void 0
when you click a link, the browser loads a new page or refreshes the same page. But this behavior will be prevented using this expression. For example, the below link notify the message without reloading the page
```
<a href="JavaScript:void(0);" onclick="alert('Well done!')">
  Click Me!
</a>
```

## Get Query string part of the URL
const urlParams = new URLSearchParams(window.location.search);
const clientCode = urlParams.get("clientCode");
⬆
## Make first character uppercase
```
function capitalizeFirstLetter(string) {
return string.charAt(0).toUpperCase() + string.slice(1);
}
```
## What is the way to find the number of parameters expected by a function
```
function sum(num1, num2, num3, num4) {
return num1 + num2 + num3 + num4;
}
sum.length; // 4 is the number of parameters expected.
```

## What are the different ways to make an object non-extensible
You can mark an object non-extensible in 3 ways,

Object.preventExtensions
Object.seal
Object.freeze