# 1/27/17 - DLLists, Arrays

## Doubly Linked Lists
* `add`, `get`, `remove` fast for both ends, O(1) time
* To avoid special cases introduced by `.last` & `.prev`, either:
    * Add additional `sentBack` sentinel at end of list
    * Make linked list circular w/ single sentinel in middle


## Generic Lists
* Parameterize type of `SLList` → `SLList<Type>`
    * `<Type>` = type variable/parameter, substituted for by `Type` argument
    * `SLList<String> s1 = new SLList<>("bone");`
* Java allows deferral of type selection until declaration/instantiation


## Array Overview
* `AList` = array based list, uses arrays instead of recursive list structure

### Getting Memory Boxes
* To store info, need memory boxes → get in Java via declaring variables or instantiating objects
    * `int x;` → gives memory box of 32 bits that stores `ints`
    * `Walrus w1;` → gives memory box of 64 bits that stores `Walrus` location/references
    * `Walrus w2 = new Walrus(30, 5.6);` → gives memory box of 64 bits that stores `Walrus` references, & also gives 96 bits for storing `int size` (32 bits) & `double tuskSize` (64 bits) of `w2`
* **Array** = **numbered** sequence of memory boxes
    * **`class`** = **named** set of memory boxes (instead of indices, has instance variable names)

### Arrays
* Arrays consist of:
    * Fixed integer **length**, cannot change
    * Sequence of N memory boxes where **N = length**, such that:
        * All boxes hold same type of value (& have same # of bits)
* Like instances of classes:
    * When instantiating array → get one reference when its created
    * If all variables containing reference reassigned → can never get array back
* Unlike classes, arrays do not have methods → just data (length & sequence of numbered memory boxes)


## Basic Array Syntax
* Like classes, arrays (almost always) instantiated w/ `new`
* Little bit of overhead when creating arrays in Java b/c sets default values (0 for `int[]`)
* Three valid notations:
    * `y = new int[3];` → creates array w/ 3 `int` boxes (32 ✕ 3 = 96 bits total), each container gets default value
    * `x = new int[]{1, 2, 3, 4, 5};`
    * `int[] w = {9, 10, 11, 12, 13};`
        * Can't use if `w` already declared
* In Oracle's implementation of Java, all Java objects also have some overhead
    * Total size of array = 192 + KN bits, K = # of bits per item
* Default value all 0s → 0 for `byte/short/int/long[]`, `null` for `Object[]`, 0.0 for `float/double[]`, '\u0000' (`null`/empty character) for `char[]`, `false` for `boolean[]`
* `System.arraycopy(b, 0, x, 3, 2);` copies from array `b` to array `x`, starting from position 0 of `b`, copying to position 3 of `x`, copying 2 numbers

### Arraycopy
* Two ways to copy arrays:
    * Item by item using loop
    * Using `arraycopy`, takes 5 parameters:
        * Source array
        * Start position in source
        * Target array
        * Start position in target
        * Number/length to copy
* `arraycopy` likely faster, particularly for large arrays → more compact code
    * Code (arguably) harder to read


## Arrays vs Classes
* When implementing data structure (list, set, map, etc.), both arrays & classes can be used to organize bunch of memory boxes
* Both cases = fixed # of memory boxes (can never change, at least for Java)
* Array indices can be computed at runtime
* Class member variable names **CANNOT** be computed & used at runtime
    * Possible with [reflections API](https://docs.oracle.com/javase/tutorial/reflect/member/fieldValues.html), but not considered good style
* Only (easy) way to access member of class = hard-coded dot notation
    * Java compiler does not treat text on either side of dot as an expression → not evaluated
