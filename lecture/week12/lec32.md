# Basic Sorting Algorithms

## [Sorting - Definitions](https://docs.google.com/presentation/d/1_Bhr6YRbu6hrWmR65ydpYRdrvNylKoW9PqyvMvJs9Iw/edit#slide=id.g463de7561_00)
* Sort = permutation/re-arrangement of sequence of elements that brings them into order according to some ***total order***
* **Total order** $$\preceq$$ is:
    * **Total:** $$x \preceq y\ \lor\ y \preceq x\ \ \forall\ \ x, y$$, everything needs a relationship
    * **Reflexive:** $$x \preceq x$$
    * **Antisymmetric:** $$x \preceq y\ \land\ y \preceq x \iff x = y$$
    * **Transitive:** $$x \preceq y\ \land\ y \preceq z \implies x \preceq z$$
* Unequal items may be "equivalent" under particular sort or total order
    * Equivalent under ordering

### [Sorting: Alternate Viewpoint](https://docs.google.com/presentation/d/1_Bhr6YRbu6hrWmR65ydpYRdrvNylKoW9PqyvMvJs9Iw/edit#slide=id.g463de7561_015)

## [Performance Definitions](https://docs.google.com/presentation/d/1_Bhr6YRbu6hrWmR65ydpYRdrvNylKoW9PqyvMvJs9Iw/edit#slide=id.g12a12f5ae1_0_239)
* DFS marked array & stack take up additional $$\Theta(V)$$ in **space complexity**, in addition to $$\Theta(V + E)$$ space of graph (not counted)
    * Only accounting for extra space algorithm itself uses

## [Selection Sort](https://docs.google.com/presentation/d/1_Bhr6YRbu6hrWmR65ydpYRdrvNylKoW9PqyvMvJs9Iw/edit#slide=id.g463de7561_032)
* In iteration `i`, find index `min` of smallest remaining entry
* Swap `a[i]` & `a[min]`
* Invariant = everything before index `i` already sorted

## [Heapsort](https://docs.google.com/presentation/d/1_Bhr6YRbu6hrWmR65ydpYRdrvNylKoW9PqyvMvJs9Iw/edit#slide=id.g12a12f5ae1_0_177)
* Both max/min heap work
* Insertion/deletion of $$N$$ elements into/from heap technically $$\Theta(\log{N!})$$ → same as $$\Theta(N \log{N})$$
    * $$\Theta(\log{N!}) = \sum_{i = 1}^{N} \log{i}$$ already upper bounded by $$\Theta(N \log{N})$$

$$
\begin{align*}
\log{N!} &=\sum_{i = 1}^{N} \log{i} \\
                   &\geq \sum_{i = \lceil N/2 \rceil}^{N} \log{i} \\
                   &\geq \sum_{i = \lceil N/2 \rceil}^{N} \log \tfrac{N}{2} \\
                   &\geq \tfrac{N}{2} \log \tfrac{N}{2} \\
                   &= \tfrac{N}{2}\big(\log{N} - \log{2})\\
                   &= \Omega(N\log{N)}\,.
\end{align*}
$$

* Create output array → $$\Theta(N)$$
* Memory usage $$\Theta(N)$$ to build heap and output array

### [In-place Heapsort](https://docs.google.com/presentation/d/1_Bhr6YRbu6hrWmR65ydpYRdrvNylKoW9PqyvMvJs9Iw/edit#slide=id.g12a12f5ae1_0_193)
* In-place bottom-up heapification on input array
* [Bottom-up heapification runtime](http://www.cs.umd.edu/~meesh/351/mount/lectures/lect14-heapsort-analysis-part.pdf), $$\Theta(N)$$, reverse level order sinking
    * **Intuition:** Start from bottom level of tree, where most nodes are, but sinking down costs the least amount work
        * Moving up levels results in exponentially fewer nodes, and 1 height increase → somewhat balances out?
* Top-down heapification runtime, $$\Theta(N \log{N})$$, level order swimming, analogous to inserting $$N$$ items into heap
    * **Intuition:** Start from top level of tree, where least nodes are and swimming up requires least amount of work
        * Moving down levels results in exponentially more nodes, and 1 height increase → most work down at deepest level

### [Runtime/Complexity](https://docs.google.com/presentation/d/1_Bhr6YRbu6hrWmR65ydpYRdrvNylKoW9PqyvMvJs9Iw/edit#slide=id.g12a12f5ae1_0_233)
* Best case runtime $$\Theta(N)$$, array of all duplicates → constant insertion/deletion into/from heap

## [Mergesort](https://docs.google.com/presentation/d/1_Bhr6YRbu6hrWmR65ydpYRdrvNylKoW9PqyvMvJs9Iw/edit#slide=id.g463de7561_068)

## [Insertion Sort](https://docs.google.com/presentation/d/1_Bhr6YRbu6hrWmR65ydpYRdrvNylKoW9PqyvMvJs9Iw/edit#slide=id.g12a12f5ae1_0_20)
* Stable sort
* Inserting item in middle of `ArrayList` $$\Theta(N)$$ b/c still based on actual array (need to shift thing over)
* Invariant = items before index `i` are in sorted order

## [Sorts So Far](https://docs.google.com/presentation/d/1_Bhr6YRbu6hrWmR65ydpYRdrvNylKoW9PqyvMvJs9Iw/edit#slide=id.g12a12f5ae1_0_131)

## [Shell's Sort](https://docs.google.com/presentation/d/1_Bhr6YRbu6hrWmR65ydpYRdrvNylKoW9PqyvMvJs9Iw/edit#slide=id.g12a12f5ae1_0_102)
