# React interview questions
Reference:
https://github.com/sudheerj/reactjs-interview-questions#what-is-virtual-dom


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
- useState()
- useMemo()
- useContext()
- useRef()
- useReducer()
- 

## context api versus redux

## rules follow for hooks
1. call hooks on the highest level at the top level of component
2. call in functional components and it would not work in class components

## Design patterns


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

## Why is class -> classname in React
class is a reserved in HTML

## Data flow in react
unidirectional - top to bottom

## How to avoid prop drilling?
context api

## API Call after component is mounted
componentDidMount - []

## What is Virtual DOM
- in memory representation of the virtual dom
- sync with real-dom
- 

## HOC
- withRouter : 
- Advantages:
  - add properties like closures
``` 
    function withMouse(Component) {
    return class extends React.Component {
    render() {
    return (
        <Mouse render={mouse => (
        <Component {...this.props} mouse={mouse} />
            )}/>
        );
    }
    }
    }
```

## render props
A component with render prop takes a function which returns a react element.
It calls its own implementation for rendering instead of using  the render logic


## custom hook

share logic between 2 functional components. 
use begins with
they actually don't share the state

```
function FriendStatus(props) {
const [isOnline, setIsOnline] = useState(null);
useEffect(() => {
function handleStatusChange(status) {
setIsOnline(status.isOnline);
}
ChatAPI.subscribeToFriendStatus(props.friend.id, handleStatusChange);
return () => {
ChatAPI.unsubscribeFromFriendStatus(props.friend.id, handleStatusChange);
};
});

if (isOnline === null) {
return 'Loading...';
}
return isOnline ? 'Online' : 'Offline';
}
```

## Accessibility


## What is babel used for?
Web browsers don't understand JSX objects. We need to convert the JSX objects into JS objects, thats where babel is used
Babel transforms JSX into JS file

## React Optimization techniques
1. Event emitters
- In class based components, you could add event emitters on the top level
- In hooks they take up form of use Reducers.
- They basically provide a way for a function to be called in the grand parent component by some event in the child component
2. Memoization
- useMemo hook to remember values of compute intensive functions
3. Virtualization
- Virtualization is a technique that allows you to only render the components that are visible on the screen, rather than rendering the entire component hierarchy. This can be especially useful for optimizing the performance of large lists or grids, as it reduces the number of components that need to be rendered and allows the app to respond more quickly to user interactions.
4. IndexedDB
- IndexedDB is a browser-based database that allows you to store large amounts of data locally in the user’s browser. By using IndexedDB, you can store data locally and retrieve it quickly, rather than having to make a roundtrip to the server every time you need to access it. This can be especially useful for optimizing the performance of apps that deal with a lot of data, such as trading apps.
5. Stream data and not load all the data at once
6. Lazy Loading
- Lazy loading is a technique that allows you to only load the components that are needed at a given time, rather than loading the entire component hierarchy upfront. This can be especially useful for optimizing the performance of large apps with many components, as it reduces the amount of data that needs to be loaded at once and allows the app to respond more quickly to user interactions.
7. React Suspense
- React Suspense is a new feature in React that allows you to declaratively specify how your app should behave while data is being loaded. This can be especially useful for optimizing the performance of apps that deal with a lot of data, as it allows you to specify how the app should behave while data is being loaded, rather than having to manage this manually.


