# Basic Sorts, Quick Sort

## [Insertion Sort Runtime](https://docs.google.com/presentation/d/1V_xvL2h-SQhHojqCIrQ-E3xqcjZKUmMt8otZcsUx3E8/edit#slide=id.g8606c75bb_0_64)
### [Insertion Sort on Almost Sorted Arrays](https://docs.google.com/presentation/d/1V_xvL2h-SQhHojqCIrQ-E3xqcjZKUmMt8otZcsUx3E8/edit#slide=id.g8606c75bb_0_17)
* Insertion sort runtime can be bounded by # of inversions (# of out-of-order pairs)
    * Each swap fixes 1 inversion → total runtime = # of swaps = # of inversions
    * Runtime proportional to how much work needed to be done

### [Insertion Sort Sweet Spots](https://docs.google.com/presentation/d/1V_xvL2h-SQhHojqCIrQ-E3xqcjZKUmMt8otZcsUx3E8/edit#slide=id.g8606c75bb_0_29)
* ***Almost sorted*** = small # of inversions → linear # of inversions out of possible $$N^{2}$$
* Insertion sort runtime always $$\Theta(N + K)$$, $$K$$ = # of inversions

## [Sorts So Far](https://docs.google.com/presentation/d/1V_xvL2h-SQhHojqCIrQ-E3xqcjZKUmMt8otZcsUx3E8/edit#slide=id.g8606c75bb_0_34)
* Heapsort = flavor of selection sort → still sorts by finding smallest/largest item each time

## Quicksort

### [Context](https://docs.google.com/presentation/d/1V_xvL2h-SQhHojqCIrQ-E3xqcjZKUmMt8otZcsUx3E8/edit#slide=id.g9816be120_1_376)
* $$D$$ = # of entries in dictionary
* Binary search on tape $$\Theta(N)$$ b/c physical movement about halved each time → $$\frac{N}{2} + \frac{N}{4} + \cdots + 1 = N - 1$$

### [Partition Sort (Quicksort)](https://docs.google.com/presentation/d/1V_xvL2h-SQhHojqCIrQ-E3xqcjZKUmMt8otZcsUx3E8/edit#slide=id.g4661758db_1123)
* Given array, partition on pivot → after partitioning, pivot in sorted position (invariant)
    * Partitioning = single item sort

### [Runtime/Performance](https://docs.google.com/presentation/d/1V_xvL2h-SQhHojqCIrQ-E3xqcjZKUmMt8otZcsUx3E8/edit#slide=id.g4661758db_1578)
* Quicksort runtime non-deterministic, depends on where pivot lands
* [Best case](https://docs.google.com/presentation/d/1V_xvL2h-SQhHojqCIrQ-E3xqcjZKUmMt8otZcsUx3E8/edit#slide=id.g4661758db_1362), pivot always lands in middle

## [Sorting Summary](https://docs.google.com/presentation/d/1V_xvL2h-SQhHojqCIrQ-E3xqcjZKUmMt8otZcsUx3E8/edit#slide=id.g1d6f0e3f4d_33_11)
* Counting inversions takes $$\Theta(N \log{N})$$ time
