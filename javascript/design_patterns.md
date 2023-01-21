# Design Patterns

## Singleton Pattern
- It's a design pattern where we have a single point of truth. Its an immutable instance of an object.
- It's basically an object that cant be copied or modified.
- example, like setting a config which shouldnt be mutable
```
// using a class reference
class Config {
constructor() {}
start(){ console.log('App has started') }  
update(){ console.log('App has updated') }
}

const instance = new Config()
Object.freeze(instance)


// using an object reference
const Config = {
start: () => console.log('App has started'),
update: () => console.log('App has updated'),
}

// We freeze the object to prevent new properties being added and existing properties being modified or removed
Object.freeze(Config)

Config.start() // "App has started"
Config.update() // "App has updated"

Config.name = "Robert" // We try to add a new key
console.log(Config) // And verify it doesn't work: { start: [Function: start], update: [Function: update] }
```

## Factory Method Pattern
- Provides an interface for creating objects that can be modified later.
- logic for creation of object is at a single place
```
class Alien {
constructor (name, phrase) {
this.name = name
this.phrase = phrase
this.species = "alien"
}
fly = () => console.log("Zzzzzziiiiiinnnnnggggg!!")
sayPhrase = () => console.log(this.phrase)
}

const alien1 = new Alien("Ali", "I'm Ali the alien!")
console.log(alien1.name) // output: "Ali"
```

## Abstract Factory Pattern
- allows to create objects of different types of classes belonging to a same family
- adds abstraction layer above factory pattern
```
// We have a class or "concrete factory" for each vehicle type
class Car {
constructor () {
this.name = "Car"
this.wheels = 4
}
turnOn = () => console.log("Chacabúm!!")
}

class Truck {
constructor () {
this.name = "Truck"
this.wheels = 8
}
turnOn = () => console.log("RRRRRRRRUUUUUUUUUMMMMMMMMMM!!")
}

class Motorcycle {
constructor () {
this.name = "Motorcycle"
this.wheels = 2
}
turnOn = () => console.log("sssssssssssssssssssssssssssssshhhhhhhhhhham!!")
}

// And and abstract factory that works as a single point of interaction for our clients
// Given the type parameter it receives, it will call the corresponding concrete factory
const vehicleFactory = {
createVehicle: function (type) {
switch (type) {
case "car":
return new Car()
case "truck":
return new Truck()
case "motorcycle":
return new Motorcycle()
default:
return null
}
}
}

const car = vehicleFactory.createVehicle("car") // Car { turnOn: [Function: turnOn], name: 'Car', wheels: 4 }
const truck = vehicleFactory.createVehicle("truck") // Truck { turnOn: [Function: turnOn], name: 'Truck', wheels: 8 }
const motorcycle = vehicleFactory.createVehicle("motorcycle") // Motorcycle { turnOn: [Function: turnOn], name: 'Motorcycle', wheels: 2 }
```

