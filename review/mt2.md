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

## Packages
* Cannot import/use/access code from default package from within different package

## Access Control
* Access based **only** on static types

### Access Control w/ Inheritance & Packages
* ***`protected`*** modifier allows package members & subclasses to use class member
* Package private: no modifier → allows classes from same package, _but not subclasses_ to access member

#### Access Levels
| Modifier      | Class | Package | Subclass | World |
|:-------------:|:-----:|:-------:|:--------:|:-----:|
| `public`      | Y     | Y       | Y        | Y     |
| `protected`   | Y     | Y       | Y        | N     |
| _no modifier_ | Y     | Y       | N        | N     |
| `private`     | Y     | N       | N        | N     |


### Access Control at the Top Level
* Two levels: `public`, no modifier (package-private)
    * Can't declare top level class as `private`/`protected`
* No such thing as a sub-package, `ug.joshh.Animal` & `ug.joshh.Plant` = 2 completely different packages


## `.equals()`
* Default implementation of `.equals()` uses `==`
* JUnit `assertEquals` uses `.equals()`
* `.equals()` parameter must take `Object`, cast to actual type w/in `.equals()` method
* Generally will need:
    * Reference check
    * `null` check
    * Class check w/ `.getClass()`
    * Cast to same type
    * Check fields
