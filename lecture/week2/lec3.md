# 1/23/17 - References, Recursion, & Lists

## Primitive Types
### Bits
* 8 primitive types in Java: byte, short, **int**, long, float, **double**, boolean, char

### Declaring a Variable
* When declaring variable of certain type in Java:
    * Computer sets aside exactly enough bits to hold thing of that type
        * Declaring `int` always 32 bits
        * `double` always 64 bits
    * Java creates internal table mapping each variable name to location
    * Does NOT write anything into reserved boxes (does contain some sequence of 0s and 1s)
        * For safety, Java won't allow access to uninitialized variable
* When assigning variable to value, Java fills variable's bits w/ all bits that correspond to value

### The Golden Rule of Equals (GRoE)
* `y = x` copies all bits from x into y


## Reference Types
* Every other variable not a primitive type = **reference type**

### Class Instantiations
* When instantiating Object:
    * Java first allocates box of bits for each instance variable of class & fills them w/ default value (e.g. 0, null)
    * `new` keyword returns value/# of bit in memory where Object stored

### Reference Type Variable Declarations
* When declaring variable of any reference type:
    * Java allocates box of exactly 64 bits, no matter what type of objects
        * Bits either set to:
            * `null` (all zeroes)
            * 64 bit "address" of specific instance of class (returned by `new`)

### Reference Types Obey the Golden Rule of Equals
* Equals just copies bits
    * Copies 64 bit address for reference types


## Parameter Passing
* Passing parameters obeys same rule → **copy bits** to new scope (pass by value)


## Instantiating Arrays
## Declaration & Instantation of Arrays
* Declaration creates 64 bit box only for storing reference to array with specified type
* Array not exactly length * bits of elements in bit size
    * Little bit of additional overhead


## IntList & Linked Data Structures
* List able to grow arbitrarily large
* IntList = linked list for `ints`
