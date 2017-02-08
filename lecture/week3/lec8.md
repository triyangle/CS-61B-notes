# Inheritance, Implements

## Hypernyms, Hyponyms, & Interface Inheritance
* Define reference type (`interface`) for hypernym (`List61B.java`)
* `public class SLList<Blorg> implements List61B<Blorg>`
    * Type parameters have to match, even if `List61B<Item>` interface has different name
* Mark each method from `List61B` w/ `@Override` annotation

## Interface Inheritance
* Powerful tool for generalizing code

```java
List61B<String> someList = new SLList<String>();
someList.addFirst("elk");
```

* When run, `SLList` created & address stored in `someList` variable
    * `String` "elk" inserted into `SLList` referred to by `addFirst`
    * `List61B` object will access/use implemented methods from corresponding subclass
    * Can be set to `new SLList<>()` as well, `String` not necessary

## Default Methods & For Loops

### Implementation Inheritance
* Use **`default`** keyword to specify method that subclasses should inherit from **`interface`**
* `default public void print() {}`
* `default` method of `interface` can't access instance variables (b/c no instance variables in `interface`), have to use methods already specified in `interface` to implement
    * Can override `default` methods


## Dynamic Method Selection

### Static Type vs Dynamic Type
* Every variable in Java has "compile-time type"/"static type"
    * Type specified at **declaration**, *never changes*
* Variables also have "run-time type"/"dynamic type"
    * Type specified at **instantiation** (e.g. when using new)
    * Equal to type of object being pointed at

```java
public static void main(String[] args) {
    LivingThing lt1; // Static = LivingThing, Dynamic = null
    lt1 = new Fox(); // Static = LivingThing, Dynamic = Fox

    // Dynamic type of a1 set to same Dynamic type as lt1
    Animal a1 = lt1; // Static = Animal, Dynamic = Fox

    // Dynamic type of h1 set to same Dynamic type as a1
    Fox h1 = a1; // Static = Fox, Dynamic = Fox
    lt1 = new Squid(); // Static = LivingThing, Dynamic = Squid
}
```

Variable | Static Type | Dynamic Type
--- | --- | ---
`lt1` | `LivingThing` | `Squid`
`a1` | `Animal` | `Fox`
`h1` | `Fox` | `Fox`

* When calling method of object using variable with:
    * Compile-time type `X`
    * Run-time type `Y`
* If `Y` **overrides** method, `Y`'s method used instead
    * Known as "dynamic method selection"


## Overloaded Methods
* When overloading, dynamic method selection not used → static type used instead

```java
public static void peek(List61B<String> list) {
    System.out.println(list.getLast());
}

public static void peek(SLList<String> list) {
    System.out.println(list.getFirst());
}
```

```java
SLList<String> SP = new SLList<String>();
List61B<String> LP = SP;
SP.addLast("elk");
SP.addLast("elk");
SP.addLast("cool");
peek(SP); // elk
peek(LP); // cool
```

### Overloading vs Overriding
* Dynamic method selection only happens for **overriden** methods
     * When instance method of subtype overrides method in supertype, uses most specialized method available
* Dynamic method selection **does not happen** for **overloaded** methods:
    * When class has two or more methods, one for supertype, one for subtype


## Interface vs Implementation Inheritance
* Interface Inheritance (what):
    * Allows generalization of code in powerful, simple way
* Implementation Inheritance (how):
    * Allows code-reuse: subclasses can rely on superclasses/interfaces
        * Gives another dimension of control to subclass designers: can decide whether or not to override default implementations
* Both cases = "is-a" relationships, **not** "has-a"

### Dangers of Implementation Inheritance
* Harder to keep track of where something was actually implemented
* Rules for resolving conflicts can be arcane
    * E.g. two interfaces both give conflicting default methods
* Encourages overly complex code
* Breaks encapsulation
