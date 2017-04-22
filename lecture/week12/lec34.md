# More Quick Sort, Stability, Shuffling

## [Randomness](https://docs.google.com/presentation/d/1qajFKmGwMGnxVkg95NrxNOVbEEU4GEacJOQHdKj0Fjc/edit#slide=id.g1d76fccf63_0_31)
* Shuffle $$\neq$$ safe, depending on partition, still may be $$\Theta(N^{2})$$

## [Smarter Pivot Selection](https://docs.google.com/presentation/d/1qajFKmGwMGnxVkg95NrxNOVbEEU4GEacJOQHdKj0Fjc/edit#slide=id.g1d76fccf63_0_38)
* $$\forall$$ pivot selection strategy which is:
    * Deterministic
    * Constant time
* Can generate input that causes resulting Quicksort to be $$\Theta(N^{2})$$
    * Problem $$\exists$$ for Java's `Arrays.sort()`

## [Hoare Partitioning](https://docs.google.com/presentation/d/1qajFKmGwMGnxVkg95NrxNOVbEEU4GEacJOQHdKj0Fjc/edit#slide=id.g12b16f43a3_0_5)
* Swaps items equal to pivot for left & right pointers to avoid $$\Theta(N^{2})$$ for all equal items

## [Quick Select](https://docs.google.com/presentation/d/1qajFKmGwMGnxVkg95NrxNOVbEEU4GEacJOQHdKj0Fjc/edit#slide=id.g984e2b919_0_30)
* Similar to binary search but w/ partitioning, look at only relevant parts of array for median
    * Doing $$\log{N}$$ problems, where each problem = half size of previous problem → overall runtime = $$N$$
        * $$\sum_{i = 0}^{\log{N}} \frac{N}{2^{i}} = 2N$$

## [Sorting Stability](https://docs.google.com/presentation/d/1qajFKmGwMGnxVkg95NrxNOVbEEU4GEacJOQHdKj0Fjc/edit#slide=id.g465e07215_054)
* Sort by secondary criteria first, then by primary criteria
    * Last criteria to sort by = ultimate ordering of elements
* Stable = maintains relative order of secondary property
* No stable partitioning strategy for quicksort faster than mergesort?

### [Stability Summary](https://docs.google.com/presentation/d/1qajFKmGwMGnxVkg95NrxNOVbEEU4GEacJOQHdKj0Fjc/edit#slide=id.g465e07215_086)

## [Optimizing Sorts](https://docs.google.com/presentation/d/1qajFKmGwMGnxVkg95NrxNOVbEEU4GEacJOQHdKj0Fjc/edit#slide=id.g465fbc6ea_1297)
* If recursive → when subproblem reaches size 15 or lower, switch to insertion sort
* ***Adaptive:*** Exploit existing order in array, array almost sorted already

## [`Arrays.sort`](https://docs.google.com/presentation/d/1qajFKmGwMGnxVkg95NrxNOVbEEU4GEacJOQHdKj0Fjc/edit#slide=id.g465fbc6ea_1297)

## [Shuffling](https://docs.google.com/presentation/d/1qajFKmGwMGnxVkg95NrxNOVbEEU4GEacJOQHdKj0Fjc/edit#slide=id.g12af6a6403_0_106)
