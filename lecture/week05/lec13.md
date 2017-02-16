# Generics, Autoboxing

## Generics
* Generic classes require one or more ***actual type arguments*** upon instantiation

### References Types
* For each primitive type, there is a corresponding references type (i.e. wrapper class)
    * Wrapper classes can act as both container (reference type to hold things), & also has useful functions

### Autoboxing
* Autoboxing/(auto-unboxing) = implicit conversions between wrapper/primitives
* Arrays never autoboxed/unboxed (e.g. `Integer[]` cannot be used in place of `int[]` & vice versa)
* Autoboxing/unboxing incurs measurable performance impact
* Wrapper types use much more memory than primitive types
* Can cast `int` to `Integer`

### Promotion
* Similar thing happens when moving from primitive type w/ narrower range to wider range
    * Value is promoted
    * `double` wider than `int` → can pass `int` as arg to method that declares `double` param
        * `double` wider than `int`
* To move from wider format to narrower format, must use casting

## Immutability
### Immutable Data Types
* One for which instance cannot change in any observable way after instantiation
* Mutable: `ArrayDeque`, `Planet`
* Immutable: `Integer`, `String`, `Date`
* ***`final`*** helps compiler ensure immutability, not guarantee
    * Can assign value only once (in constructor of class or initializer)
    * Not necessary to have `final` to be immutable

* Advantage: less to think about, avoids bugs & makes debugging easier
* Disadvantage: must create new object anytime anything changes
* Declaring reference **`final`** does not make object immutable
    * `public final ArrayDeque<String> d = new ArrayDeque<>();`
        * Memory box `d` not allowed to point at any other `ArrayDeque`, can't be changed to point at different `ArrayDeque`
        * Referenced `ArrayDeque` itself can change

## Generic Methods
* Can create method that operates on generic types by defining type parameters _before return type_ of method
