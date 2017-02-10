# Midterm 1 Notes

## Static/Dynamic Types
* Dynamic type usually always stays same
* Static type can be altered via assignment & temporarily via casting, but doesn't modify dynamic type
* **Always legal** to upcast from subclass (more specific) to superclass (more general)
* Static type on left side of assignment statement used for compiler method checking

## Overriding
* Access specifier for overriding method can allow more, but not less, access than overridden method
    * `protected` instance method in superclass can be made `public`, but not `private`, in subclass
* Compile-time error when changing instance method in superclass to static method in subclass, & vice versa
* Directly attempting to access field **always** results in static type check

## Polymorphism
* Methods can return subclasses of their declared type & take in arguments that are subclasses of declared parameter types
