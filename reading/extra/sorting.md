# Sorting

## [Insertion Sorting](http://inst.eecs.berkeley.edu/~cs61b/fa14/demos/insertion-sort-demo.html)
* Total time required to sort $$N$$ element sequence proportional to $$N$$ plus # of inversions → nearly sorted inputs can be sorted in nearly linear time

## [Shellsort](http://inst.eecs.berkeley.edu/~cs61b/fa14/demos/shellsort-demo.html)
* Variation of insertion sort → use insertion sort repeatedly on evenly spaced subsequences of elements, decreasing spacing each time until ending up w/ ordinary insertion sort (*diminishing increment sort*)
* Starting by sorting widely spaced elements → can reduce # of inversions much more quickly than ordinary insertion sort (each subsequent insertion sorts go faster)
* Sorting w/ increment of $$k$$ = sort items $$0, k, 2k, \cdots$$ → $$1, k + 1, 2k + 1, \cdots$$ → $$2, k + 2, 2k + 2, \cdots$$, up to subsequence starting w/ item $$k - 1$$
* Any sequence that ends w/ increment of 1 will produce results
* Certain sequences better than others
    * Sequences $$2^{p} - 1, 2^{p - 1} - 1, \cdots, 1$$ where $$p = \lfloor \lg{N} \rfloor$$ results in overall running time of $$O(N^{\frac{3}{2}})$$

## [Quicksort](http://inst.eecs.berkeley.edu/~cs61b/fa14/demos/quicksort-demo.html)
* Maximum partition size limits # of inversions in sequences → limits execution time of insertion sort
* # of inversions in sequences partitioned by quicksort equal to sum of # of inversions in individual partitions
* Once max partition size reduced to constant → total # of inversions linear in size of entire sequence
* Insertion sort has better constant factors than quicksort → common modification to quicksort = apply insertion sort once max partition size reduced below predetermined threshold
* Each partitioning operation requires linear time in size of subsequence being partitioned
* In worst case, maximum partition size reduced by one on each step → $$O(N^{2})$$ runtime
* Various strategies $$\exists$$ for choosing pivots, including taking small random samples of subsequence

## [Straing Selection Sorting](http://inst.eecs.berkeley.edu/~cs61b/fa14/demos/selection-sort-demo.html)
* Select successively smaller/larger items from list & add to output sequence
* Looks at all unprocessed data on each pass → performs no better for nearly sorted inputs than random or reverse-sorted inputs (unlike insertion sort)
* Possible optimization = remember order of other items on each pass through (turns into heapsort?)

## [Heapsort](http://inst.eecs.berkeley.edu/~cs61b/fa14/demos/heapsort-demo.html)
* ***Complete binary tree:*** Each level of tree completely full, w/ possible exception of lowest level → nodes on lowest level located as far to left of level as possible

## [Merge Sorting](http://inst.eecs.berkeley.edu/~cs61b/fa14/demos/mergesort-demo.html)
* Many variations, all of which follow divide-and-conquer scheme
    * Divide data into subsequences → recursively sort subsequences → *merge* sorted subsequences into increasingly large sorted sequences
* For merging large numbers of sequences → use variety of priority queue (or heap) to keep track of which sequence currently has smallest item
* B/c deals w/ data sequentially & requires only enough memory to buffer input & output (finite amount) → merge sorting ideally suited to *external sorting* (amount of data to be sorted exceeds capacity of primary memory by arbitrarily large amounts)
    * Size of sorted data limited only by size of secondary memory
    * Sort stream of data?
* B/c of divide & conquer character → merge sorting eminently parallelizable

## [Beyond Comparisons: Radix Sort & Counting Sort](http://inst.eecs.berkeley.edu/~cs61b/fa14/demos/radix-sort-demo.html)
* Comparison based sorts used binary comparisons $$(<, >, \leq, \geq)$$ to control algorithms
    * Theoretical lower bound on # of comparisons (& thus overall operations) needed to sort $$N$$ items → $$\Omega(N \lg{N})$$
* By exploiting more properties of data being sorted than ordering relation, can arrive at different bounds
* ***Radix sorting:*** Uses digits/bytes constituting data to make multi-way decisions → able to sort $$B$$ bytes of data in $$O(B)$$ time
    * Comparing $$O(B)$$ to $$O(N \log{N})$$ comparisons to sort $$N$$ (multi-byte) records tricky
        * If assume in worst case, comparisons take time proportional to # of bytes of data being compared → radix sorting should win
        * For practical purposes, must consider constant factors
* Idea behind radix sorting = view keys to be sorted sequences of numerals consisting of digits in finite radix ($$R$$)
    * ASCII character strings = base-256 numerals
    * Pad all keys to same # of digits (on left/right, depending on sorting order)
        * Right for strings, left for #s
    * If common length of keys is now $$D$$ digits, sort keys (up to) $$D$$ times (once on first digit, once on second, etc.)
    * Precise logistics differ depending on whether processing digits left to right (MSD radix sort) or right to left (LSD radix sort)
* MSD radix sort → each sort rearranges dat into sections that can be sorted independently, sections already ordered correctly w/ respect to each other
    * Further refine sections having more than one key by later character positions until all sections contain just one item
* LSD radix sort → sort all data together on each pass, carefully maintaining previously established order for keys w/ same digit in position currently being sorted
* Can accomplish each one-character sorts in $$O(N + R)$$ time using stable *counting sort*
    * First count # of keys containing each possible digit (0 to $$R - 1$$) at current character position ($$k$$) → easy to compute # of keys whose $$k^{\text{th}}$$ is $$d$$, & thus # of keys left of those whose $$k^{\text{th}}$$ is $$d$$ → allows another pass through keys, moving to proper positions
