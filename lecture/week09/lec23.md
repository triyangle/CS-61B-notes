# Hashing
* Hash table = most common implementation for set/map

## Techniques for Storing Data: Bushy BST
* Limitations:
    * Items/keys must be comparable
    * Maintaining bushiness non-trivial

## Using Data as an Index
* Rather than using contents of array to store keys → use indices themselves as keys
    * Use data itself as array index
* Downsides:
    * Extremely wasteful of memory (to support checking presence of all positive integers, need 2 billion booleans
    * Need some way to generalize beyond integers

### Refined Approach
* Treat string as n-digit base 27 number
    * c: 3rd letter of alphabet, a: 1st letter, t: 20th letter
    * Index of "cat" is $$3 \cdot 27^{2} + 1 \cdot 27 + 20 = 2234$$

### Generalizing to Words
* Convert each word to unique integer representation
* Using 5 bits per letter equivalent to treating like base 32 number
* Java requires that EVERY object provide a method that converts itself into an integer: `hashCode()`

## Handling Collisions
* Store list of $$N$$ items at position $$h$$

### External/Separate Chaining
* Storing all items that map to $$h$$ in a linked list

### External Chaining Performance
* Depends on # of items in "bucket"
* If $$N$$ items distributed across $$M$$ buckets, average time grows with $$\frac{N}{M} = L$$ (***load factor***)
    * Average length of list = $$L$$
    * Average runtime = $$\Theta(L)$$
    * Performance depends on # of items in each "bucket"

| Type                          | Load Factor $$L$$       |
|:-----------------------------:|:-----------------------:|
| External Chaining, Fixed Size | $$\Theta(N)$$           |
| External Chaining w/ Resizing | $$\Theta(1) \text{ (amortized)}$$ |

### Negative `.hashCode`s in Java
* In Java, `-1 % 4 == -1` → use `Math.floorMod` instead

## Hash Table
* Every item mapped to bucket # using hash function
* Computing hash function consists of 2 steps:
    1. Compute `hashCode` (integer between $$-2^{31}$$ & $$2^{31} - 1$$
    2. Computing index = `hashCode` $$\mod M$$
* If $$L = \frac{N}{M}$$ gets too large, increase $$M$$
* If multiple items map to same bucket, have to resolve ambiguity
    * Two common techniques:
        * External Chaining (create list for each bucket)
        * Open Addressing

## Hash Functions
> The value 31 was chosen because it is an odd prime. If it were even and the multiplication overflowed, information would be lost, as multiplication by 2 is equivalent to shifting. The advantage of using a prime is less clear, but it is traditional. A nice property of 31 is that the multiplication can be replaced by a shift and a subtraction for better performance: `31 * i == (i << 5) - i`. Modern VMs do this sort of optimization automatically.

* Bit shifting left introduces 0 on right → loses bit on left of number's binary representation → clear information loss
    * Repeated bit shifting → gradually lose all info accumulated from earlier computation
    * More fields entering hashcode calculation → less effect on final result early fields have

### Hash a Collection
* `List`s a lot like `String`s: Collection of items each w/ own `hashCode`:

```java
@Override
public int hashCode() {
    int hashCode = -1;
    for (Object o : this) {
        hashCode = hashCode * 31; // elevate/smear current hash code
        hashCode = hashCode + o.hashCode(); // add new item's hash code
    }
    return hashCode;
}
```

* To save time hashing: look at only first few items
    * Higher chance of collisions, but faster

### Hashing a Recursive Data Structure
* Computation of `hashCode` of recursive data structure involves recursive computation
* Ex: binary tree `hashCode` (assuming sentinel leaves, i.e. `this.left` never `null`)

```java
@Override
public int hashCode() {
    if (this.value == null) {
        return 0;
    }
    return this.value.hashCode() + 31 * this.left.hashCode() + 31 * 31 * this.right.hashCode();
```

## Default `hashCodes()`
* All `Objects` have `hashCode()` function
* Default: returns `this` (address of object)
    * Can have strange consequences: `"hello".hashCode()` not same as `("h" +"ello").hashCode()`
* Can override for own types
* Hash tables (`HashSet`, `HashMap`, etc.) so important that Java requires all objects implement `hashCode()`

## `HashSet`s & `HashMap`s
* Java provides hash table based implementation of sets & maps
* Never store mutable objects in `HashSet` or `HashMap`
* Never override `equals` w/out also overriding `hashCode`

## Summary
* W/ good `hashCode()` & resizing, operations are $$\Theta(1)$$ amortized
* Store & retrieval does not require items to be `Comparable`

| Data Structure                 | `contains(x)`       | `insert(x)`         |
|:------------------------------:|:-------------------:|:-------------------:|
| Linked List                    | $$\Theta(N)$$       | $$\Theta(N)$$       |
| Bushy BSTs (used by `TreeSet`) | $$\Theta(\log{N})$$ | $$\Theta(\log{N})$$ |
| Unordered Array                | $$\Theta(N)$$       | $$\Theta(N)$$       |
| Hash Table (used by `HashSet`) | $$\Theta(1)$$       | $$\Theta(1)$$       |

## Collision Resolution (Extra)

## Open Addressing: Alternate Disambiguation Strategy
* If target bucket already occupied, use different bucket, e.g.
    * **Linear probing:** Use next address, & if already occupied, just keep scanning one by one
    * **Quadratic probing:** Use next address, & if already occupied, try looking 4 ahead, 9 ahead, 16 ahead, $$\dots ,\ i^{2}$$ ahead
