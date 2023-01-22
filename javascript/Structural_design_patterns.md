# Structural Design Patterns

## Adapter Pattern
- The Adapter allows two objects with incompatible interfaces to interact with each other.
```
// Our array of cities
// habitant pop
const citiesHabitantsInMillions = [
    { city: "London", habitants: 8.9 },
    { city: "Rome", habitants: 2.8 },
    { city: "New york", habitants: 8.8 },
    { city: "Paris", habitants: 2.1 },
] 

// The new city we want to add
const BuenosAires = {
    city: "Buenos Aires",
    habitants: 3100000
}

// Our adapter function takes our city and converts the habitants property to the same format all the other cities have
const toMillionsAdapter = city => { city.habitants = parseFloat((city.habitants/1000000).toFixed(1)) }

toMillionsAdapter(BuenosAires)

// We add the new city to the array
citiesHabitantsInMillions.push(BuenosAires)
```
## Decorator Pattern
- The Decorator pattern lets you attach new behaviors to objects by placing them inside wrapper objects that contain the behaviors. If you're somewhat familiar with React and higher order components (HOC) this kind of approach probably rings a bell for you. 
- One more example would Context Provide and then use Context hook


## Facade Pattern
- The Facade pattern provides a simplified interface to a library, a framework, or any other complex set of classes.
- A simple example could be JavaScript's map, sort, reduce and filter functions, which all work like good 'ol for loops beneath the hood.

## Proxy Pattern
- The Proxy pattern provides a substitute or placeholder for another object. The idea is to control access to the original object, performing some kind of action before or after the request gets to the actual original object.
- Example, middleware pattern of expressJS
- Execute function authenticate token before executing the router GET request
- or submitting metrics to Elastic Search logs



