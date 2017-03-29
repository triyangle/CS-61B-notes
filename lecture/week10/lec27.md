# Graph Traversals

## [Graph Problems](https://docs.google.com/presentation/d/1SeJA6Gup2Pti4jcn73khxIWR5iSmoe9tXnlMWq-aiDM/edit#slide=id.g99668982c_1_173)
* Runtime $$\Theta(V + E)$$
    * Each vertex visited exactly once, each visit = constant time
    * Each edge considered once
* Space $$\Theta(V)$$
    * Recursive call stack depth $$\leq V$$
    * Space of recursive algorithm = depth of call stack

## [Graph Traversals](https://docs.google.com/presentation/d/1SeJA6Gup2Pti4jcn73khxIWR5iSmoe9tXnlMWq-aiDM/edit#slide=id.g99668982c_1_30)
* Level-order/BFS for vertices at same distance from source can be in any permutation
* If $$\exists$$ multiple paths to a vertex, BFS always visits based on [closest path](https://docs.google.com/presentation/d/1SeJA6Gup2Pti4jcn73khxIWR5iSmoe9tXnlMWq-aiDM/edit#slide=id.g128656a55e_0_70)
* [Traversals & Graph Problems](https://docs.google.com/presentation/d/1SeJA6Gup2Pti4jcn73khxIWR5iSmoe9tXnlMWq-aiDM/edit#slide=id.g99668982c_1_670)

## [Topological Sorting](https://docs.google.com/presentation/d/1SeJA6Gup2Pti4jcn73khxIWR5iSmoe9tXnlMWq-aiDM/edit#slide=id.g99668982c_1_1182)
* Indegree 0 vertices → $$\Theta(E + V)$$, have to look at $$V$$ lists w/ total length $$E$$
* Only works if graph is acyclic → $$\varnothing$$ if cyclic b/c can't have circular dependencies
    * No indegree 0 vertices → cyclic → $$\varnothing$$
* Topological ordering only possible iff graph is directed acyclic graph (no directed cycles)
* [Linearizes graph](https://docs.google.com/presentation/d/1SeJA6Gup2Pti4jcn73khxIWR5iSmoe9tXnlMWq-aiDM/edit#slide=id.g99668982c_1_401)
* [Graph Problems](https://docs.google.com/presentation/d/1SeJA6Gup2Pti4jcn73khxIWR5iSmoe9tXnlMWq-aiDM/edit#slide=id.g99668982c_1_1236)

### Implementation

```java
public class DepthFirstOrder {

    private boolean[] marked;
    private Stack<Integer> reversePostorder; // using stack analogous to reversing list b/c LIFO

    public DepthFirstOrder(Digraph G) {
        reversePostorder = new Stack<>();
        marked = new boolean[G.V()];
        for (int v = 0; v < G.V(); v++) {
            if (!marked[v]) {
                dfs(G, v);
            }
        }
    }

    private void dfs(Digraph G, int v) {
        marked[v] = true;
        for (int w : G.adj(v)) {
            if (!marked[w]) {
                dfs(G, w);
            }
        }
        reversePostorder.push(v); // after each DFS is done, "visit" vertex by pushing on stack
    }
}
```

* Works even when starting from vertices not indegree 0

## [Breadth First Search](https://docs.google.com/presentation/d/1SeJA6Gup2Pti4jcn73khxIWR5iSmoe9tXnlMWq-aiDM/edit#slide=id.g99668982c_1_1268)
* [Finding Level-Order](https://docs.google.com/presentation/d/1SeJA6Gup2Pti4jcn73khxIWR5iSmoe9tXnlMWq-aiDM/edit#slide=id.g99668982c_1_1302)
* DFS written recursively has implicit fringe → recursive call stack of vertices
