# Overview, Tries

## [Summary](https://docs.google.com/presentation/d/1ZDobmVNNZIayrgDUZzZVM-t7yr6ZZCkWBhC6aEjtC04/edit#slide=id.g46b429e30_0179)
* Search problem → data structures used = trees & hash tables
* Sorting problem:
    * Insertion sort into BST = partition sort (quicksort)
    * Selection sort using heap = heapsort
    * Digit-by-digit sorting algorithms:
        * Can use other sorting algorithm subroutines when sorting digit-by-digit, instead of only just counting sort subroutine
* Searching via trees (comparisons) uses `compareTo()`, analogous to **comparison-based sorting**
    * Search for things by ordering using `compareTo()`
* Searching via hash tables uses `hashCode()` & `equals()` analogous to **counting/integer sorting**
    * "Cheat" not comparing by exploiting space to save time & avoid comparisons
* Digit-by-digit search = Trie, analogous to radix sorts

## [Digit-by-digit Search](https://docs.google.com/presentation/d/1ZDobmVNNZIayrgDUZzZVM-t7yr6ZZCkWBhC6aEjtC04/edit#slide=id.g867498130_0_3)

## [Trie Performance in Terms of $$N$$ & $$L$$](https://docs.google.com/presentation/d/1ZDobmVNNZIayrgDUZzZVM-t7yr6ZZCkWBhC6aEjtC04/edit#slide=id.g46b429e30_0557)
* Runtime independent of $$N$$, # of keys
* Best case runtime can correspond to failures instead of just successes (e.g. Trie `contains()`)
* Hash table searching includes $$L$$ b/c always need to compute hash code, need to hash every digit
* If need to search through each child to determine where to traverse down, $$R$$, alphabet size will be included in runtime → $$\Theta(RL)$$ worst case search/insert

## [Set/Map Data Structures (Raw Performance for Search)](https://docs.google.com/presentation/d/1ZDobmVNNZIayrgDUZzZVM-t7yr6ZZCkWBhC6aEjtC04/edit#slide=id.g76ca0850b_0_27)
* $$L$$ factor included for BST b/c Trie performance based solely on $$L$$ → need to account for $$L$$ for BST as well
    * Need to do $$L$$ characters of comparison in worst case (need to compare every character to determine if match or not)
        * Similar to [merge sort vs LSD sort](https://docs.google.com/presentation/d/1pPdoaB7E9v_K5YyD1-fCOypxNFh2gKNGJ_Ur1v9RljE/edit#slide=id.g76adfa6c9_0_152) comparison where LSD sort takes $$W$$ into consideration → also need to include $$W$$ in merge sort time
    * Best case $$\Theta(L)$$ = match at root → still need to compare every character to determine match
* $$L$$ factor also included for Hash Table b/c hash code computation may take into account every character

## [Usage of Tries](https://docs.google.com/presentation/d/1ZDobmVNNZIayrgDUZzZVM-t7yr6ZZCkWBhC6aEjtC04/edit#slide=id.g76ca0850b_0_57)
* Prefix matching much slower for hash tables (have to go through everything, b/c unordered) and BSTs (may be able to prune some branches b/c of ordering)
    * Very fast for tries

## [Trie Implementation](https://docs.google.com/presentation/d/1ZDobmVNNZIayrgDUZzZVM-t7yr6ZZCkWBhC6aEjtC04/edit#slide=id.g76ca0850b_0_312)
* $$R$$ = alphabet size
* Use `char` `int` value to index into `Node[]`
* Root always `exists` always `false`
* Extremely space hungry b/c not all characters for a given `Node` may be even used

## [Implementing T9 Texting](https://docs.google.com/presentation/d/1ZDobmVNNZIayrgDUZzZVM-t7yr6ZZCkWBhC6aEjtC04/edit#slide=id.g1dd51b040b_0_0)
* If only care about top option, `PriorityQueue` fine
* If want all results in ranked order → `TreeSet`

## [Tries](https://docs.google.com/presentation/d/1ZDobmVNNZIayrgDUZzZVM-t7yr6ZZCkWBhC6aEjtC04/edit#slide=id.g46ca0d95f_0327)
* Support character-based operations → prefix searching/matching/approximating/etc.

## [Array Based Trie](https://docs.google.com/presentation/d/1ZDobmVNNZIayrgDUZzZVM-t7yr6ZZCkWBhC6aEjtC04/edit#slide=id.g46ca0d95f_097)
* Don't use arrays for sparse maps
* Arrays better for compact lists (e.g. heaps)

## [BST Based Trie](https://docs.google.com/presentation/d/1ZDobmVNNZIayrgDUZzZVM-t7yr6ZZCkWBhC6aEjtC04/edit#slide=id.g46ca0d95f_0210)
* May slow down link traversal, but uses much less memory
* Can also use Hash Table for links

### [A More Modular TrieSet](https://docs.google.com/presentation/d/1ZDobmVNNZIayrgDUZzZVM-t7yr6ZZCkWBhC6aEjtC04/edit#slide=id.g76ca0850b_0_507)

## [Ternary Search Trie](https://docs.google.com/presentation/d/1ZDobmVNNZIayrgDUZzZVM-t7yr6ZZCkWBhC6aEjtC04/edit#slide=id.g76ca0850b_0_507)
* Each node has small # of fixed characters/links
* Only use all three links when traversing through trie, otherwise when inserting new element, insert down from middle link after traversing to new node

### [TST Performance](https://docs.google.com/presentation/d/1ZDobmVNNZIayrgDUZzZVM-t7yr6ZZCkWBhC6aEjtC04/edit#slide=id.g76cd259e4_1_169)
* Can have bad TST compared to regular trie when inserting $$N$$ unique single characters in increasing order → height for trie = 1, height for TST = $$N$$
    * Occurs similarly to how regularly unbalanced BSTs can degenerate into linked lists when inserting items in increasing/decreasing order → always goes to right/left of leaf
    * Can have balancing TSTs to account for issue

## [Set/Map Data Structures](https://docs.google.com/presentation/d/1ZDobmVNNZIayrgDUZzZVM-t7yr6ZZCkWBhC6aEjtC04/edit#slide=id.g76ca0850b_0_518)

## [More Summary](https://docs.google.com/presentation/d/1ZDobmVNNZIayrgDUZzZVM-t7yr6ZZCkWBhC6aEjtC04/edit#slide=id.g46b429e30_01257)
* R-way Array Trie = LSD sort in disguise
* Ternary Search Trie has corresponding sort → 3-way radix quicksort
