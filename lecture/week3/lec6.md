# ALists, Resizing, vs SLists

## Why Array Lists

### Arbitrary Retrieval
* Linked list slow `get(int i)` for long lists


## Naive Array Lists

### Random Access in Arrays
* Retrieval from any position of array very fast
    * Independent\* of array size
        * When array gets too big, sometimes pushed onto slower parts of computer's memory/disk drive
    * Fast random access b/c memory boxes same size (in bits)


## Making AList Fast

### Memory Efficiency
* Define "usage ratio"/load factor, `R = size / items.length;`
* Half array size when `R < .25`


## Generic ALists
* Generic arrays not allowed in Java
* Need to use `(Item[]) new Object[100];`

### Nulling Out Deleted Items
* Unlike integer based ALists, actually want to `null` out deleted items
* Keeping references to unneeded objects = loitering
