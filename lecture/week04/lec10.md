# Subtype Polymorphism vs HoFs

## Typing Puzzle
* Rules:
    * Compiler allows memory box to hold any subtype
    * Compiler **only** allows calls based on static type
    * **Overridden non-static methods are selected at run time based on dynamic type**
        * **Everything else based on static type**, including _overloaded methods_

### Static Methods, Variables, & Inheritance
* Subclass has variables w/ same name as superclass
* Subclass has static method w/ same signature as superclass method
    * Not overriding, overriding **only** applies to non-static methods
* Both known as "hiding"


## Subtype Polymorphism
* Polymorphism = providing single interface to entities of different types
* Consider variable `deque` of static type `Deque`:
    * When calling `deque.addFirst()`, actual behavior based on dynamic type (run-time type)
    * Java automatically selects right behavior using "dynamic method selection"
* Polymorphism based on subtypes, whatever run-time type is (whichever subtype) → use run-time type/subtype overridden method


## Comparator
### Natural Order
* Natural order sometimes used to refer to ordering implied by `Comparable`'s `compareTo` method

### Comparable & Comparator Summary
* Interfaces provide ability to make ***callbacks:***
    * Sometimes function needs help of another function (might not have been written yet)
        * `max` needs `compareTo`
        * Helping function sometimes called a "callback"
    * Some languages Handle via explicit function passing
    * Java → achieve this by wrapping needed function in interface (e.g. `Arrays.sort` needs `compare`, which lives inside `Comparator` interface
        * Wrapped in `Comparable` or `Comparator`
    * `Arrays.sort` "calls back" whenever it needs a comparison
* `Comparable` compares itself to another object
* `Comparator` compares two other objects
