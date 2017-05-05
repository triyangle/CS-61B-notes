# Priority Queues & Heaps
## Priority Queue Interface
```java
/** (Min) Priority Queue: Allowing tracking & removal of smallest item in priority queue */
public interface MinPQ<Item> {
    public void add(Item x);
    public Item getSmallest();
    public Item removeSmallest();
    public int size();
}
```

* Only allows interaction w/ smallest item at any given time → better performance than `List`/`Set`
* Useful for keeping track of "smallest", "largest", "best", etc. seen so far

## Heaps
* BSTs would work, but need to be kept bushy & duplicates are awkward
* Binary min-heap: Binary tree that is ***complete*** & obeys ***min-heap property***
    * **Min-heap property:** Every node $$\leq$$ both its children
    * **Complete:** Missing items only at bottom level (if any), all nodes as far left as possible

### [Insertion](https://docs.google.com/presentation/d/1VEd2Pm_3OuvkC1M8T5XAhsBTQFxVHs386L79hktkDRg)
* Add to end of heap temporarily
* Swim up hierarchy

### [Delete Min](https://docs.google.com/presentation/d/1VEd2Pm_3OuvkC1M8T5XAhsBTQFxVHs386L79hktkDRg/edit#slide=id.g11ecaeaf56_0_374)
* Swap last item in heap into root
* Sink down hierarchy (promote "better" successor)

## Tree Representation
* Store keys in array, offset everything by 1 spot
* Leave spot 0 empty
* Makes computation of children/parents "nicer"
    * `leftChild(k) = k * 2`
    * `rightChild(k) = k * 2 + 1`
    * `parent(k) = k / 2`

<p align='center'>
    <img src='tree_rep.png'>
</p>

## Heap Implementation of a Priority Queue
| Operation        | Ordered Array | Bushy BST (items w/ same priority hard to handle) | Hash Table    | Heap                |
|:----------------:|:-------------:|:-------------------------------------------------:|:-------------:|:-------------------:|
| `add`            | $$\Theta(N)$$ | $$\Theta(\log{N})$$                               | $$\Theta(1)$$ | $$\Theta(\log{N})$$ |
| `getSmallest`    | $$\Theta(1)$$ | $$\Theta(\log{N})$$                               | $$\Theta(N)$$ | $$\Theta(1)$$       |
| `removeSmallest` | $$\Theta(N)$$ | $$\Theta(\log{N})$$                               | $$\Theta(N)$$ | $$\Theta(\log{N})$$ |

* Position in tree/heap = priority
* Heap is $$\log{N}$$ time amortized (resize backing array)
    * Worst case inserting $$N$$ items:
        * $$\log{1} + \log{2} + \ldots + \log{N} + 2 + 4 + 8 + 16 + \ldots + 2N = \log{N!} + 4N - 4 = N \log{N} + 4N - 4$$
        * Averaged over $$N$$ items → $$\log{N} + 4 - \frac{4}{N}$$ → $$\Theta(\log{N})$$
* BST can have constant `getSmallest` by keeping pointer to smallest
* Heaps handle duplicate priorities much more naturally than BSTs
* Array based heaps take less memory

### Implementation Details
* Can have type parameter `<Item extends Comparable<Item>>`
* Can also have constructor that takes in `Comparator<Item>`

## Data Structures Summary
### The Search Problem
* Given stream of data, retrieve info of interest

### [Search Data Structures](https://docs.google.com/presentation/d/1Y5egsKkY2Ya1-6FhOkRo7bekvmK464u7AznXQrMmGTI/edit#slide=id.g1d25fc641c_0_0)
| Data Structure | Storage Operation(s)                 | Primary Retrieval Operation | Retrieve By:   |
|:--------------:|:------------------------------------:|:---------------------------:|:--------------:|
| List           | `add(key)` <br> `insert(key, index)` | `get(index)`                | `index`        |
| Map            | `put(key, value)`                    | `get(key)`                  | key identity   |
| Set            | `add(key)`                           | `containsKey(key)`          | key identity   |
| PQ             | `add(key)`                           | `getSmallest()`             | key order/size |
| Disjoint Sets  | `connect(int1, int2)`                | `isConnected(int1, int2)`   | 2 int values   |
