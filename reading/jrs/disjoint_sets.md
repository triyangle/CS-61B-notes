# Disjoint Sets
* ***Disjoint sets*** data structure = collection of sets that are ***disjoint***
    * No item found in more than one set
    * Collection of disjoint sets = ***partition*** → items partitioned among sets
* Work w/ ***universe*** of items
    * Universe made up of all items that can be member of a set
    * Every item = member of exactly one set
* 2 operations (***partition*** or ***union/find*** data structures):
    * **Union:** Merge 2 sets into 1
    * **Find:** What set item belongs to
* Applications of union/find data structures = maze generation & Kruskal's algorithm for computing minimum spanning tree of graph

## List-Based Disjoint Sets & the Quick-Find Algorithm
* Each set references list of items in that set
* Each item references set that contains it
* `find` operations O(1) time → list-based disjoint sets use ***quick-find*** algorithm
* `union` operations slow b/c when 2 sets united, must walk through one set & relabel all items to reference other set

## Tree-Based Disjoint Sets & the Quick-Union Algorithm
* In tree-based disjoint sets, `union` operations take O(1) time, but find operations are slower
* For any sequence of `union` & `find` operations, quick-union algorithm = faster overall than quick-find algorithm
* To support fast unions, each set stored as general tree
* Quick-union data structure comprises ***forest*** (collection of trees)
    * Each item initially root of own tree
    * Trees merged by `union` operations
* Quick-union data structure simpler than general tree structures b/c no child or sibling references
    * Every node knows only its parent → can only walk up tree
    * True identity of each set recorded at root
* `union` = O(1) operation → make root of one set become child of root of other set
* Finding set to which given item belongs not constant-time operation
    * `find` operation performed by following chain of parent references from item to root of tree
    * Cost $$\propto$$ item's depth in tree

* Two optimizations:
    * ***Union-by-size*** helps `union` operation build shorter trees
    * ***Path compression*** gives `find` operation power to shorten trees
* ***Union-by-size*** = strategy to keep items from getting too deep by uniting sets intelligently
    * At each root, record size of tree (# of nodes in tree)
    * When uniting 2 trees → make smaller tree subtree of larger one (breaking ties arbitrarily)

## Implementing Quick-Union w/ an Array
```java
public void union(int root1, int root2) {
    if (array[root2] < array[root1]) { // root2 has larger tree
        array[root2] += array[root1];  // update # of items in root2's tree
        array[root1] = root2;          // make root2 parent of root1
    } else {                           // root1 has equal or larger tree
        array[root1] += array[root2];  // update # of items in root1's tree
        array[root2] = root1;          // make root1 parent of root2
    }
}
```

## Path Compression
```java
public int find(int x) {
    if (array[x] < 0) {
        return x; // x is the root of the tree; return it
    } else {
        // Find out who the root is; compress path by making the root x's parent
        array[x] = find(array[x]);
        return array[x]; // Return the root
    }
}
```

## Naming Sets
* Maintain additional array that maps root items to set names (& vice versa, depending on application's needs)
    * Must modify `union()` → assigns union an appropriate name when uniting 2 sets
* For many applications, don't care about name of set at all → only want to know if 2 items `x` & `y` in same set

## Running Time of Quick-Union
* `union` operations $$\Theta(1)$$
* If using union-by-size, single `find` operation can take $$\Theta(\log{u})$$ worst-case time, $$u$$ = # of union operations that took place prior to `find`
    * Path compression doesn't improve worst-case time, but improves *average* running time substantially
        * Although `find` operation can take $$\Theta(\log{u})$$ time, path compression will make operation fast if done again
    * Average running time of `find` & `union` operations in quick-union data structure so close to constant (hardly worth mentioning that, in rigorous asymptotic sense, slightly slower than constant)
* Sequence of $$f$$ `find` & $$u$$ `union` operations (in any order & possibly interleaved) takes $$\Theta(u + f \alpha(f + u, u))$$ time in worst case
    * $$\alpha$$ = extremely slowly-growing function, ***inverse Ackermann function***
        * Inverse Ackermann function never larger than 4 for any practical values of $$f$$ & $$u$$, but does grow arbitrarily large (for unimaginably gigantic values of $$f$$ & $$u$$)
        * $$\forall$$ practical purposes, can think of quick-union as having `find` operations that run, on overage, in constant time
