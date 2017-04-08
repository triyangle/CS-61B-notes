# Advanced Trees, including Geometric

## Traversals
### Rooted Trees
* Tree iteration = tree traversal
* Unlike lists, many natural orderings

### Tree Traversal
* Level Order
    * Traverse top-to-bottom, left-to-right
    * Nodes "visited" in given order
* [Depth First Traversals](https://docs.google.com/presentation/d/1ifkiC-l0DfQRXEHFfQpg_AcZkaUyj9CCEUKOYPuyBZ0/edit#slide=id.g75c09ac94_0693)
    * Preorder (root, left, right), Inorder (left, root, right), Postorder (left, right, root)
        * [A Weird Trick](https://docs.google.com/presentation/d/1ifkiC-l0DfQRXEHFfQpg_AcZkaUyj9CCEUKOYPuyBZ0/edit#slide=id.g75c09ac94_0715)
        * [Preorder Traversal Runtime](https://docs.google.com/presentation/d/1ifkiC-l0DfQRXEHFfQpg_AcZkaUyj9CCEUKOYPuyBZ0/edit#slide=id.g42d4f6d39_0109)
* Level Order Traversal
    * [Iterative Deepening](https://docs.google.com/presentation/d/1ifkiC-l0DfQRXEHFfQpg_AcZkaUyj9CCEUKOYPuyBZ0/edit#slide=id.g75c09ac94_028)
        * [Runtime](https://docs.google.com/presentation/d/1ifkiC-l0DfQRXEHFfQpg_AcZkaUyj9CCEUKOYPuyBZ0/edit#slide=id.g75c09ac94_0159) $$\Theta(N)$$ b/c each new level doubles amount of work done & # of nodes visited
            * Exponential in height of tree, $$\Theta(2^{H})$$ → height logarithmic in # of nodes, $$H = \Theta(\log{N})$$ → overall runtime linear in # of nodes, $$\Theta(N)$$
        * [Spindly Runtime](https://docs.google.com/presentation/d/1ifkiC-l0DfQRXEHFfQpg_AcZkaUyj9CCEUKOYPuyBZ0/edit#slide=id.g75c09ac94_0210) $$\Theta(N^{2})$$
        * [Tree Height & Runtime](https://docs.google.com/presentation/d/1ifkiC-l0DfQRXEHFfQpg_AcZkaUyj9CCEUKOYPuyBZ0/edit#slide=id.g75c09ac94_0223)

## Range Finding
* Instead of traversing entire tree, only want to look at items in certain range

### Pruning & `findInRange` Runtime
* **Pruning:** Restrict search to only nodes containing path(s) to answer(s)
* [Runtime](https://docs.google.com/presentation/d/1ifkiC-l0DfQRXEHFfQpg_AcZkaUyj9CCEUKOYPuyBZ0/edit#slide=id.g11f3cf3f77_0_250)

## Spatial Trees

### [Handling Multidimensional Data: Quadtrees](https://docs.google.com/presentation/d/1ifkiC-l0DfQRXEHFfQpg_AcZkaUyj9CCEUKOYPuyBZ0/edit#slide=id.g11f3cf3f77_0_157)
* [Generalization of BST](https://docs.google.com/presentation/d/1vqAJkvUxSh-Eq4iIJZevjpY29nagNTjx-4N3HpDi0UQ/edit#slide=id.g11f44e6637_0_250)
* Think of items as oriented in particular 2D direction (e.g NW/NE/SW/SE instead of binary </\>)
* Can have mutliple different quadtrees for same set of data
    * Just like BST, insertion order determines topology of QuadTree
* If on boundary line, usually assume = → >
* [Pruning](https://docs.google.com/presentation/d/1ifkiC-l0DfQRXEHFfQpg_AcZkaUyj9CCEUKOYPuyBZ0/edit#slide=id.g11f3cf3f77_0_350)
    * Analogous to binary search on BST (eliminate unnecessary search spaces)
    * Ignore branches if no possible way branch could contain wanted item

## Tree Iterators (Extra)
* Use `Stack` based DFS traversal
