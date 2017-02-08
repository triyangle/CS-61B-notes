# SLLists, Nested Classes, Sentinel Nodes

## Introducing the SLList
* IntList = "naked" recursive data structure

## Introducing the SLList - SLList Methods
* User of IntList has pointers potentially directly into naked recursive data structure → requires understanding of recursion
    * Naked recursion: natural for IntList user to have variables pointing to middle of IntList
* User of SLList has middle man to go through, use methods to add/get items
    * SLList class acts as middle man between user & raw data structure
    * Ideally no way around middle man

## Access Control & Nested Classes
* `private` prevents code in **other classes** from using members/constructors of a class

### Why Restrict Access?
* Hide implementation details from users of class → abstraction barrier
    * Less for user of class to understand
    * Safe to change private methods (implementation)
* Despite term 'access control' → nothing to do w/ protection against hackers/spies/etc.
* Expectation when something made `public` in Java → will never be removed
    * Whenever providing `public` method → signal to users that they will have access to that method forever
    * `public` = `public` forever, otherwise breaks backwards compatibility w/ other code

### Nested Classes
* Useful when class doesn't stand on its own & obvious subordinate to another class
    * Make nested class `private` if other classes should never use nested class
* If nested class never uses instance variables/methods of outer class → declare static
    * Static classes can't access outer class's instance variables/methods → minor savings of memory
    * For `private` nested classes, access modifiers for variables/methods within `private` nested class = irrelevant

#### Static Nested Classes
* Static nested class interacts w/ instance members of outer class (and other classes) like any other top-level class → static nested class behaviorally = top-level class nested w/in another top-level class for packaging convenience
* Static nested classes accessed using enclosing class name (like other static variables): `OuterClass.StaticNestedClass`
* To create object for static nested class: `OuterClass.StaticNestedClass nestedObject = new OuterClass.StaticNestedClass();`

#### Inner Classes
* Inner class (non-static) associated w/ instance of enclosing class, has direct access to enclosing object's methods & fields
* B/c inner class associated w/ instance, cannot define any static members itself
* Objects that are instances of inner class exist *within* instance of outer class

```java
class OuterClass {
    class InnerClass {
    }
}
```

* Instance of `InnerClass` can exist **only** w/in instance of `OuterClass` & has direct access to methods & fields of enclosing instance
* To instantiate inner class, must first instantiate outer class
    * `OuterClass.InnerClass innerObject = outerObject.new InnerClass();`
* 2 special kinds of inner classes: [local classes][local classes] & [anonymous classes][anonymous classes]

#### Shadowing
* If declaration of type (i.e. member variable/parameter name) in particular scope (i.e. inner class/method definition) has same name as another declaration in enclosing scope → declaration *shadows* declaration of enclosing scope
* Cannot refer to shadowed declaration by name alone

```java
public class ShadowTest {

    public int x = 0;

    class FirstLevel {

        public int x = 1;

        void methodInFirstLevel(int x) {
            System.out.println("x = " + x);
            System.out.println("this.x = " + this.x);
            System.out.println("ShadowTest.this.x = " + ShadowTest.this.x);
        }
    }

    public static void main(String... args) {
        ShadowTest st = new ShadowTest();
        ShadowTest.FirstLevel fl = st.new FirstLevel();
        fl.methodInFirstLevel(23);
    }
}
```

**Output:**
```
x = 23
this.x = 1
ShadowTest.this.x = 0
```

* Variable `x` defined as parameter of method `methodInFirstLevel` shadows variable of inner class `FirstLevel`
    * When using `x` in `methodInFirstLevel` → refers to method paramter
* To refer to member variable of inner class `FirstLevel`, use `this` keyword to represent enclosing scope
* Refer to variables enclosing larger scopes by class name to which they belong

#### Serialization
* [Serialization](https://docs.oracle.com/javase/tutorial/jndi/objects/serial.html) of inner classes, including [local][local classes] & [anonymous][anonymous classes] classes = strongly discouraged
* When Java compiler compiles certain constructs (e.g. inner classes), it creates *synthetic constructs* → classes, methods, fields, & other constructs that do not have corresponding construct in source code
* Synthetic constructs enable Java compilers to implement new Java language features w/out changes to JVM
    * However, synthetic constructs can vary among different Java compiler implementations → `.class` files can vary among different implementations as well → may have compatibility issues when serializing inner class & deserializing it w/ different JRE implementation
* [Implicit & Synthetic Parameters](https://docs.oracle.com/javase/tutorial/reflect/member/methodparameterreflection.html#implcit_and_synthetic), [Obtaining Names of Method Parameters](https://docs.oracle.com/javase/tutorial/reflect/member/methodparameterreflection.html)


## addLast & Size
* `SLList` itself not recursive — does not have SLList pointers
    * Common strategy = `private static` recursive helper method
* Common pattern w/ recursive data structures:
    * `public` method highest abstraction level
    * `private` method lower abstraction level


## Caching
* Keep `size` as instance variable & update everytime new item added/removed
    * **Caches** size of list → put aside data to speed up retrieval

### Naked Linked Lists (IntList) vs SLLists
* Middleman serves as natural place to store meta-info about entire list (e.g. size, max, min, etc.)
    * Not so easy w/ naked recursive list
* Object oriented programming approach = let object control everything → natural way to organize code


## The Empty List
* Benefits of `SLList` vs `IntList` so far:
    * Faster `size()` method than would have been convenient for `IntList`
    * User of `SLList` never sees `IntList` class
        * Simpler to use
        * More efficient `addFirst` method
        * Avoids errors (or malfeasnace)
* Easy to represent empty list → set front/first to `null`


## Sentinel Nodes
* Empty list = `sentinel` node
* List w/ 3 numbers has `sentinel` node & 3 nodes that contain real data
    * Sentinel always at front, just a placeholder node
* `sentinel` never `null`, always points to `sentinel` node
* Eliminates need for special case to check if `sentinel` is `null` (b/c never `null`)


## Invariants
* Invariant = condition guaranteed to be true during code execution (assuming no bugs)
    * List of all things you can rely on, truths
* Invariants make it easier to reason about code:
    * Can assume they are true to simplify code (e.g. `addLast` doesn't need to worry about nulls)
    * Must ensure that methods preserve invariants, checklist (good for testing?)


[local classes]: https://docs.oracle.com/javase/tutorial/java/javaOO/localclasses.html
[anonymous classes]: https://docs.oracle.com/javase/tutorial/java/javaOO/anonymousclasses.html
