# MSTs
* [Graph cycles](https://docs.google.com/presentation/d/1_6He8y70rmYI2ApbB8NisN4ws870i0zTFpbUpwMdctQ/edit#slide=id.g85b829717_0_177)

## [Spanning Trees](https://docs.google.com/presentation/d/1_6He8y70rmYI2ApbB8NisN4ws870i0zTFpbUpwMdctQ/edit#slide=id.g5347e2c8f_220)
* Given **undirected** graph w/ weighted edges, ***spanning tree*** T is a subgraph of G where T:
    * Is connected & acyclic → tree
        * Not connected → multiple separate trees → forest
    * Includes all of the vertices → spanning
* ***Minimum spanning tree*** = spanning tree w/ total edge weight minimized

## [MST vs SPT](https://docs.google.com/presentation/d/1_6He8y70rmYI2ApbB8NisN4ws870i0zTFpbUpwMdctQ/edit#slide=id.g8dda9da1a73768a_19)
* MST = fundamentally non-sourced object → not every graph has node for which SPT is also MST

## [Cut Property](https://docs.google.com/presentation/d/1_6He8y70rmYI2ApbB8NisN4ws870i0zTFpbUpwMdctQ/edit#slide=id.g5347e2c8f_2179)
* ***Cut*** = assign every node either color gray or white → assignment of graph's nodes to 2 non-empty sets
* ***Crossing edge*** = edge connecting node from one set to node from other set
* ***Cut property:*** Given any cut, minimum weight crossing edge guaranteed to be in MST
    * If multiple edges have same minimum weight → have to deal w/ tie-breaking, otherwise if unique edge weights, MST will contain minimum weight crossing edge
* Color/set assignment doesn't have to be contiguous → can be any assignment → flip coin $$\forall$$ vertices to determine what color/set

### [Cut Property Proof](https://docs.google.com/presentation/d/1_6He8y70rmYI2ApbB8NisN4ws870i0zTFpbUpwMdctQ/edit#slide=id.g5347e2c8f_2202)
* Suppose minimum weight crossing edge $$e$$ not in MST
    * Adding $$e$$ to MST creates cycle → can eliminate one edge in order to make it an MST again
    * Some other edge $$f$$ must also be crossing edge
    * If spanning tree doesn't contain minimum weight crossing edge → can replace currently used crossing edge w/ minimum crossing edge → will still be spanning tree w/ lower weight
    * Replacing $$f$$ w/ $$e$$ results in lower weight spanning tree → contradiction
* If minimum weight crossing edge $$e$$ not in MST, can use $$e$$ instead of some other crossing edge

## [Generic MST Finding Algorithm](https://docs.google.com/presentation/d/1_6He8y70rmYI2ApbB8NisN4ws870i0zTFpbUpwMdctQ/edit#slide=id.g5347e2c8f_2208)
* Need efficient way of finding cut w/ no crossing edges in MST
    * If cut randomly, may end up finding same minimum crossing edge each time

## [Prim's Algorithm](https://docs.google.com/presentation/d/1_6He8y70rmYI2ApbB8NisN4ws870i0zTFpbUpwMdctQ/edit#slide=id.g772f8a8e2_0_28)
* Fringe contains all vertices in other set (other side of cut)
* Difference between Dijkstra's = considers edge weight instead of total path weight

### [Prim's Vs Dijkstra's](https://docs.google.com/presentation/d/1_6He8y70rmYI2ApbB8NisN4ws870i0zTFpbUpwMdctQ/edit#slide=id.g772f8a8e2_0_44)
* Dijkstra's algorithm explores based on distance from source, SPT expands outwards
* Prim's algorithm explores based on distance from MST under construction, jumps around

### [Prim's Runtime](https://docs.google.com/presentation/d/1_6He8y70rmYI2ApbB8NisN4ws870i0zTFpbUpwMdctQ/edit#slide=id.g772f8a8e2_0_83)
* Same as Dijkstra's

## [Kruskal's Algorithm](https://docs.google.com/presentation/d/1_6He8y70rmYI2ApbB8NisN4ws870i0zTFpbUpwMdctQ/edit#slide=id.g5347e2c8f_2213)
* Compares distance/weight of edges (edge based) instead of distance/weight from vertex to spanning tree (Prim's, vertex based)
* Use weighted quick union to determine whether edge creates cycle

## Prim's vs Kruskal's
* If unique weight edges → should get same answer for both (b/c only 1 MST)
* Both ultimately rely on cut property

## [Kruskal's Runtime](https://docs.google.com/presentation/d/1_6He8y70rmYI2ApbB8NisN4ws870i0zTFpbUpwMdctQ/edit#slide=id.g772f8a8e2_0_110)
* $$V$$ `connect` operations b/c MST has total $$V - 1$$ edges/connections

## [Shortest Paths & MST Algorithms Summary](https://docs.google.com/presentation/d/1_6He8y70rmYI2ApbB8NisN4ws870i0zTFpbUpwMdctQ/edit#slide=id.g772f8a8e2_0_122)
