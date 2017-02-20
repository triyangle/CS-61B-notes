# Midterm 2 Notes

## Interfaces
* Every method in interface must be `public` (`public` by default)
* Variables will be `public static final`, no instance variables for interfaces


## Abstract Classes
* `abstract` keyword for `abstract` methods
* Can provide any kind of variables & methods
* Subclasses can only `extend` one (`abstract`) class


## Autoboxing
* Arrays never autoboxed/unboxed (e.g. `Integer[]` cannot be used in place of `int[]` & vice versa)
* Can cast `int` to `Integer`


### Promotion/Primitive Widening
* Similar thing happens when moving from primitive type w/ narrower range to wider range
    * Value is promoted
    * `double` wider than `int` → can pass `int` as arg to method that declares `double` param
        * `double` wider than `int`
* To move from wider format to narrower format, must use casting


## Immutability
* ***`final`*** helps compiler ensure immutability, not guarantee
    * Neither necessary nor sufficient for immutability
    * Can assign value only once (in constructor of class or initializer)
* Declaring reference **`final`** does not make object referred to by reference immutable
    * `public final ArrayDeque<String> d = new ArrayDeque<>();`
        * Memory box `d` not allowed to point at any other `ArrayDeque`, can't be changed to point at different `ArrayDeque`
        * Referenced `ArrayDeque` itself can change

## Generic Methods
* Types inferred from type of object passed in

### Type Upper Bounds
* Can use `extends` keyword as ***type upper bound***
    * Used as statement of fact, doesn't change definition/behavior of generic method parameter


## Checked vs Unchecked Exceptions
* Any subclass of **`RuntimeException`** or **`Error`** is _unchecked_
* All other `Throwable`s are _checked_

![Exceptions inheritance map](../lecture/week05/lec14/exceptions.png)


## Iteration
* Instantiate non-static nested class (inner class) → use `instance.new`
* Implement `Iterable` interface to support enhanced for loop
    * `iterator()` method must return object that implements `Iterator` interface
