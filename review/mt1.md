# Midterm 1 Notes

## References, Recursion, & Lists
### Declaring a Variable
* Declaring does **NOT** write anything into reserved boxes (does contain some sequences of 0s & 1s)
    * For safety, Java won't allow access to uninitialized variable


## AList
* Usage ratio `R = size / items.length`
    * Halve size of array when `R < .25`

### Generic ALists
* Java does not allow creating of array of generic objects
    * Can't do `items = new Glorp[8];`
    * Have to cast w/ `items = (Glorp[]) new Object[8];` instead

## Static/Dynamic Types
* Dynamic type usually always stays same
* Static type can be altered via assignment & temporarily via casting, but doesn't modify dynamic type
* **Always legal** to upcast from subclass (more specific) to superclass (more general)
    * Downcasting requires type check, dangerous b/c restricts type → not all supertypes are of a certain subtype → `ClassCastException`
    * Can't downcast pass run-time type of actual object, at most as specific as run-time type of object
* Static type on left side of assignment statement used for compiler method checking
* Calling subclass method of object w/ dynamic subclass type but static superclass type (that doesn't have subclass's method signature) → compile-time error
    * If exists, will call subclass method via dynamic method selection
* Static type casting checked during compile-time → run-time uses dynamic type to determine casting (may result in `ClassCastException`)
* In order to cast, must be related (subclass/superclass)
    * Compile-time checks compatibility of static types, run-time checks compatibility of dynamic type (`instanceof`)
    * Casting only needed when going from more general type to more specific type
    * _Implicit_ casting occurs when source type more specific than target type (source type extends/implements target type, casting to superclass/interface)
    * Need _explicit_ casting when source type more general than target type (source type extended/implemented by target type, casting to subtype)
        * Can caues run-time exception (`ClassCastException`) when object being cast not of target type (or target's subtype)
    * When casting down floating point primitives (`float`, `double`) to whole number primitives, # rounded ↓
* Dynamic method selection only for overridden methods
    * Passing args to overloaded methods matches static argument type w/ parameter type (doesn't look at dynamic type), also affected by casting
* Method signature to be called determined at compile-time → first matches w/ method of static type with corresponding matching static type parameters
    * If run-time type is subclass & overrides currently matched superclass method → calls subclass's method that overrides

## Overriding
* Access specifier for overriding method can allow more, but not less, access than overridden method
    * `protected` instance method in superclass can be made `public`, but not `private`, in subclass
* Compile-time error when changing instance method in superclass to static method in subclass, & vice versa
* Directly attempting to access fields **always** results in static type check (no dynamic selection like methods)
* Can't override `static` methods
* Casting object will change static method called
    ```java
    class Main {
      public static void main(String[] args) {
        B b = new B();
        b.test();
        ((A) b).test();
      }
    }

    class A {
      public static void test() {
        System.out.println("A test");
      }
    }

    class B extends A {
      public static void test() {
        System.out.println("B test");
      }
    }
    ```
    **Output:**
    ```java
    B test
    A test
    ```
    * Hidden methods use static type
* Can't have static method w/ same signature (name & parameters) as instance method (& vice versa)

## Overloading
* Method signature = method name & parameter types
* Can't declare more than one method w/ same name & same # & type of args b/c compiler can't tell them apart
    * Compiler doesn't consider return type when differentiating methods → can't declare 2 methods w/ same signature even if they have different return type
* Can't have two methods w/ same signature, different return type

## Inheritance
* `super.super` not allowed

## Polymorphism
* Methods can return subclasses of their declared type & take in arguments that are subclasses of declared parameter types

## Nested Classes
* Declaring nested class as `static` → methods inside static nested class cannot access instance members of enclosing class

## Java Syntax
* Can change/access static variables in constructor/instance methods

### Arrays
```java
int[] x;
int[] y;
x = new int[3];
y = new int[] {1, 2, 3, 4, 5};
int[] z = {9, 10, 11, 12, 13}; // can only be used when combined w/ variable declaration
```
* `System.arraycopy(Object src, int srcPos, Object dest, int destPos, int length)`
