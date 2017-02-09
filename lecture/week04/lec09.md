# Extends, Casting, Higher Order Functions

## Implementation Inheritance: Extends
* Because of **extends**, `RotatingSLList` inherits all members of `SLList`:
    * All instance & static variables
    * All methods
    * All nested classes
    * Members may be `private` → inaccessible, subclasses can't access `private` members of superclass
* Constructors not inherited


## Inheritance Constructor Behavior
* Constructors not inherited
* **All constructors must start w/ call to one of superclass's constructors**
    * Invocation of superclass constructor must be first line in subclass constructor
* If constructor does not explicitly invoke superclass constructor, Java compiler automatically inserts call to no-argument constructor of superclass
    * If superclass does not have no-argument constructor → compile-time error
* **Constructor chaining:** Subclass constructor invokes constructor of superclass → chain of constructors called, back up to constructor of `Object`


## The Object Class
* Every type in Java = descendant of `Object` class
* Interfaces do not extend `Object` class
    * Interfaces cannot extend classes

### Is-A vs Has-A
* `extends` should only be used for **is-a** (hypernymic) relationships


## Encapsulation

### Complexity: The Enemy
* Tools for managing complexity:
    * Hierarchical abstraction
        * Create **layers of abstraction**, w/ clear abstraction barriers
    * "Design for change", modular design, each individual piece can be swapped out however, changes can be made all the time
        * Design should be such that changes don't break whole system
        * Nice modular pieces that interact in nice ways
        * Organize program around objects
        * Let objects decide how things are done
            * When overriding method, for implementation & interface inheritance
            * Dynamic method selection calls right function
        * **Hide info** others don't need

### Modules & Encapsulation
* ***Module:*** Set of methods that work together as whole to perform some task or set of related tasks
* Module said to be ***encapsulated*** if implementation is _completely hidden_ → accessed only through documented interface

### Abstraction Barriers
* As user of an `ArrayDeque`, cannot observe internals
    * Even when writing tests, usually don't want to peer inside
    * Write test → think like user


## Type Checking & Casting

### Dynamic Method Selection
* If overridden, decide which method to call based on **run-time/dynamic** type of variable

### Compile-Time Type Checking
* Compiler allows method calls based on **compile-type/static** type of variable

```java
public static void main(String[] args) {
    VengefulSLList<Integer> vs1 = new VengefulSLList<Integer>();
    SLList<Integer> s1 = vs1;

    s1.addLast(50);
    s1.removeLast();

    s1.printLostItems(); // compilation error!
    VengefulSLList<Integer> vsl2 = s1; // compilation error!
}
```

* Compiler only allows method calls & assignments based strictly on compile-time types
    * Even though `sl`'s runtime-type is `VengefulSLList`, cannot assign to `vsl2`
    * Compiler plays it as safe as possible w/ type checking, as conservative as possible

### Compile-Time Types & Expressions
* Expressions have compile-time types:
    * Expression using `new` keyword has specified compile-time type
    * `SLList<Integer> s1 = new VengefulSLList<Integer>();`
        * Compile-time type of RHS expression = `VengefulSLList`
        * `VengefulSLList` is-an `SLList`, assignment allowed
    * `VengefulSLList<Integer> vs1 = new SLList<Integer>();`
        * Compile-time type of RHS expression = `SLList`
        * `SLList` not necessarily a `VengefulSLList` → compilation error results
* Method calls have compile-time type equal to their declared type
    ```java
    public static Dog maxDog(Dog d1, Dog d2) { ... }
    ```
    * Any call to `maxDog` will have compile-time type `Dog`

    ```java
    Poodle frank = new Poodle("Frank", 5);
    Poodle frankJr = new Poodle("Frank Jr.", 15);

    Dog largerDog = maxDog(frank, frankJr);
    Poodle largerPoodle = maxDog(frank, frankJr); // Compilation error, RHS has compile-time type Dog
    ```

### Casting
* Special syntax for forcing compile-time type of any expression
    * Put desired type in parenthesis before expression
    * Ex:
        * Compile-time type `Dog`: `maxDog(frank, frankJr);`
        * Compile-time type `Poodle`: `(Poodle) maxDog(frank, frankJr);`
* Way to trick compiler, can run into trouble tho

```java
Poodle frank = new Poodle("Frank", 5);
Poodle frankJr = new Poodle("Frank Jr.", 15);

Dog largerDog = maxDog(frank, frankJr);
Poodle largerPoodle = (Poodle) maxDog(frank, frankJr); // Compilation OK, RHS has compile-time type Poodle
```

* Casting = powerful but dangerous tool, use sparingly
    * Tells Java to treat expression as having different compile-time type
    * Effectively tells compiler to ignore type checking duties

```java
Poodle frank = new Poodle("Frank", 5);
Malamute frankJr = new Malamute("Frank Jr.", 100);

Poodle largerPoodle = (Poodle) maxDog(frank, frankJr); // Compilation OK, errors at run-time
```
* `ClassCastException` at runtime from running code above


## Higher Order Functions
* **Higher Order Function:** Function that treats another function as data, takes function as input

### Higher Order Functions in Java 7
* Java 7 & earlier
    * Fundamental issue: Memory boxes (variables) cannot contain pointers to functions
* Can use interfaces/inheritance instead


## Implementation Inheritance Cheatsheet
* `VengefulSLList extends SLList` → `VengefulSLList` is-an `SLList`, inherits all members
    * Variables, methods, nested classes
    * Not constructors
    * Subclass constructor must invoke superclass constructor first
    * Use `super` to invoke overridden superclass methods & constructors
* Invocation of overridden methods follows 2 simple rules:
    * Compiler plays it safe & only lets us do things allowed by ***static*** type
    * For overridden methods, actual method invoked based on ***dynamic*** type (does not apply to **overloaded** methods) of invoking expression, e.g. `Dog.maxDog(d1, d2).bark();`
    * Can use casting to overrule compiler type checking
