# React interview questions

## What are the major features of React?
- It uses VirtualDOM instead of RealDOM considering that RealDOM manipulations are expensive.
- Supports server-side rendering.
- Follows Unidirectional data flow or data binding.
- Uses reusable/composable UI components to develop the view.

## What is JSX
JSX is a XML-like syntax extension to ECMAScript (the acronym stands for JavaScript XML). Basically it just provides syntactic sugar for the React.createElement() function, giving us expressiveness of JavaScript along with HTML like template syntax.

## What are Pure Components?
- React.PureComponent is exactly the same as React.Component except that it handles the shouldComponentUpdate() method for you.
- When props or state changes, PureComponent will do a shallow comparison on both props and state. Component on the other hand won't compare current props and state to next out of the box.

## What is the difference between HTML and React event handling?
- In HTML, the event name usually represents in lowercase as a convention:
<button onclick={} > -> HTML
<button onClick={} > -> React
- In HTML, you can return false to prevent default behavior
- In React, event.preventDefault()
- In HTML, you need to invoke the function by appending () Whereas in react you should not append () with the function name.


## What is "key" prop and what is the benefit of using it in arrays of elements?
A key is a special string attribute you should include when creating arrays of elements. Key prop helps React identify which items have changed, are added, or are removed.

## Hooks in React

- useEffect() - call API
- 

## ref Hook in React

## error boundaries in new react


## What is Virtual DOM?
The Virtual DOM (VDOM) is an in-memory representation of Real DOM. The representation of a UI is kept in memory and synced with the "real" DOM. It's a step that happens between the render function being called and the displaying of elements on the screen. This entire process is called reconciliation.

## HOC
- A higher-order component (HOC) is a function that takes a component and returns a new component. Basically, it's a pattern that is derived from React's compositional nature.
- We call them pure components because they can accept any dynamically provided child component but they won't modify or copy any behavior from their input components.

const EnhancedComponent = higherOrderComponent(WrappedComponent);

## setState with a dynamic key name
this.setState({ [event.target.id]: event.target.value })

## Why fragments are better than container divs?
- Fragments are a bit faster and use less memory by not creating an extra DOM node. This only has a real benefit on very large and deep trees.
- Some CSS mechanisms like Flexbox and CSS Grid have a special parent-child relationships, and adding divs in the middle makes it hard to keep the desired layout.
- The DOM Inspector is less cluttered.

## What are portals
Portal is a recommended way to render children into a DOM node that exists outside the DOM hierarchy of the parent component.

## What is strict mode in React?
React.StrictMode is a useful component for highlighting potential problems in an application. Just like <Fragment>, <StrictMode> does not render any extra DOM elements. It activates additional checks and warnings for its descendants. These checks apply for development mode only.

## What is debouncing in react in useEffect

const call = setTimeout(() => {} , 2000);
return clearTimeout(call);

## Improve Performance: Lazy loading
```
const Lorem = React.lazy(() => import(./Home));

return (
    <Suspense fallback={<Loading />}>
            <Lorem />
    </Suspense>
);

```
## Improve Performance: Code splitting
webpack create multiple code bundles
```

import("./Home").then(() => {
    console.log("Home imported")
})
```

## Keyboard accessibility in react

## Screen readers in react

## SEO on webpage



