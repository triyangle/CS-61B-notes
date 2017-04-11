# Shortest Paths
* [Reachability](https://docs.google.com/presentation/d/14MotRlepBzlhoqgYVmQcBRFpDO0kUs_zHqf3NB-BR88/edit#slide=id.g859e59c73_0_1)
    * Prefer BFS in Java b/c of call stack depth limit
* [Graph Problems](https://docs.google.com/presentation/d/14MotRlepBzlhoqgYVmQcBRFpDO0kUs_zHqf3NB-BR88/edit#slide=id.g431b6f645db5a43c_0)
    * Tree = special graph, acyclic, no node has more than 1 parent (directed graph)

## Dijkstra's Algorithm

### [Single Source Single Target Shortest Paths](https://docs.google.com/presentation/d/14MotRlepBzlhoqgYVmQcBRFpDO0kUs_zHqf3NB-BR88/edit#slide=id.g1db8851c42_6_129)
* Given graph, $$\forall \text{ given source, } \exists$$ [shortest paths tree](https://docs.google.com/presentation/d/14MotRlepBzlhoqgYVmQcBRFpDO0kUs_zHqf3NB-BR88/edit#slide=id.g1db8851c42_45_46)
    * $$\forall$$ graphs w/ no negative cycles/weights
        * Graph w/ negative cycles/weights → shortest path = loop around cycle $$\infty$$ # of times
* May be multiple shortest paths trees, $$\exists \geq 1$$ shortest path tree $$\forall$$ given source → gives shortest path to everything

### [SPT Edge Count](https://docs.google.com/presentation/d/14MotRlepBzlhoqgYVmQcBRFpDO0kUs_zHqf3NB-BR88/edit#slide=id.g99cc41691_0_1009)
* Connected = everything reachable from source

### Finding a Shortest Paths Tree
* [Edge relaxation](https://docs.google.com/presentation/d/14MotRlepBzlhoqgYVmQcBRFpDO0kUs_zHqf3NB-BR88/edit#slide=id.g99cc41691_0_558)
* [Dijkstra's Algorithm](https://docs.google.com/presentation/d/14MotRlepBzlhoqgYVmQcBRFpDO0kUs_zHqf3NB-BR88/edit#slide=id.g99cc41691_0_623)
    * Dijkstra's visits in [best-first search](https://docs.google.com/presentation/d/14MotRlepBzlhoqgYVmQcBRFpDO0kUs_zHqf3NB-BR88/edit#slide=id.g99cc41691_0_976)
    * [Implementation/Demo](https://docs.google.com/presentation/d/14MotRlepBzlhoqgYVmQcBRFpDO0kUs_zHqf3NB-BR88/edit#slide=id.g99cc41691_0_115)
        * Dequeued vertex = shortest path to dequeued vertex found
            * Already visited everything closer to source than dequeued vertex → inductive argument, already know shortest paths to everything already visited → dequeued vertex = closest thing from all vertices closest to source
            * Does things in order of distance from source
        * If non-negative weights, [**impossible for any inactive vertex** (white, not on fringe) **to be improved**](https://docs.google.com/presentation/d/1_bw2z1ggUkquPdhl7gwdVBoTaoJmaZdpkV6MoAgxlJc/edit#slide=id.g771336078_0_957)
    * [Proof sketch](https://docs.google.com/presentation/d/14MotRlepBzlhoqgYVmQcBRFpDO0kUs_zHqf3NB-BR88/edit#slide=id.g99cc41691_0_976)
    * [Implementation/Pseudocode](https://docs.google.com/presentation/d/14MotRlepBzlhoqgYVmQcBRFpDO0kUs_zHqf3NB-BR88/edit#slide=id.g99cc41691_0_753)
    * [Runtime](https://docs.google.com/presentation/d/14MotRlepBzlhoqgYVmQcBRFpDO0kUs_zHqf3NB-BR88/edit#slide=id.g99cc41691_0_963)
        * Insert each vertex from priority queue → total $$V$$ times, each costing $$O(\log{V})$$ time
        * Delete each vertex from priority queue → total $$V$$ times, each costing $$O(\log{V})$$ time
        * In worst case, every single relaxation changes priority of vertex → $$E$$ `decreasePriority` operations, each costing $$O(\log{V})$$ time
        * Overall runtime: $$O(V \cdot \log{V} + V \cdot \log{V} + E \cdot \log{V}$$ → $$O((E + V) \cdot \log{V})$$
            * Assuming $$E > V$$ → $$O(E \cdot \log{V})$$
                * For every vertex $$V$$ in connected graph, need at least $$V - 1$$ total edges, $$V - 1$$ edges = minimum # of edges → spanning tree
                * $$> V - 1$$ edges → $$\exists$$ cycle(s)
                * $$E > V$$ usually, otherwise graph is just a spanning tree
    * [Graph Problems](https://docs.google.com/presentation/d/14MotRlepBzlhoqgYVmQcBRFpDO0kUs_zHqf3NB-BR88/edit#slide=id.g99cc41691_0_957)
### Single Target Dijkstra's
* Gives correct answer, but inefficient b/c searches in all possible directions

## [A*](https://docs.google.com/presentation/d/14MotRlepBzlhoqgYVmQcBRFpDO0kUs_zHqf3NB-BR88/edit#slide=id.g52d304ea8_1106)
* If only ***single target*** in mind, need different algorithm

### [Introducing A*](https://docs.google.com/presentation/d/14MotRlepBzlhoqgYVmQcBRFpDO0kUs_zHqf3NB-BR88/edit#slide=id.g52d304ea8_1139)
* Instead of best-first, do best-guess first
    * Visit in order of distance from source + estimate of how far away target is, instead of just distance from source

### [Impact of Heuristic Quality](https://docs.google.com/presentation/d/14MotRlepBzlhoqgYVmQcBRFpDO0kUs_zHqf3NB-BR88/edit#slide=id.g52d304ea8_013)
* Picking $$h(v)$$ to be some arbitrary constant → Dijkstra's algorithm
* Heuristic can be bad
    * Possible to pick bad heuristic that causes algorithm to fail
* Heuristic should never overestimate → pick anything that underestimates
    * **Admissible:** Heuristic never overestimates → always get the right answer
    * Pessimistic heuristics still work → pick underestimating admissible heuristic to be safe

### [A* vs Dijkstra's](https://docs.google.com/presentation/d/14MotRlepBzlhoqgYVmQcBRFpDO0kUs_zHqf3NB-BR88/edit#slide=id.g99cc41691_0_909)

## [Summary: Shortest Paths Problems](https://docs.google.com/presentation/d/14MotRlepBzlhoqgYVmQcBRFpDO0kUs_zHqf3NB-BR88/edit#slide=id.g52fde9d29_00)
* A* analogous to pruning & binary search → eliminate unnecessary search spaces

# [Consistency & Admissibility (Extra)](https://docs.google.com/presentation/d/14MotRlepBzlhoqgYVmQcBRFpDO0kUs_zHqf3NB-BR88/edit#slide=id.g99cc41691_0_925)

# [Iterative DFS (Extra)](https://docs.google.com/presentation/d/14MotRlepBzlhoqgYVmQcBRFpDO0kUs_zHqf3NB-BR88/edit#slide=id.g431b6f645db5a43c_93)
* Don't mark vertex when added to fringe b/c may be visited again as part of first depth-first path
