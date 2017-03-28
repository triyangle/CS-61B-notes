# Graphs
* **Graph:** Set of nodes/vertices connected pairwise by edges

## [Graph Types](https://docs.google.com/presentation/d/1GOOt1Ierm9jJFq9o26uRW20GdU6E5hrAZvsoQIreJew/edit#slide=id.g52b1323b6_0160)
* **Directed:** Edges have notion of direction (one-way)
    * **Acyclic:** No cycles (lead back to start)
    * **Cyclic:** $$\exists \geq 1 \text{ cycle}$$
* **Undirected:** No notion of directionality, can traverse either way (bidirectional?)
    * **Acyclic:** No cycles (lead back to start) w/out reusing any edges
    * **Cyclic:** $$\exists \geq 1 \text{ path that leads to start w/out reusing any edges}$$
* Any graph w/ cycle = cyclic
    * If not → acyclic
* [Terminology](https://docs.google.com/presentation/d/1GOOt1Ierm9jJFq9o26uRW20GdU6E5hrAZvsoQIreJew/edit)
* [Graph Processing Problems](https://docs.google.com/presentation/d/1GOOt1Ierm9jJFq9o26uRW20GdU6E5hrAZvsoQIreJew/edit#slide=id.g76e0dad85_0_8)

## Graph Representations
* [Common Simplification](https://docs.google.com/presentation/d/1GOOt1Ierm9jJFq9o26uRW20GdU6E5hrAZvsoQIreJew/edit#slide=id.g76e0dad85_2_41)
* Degree = # of edges incident on graph node
* [Graph API](https://docs.google.com/presentation/d/1GOOt1Ierm9jJFq9o26uRW20GdU6E5hrAZvsoQIreJew/edit#slide=id.g127a4373ba_0_21)
* [Adjacency Matrix](https://docs.google.com/presentation/d/1GOOt1Ierm9jJFq9o26uRW20GdU6E5hrAZvsoQIreJew/edit#slide=id.g76e0dad85_2_79)
    * [Runtime](https://docs.google.com/presentation/d/1GOOt1Ierm9jJFq9o26uRW20GdU6E5hrAZvsoQIreJew/edit)
* [Edge Sets](https://docs.google.com/presentation/d/1GOOt1Ierm9jJFq9o26uRW20GdU6E5hrAZvsoQIreJew/edit#slide=id.g52b1323b6_0612)
* [Adjacency Lists](https://docs.google.com/presentation/d/1GOOt1Ierm9jJFq9o26uRW20GdU6E5hrAZvsoQIreJew/edit#slide=id.g471792ea7_033)
    * [Runtime](https://docs.google.com/presentation/d/1GOOt1Ierm9jJFq9o26uRW20GdU6E5hrAZvsoQIreJew/edit#slide=id.g127a4373ba_0_41)
        * If sparse graph (few edges) → $$\Theta(V)$$
        * If dense graph (many edges) → $$\Theta(E)$$
    * [Bare-Bones Undirected Graph Implementation](https://docs.google.com/presentation/d/1GOOt1Ierm9jJFq9o26uRW20GdU6E5hrAZvsoQIreJew/edit#slide=id.g76e0dad85_2_196)
* [Summary](https://docs.google.com/presentation/d/1GOOt1Ierm9jJFq9o26uRW20GdU6E5hrAZvsoQIreJew/edit#slide=id.g76e0dad85_2_142)

## [Depth First Traversal](https://docs.google.com/presentation/d/1GOOt1Ierm9jJFq9o26uRW20GdU6E5hrAZvsoQIreJew/edit#slide=id.g76e0dad85_2_380)
* [Implementation](https://docs.google.com/presentation/d/1GOOt1Ierm9jJFq9o26uRW20GdU6E5hrAZvsoQIreJew/edit#slide=id.g76e0dad85_2_480)
* Properties
    * Guaranteed to reach every reachable node
    * Runs in $$O(V + E)$$ time
        * Every edge used at most once, total # of vertex considerations = # of edges
            * \# of times need to consider vertex <= # of edges incident on it
            * May be faster for some problems which quit early on some stopping condition (e.g. connectivity)
