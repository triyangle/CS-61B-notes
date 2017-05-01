# Reductions, Algorithmic Bounds, NP Completeness

## [HugPlant](https://docs.google.com/presentation/d/1m-LOrlMJboW4jTc_Ggir26Q3R4L_KK7oJKlEgT3Uxy8/edit#slide=id.g1d9b0cee5f_0_0)

## [Kolmogorov Complexity (Language Independence)](https://docs.google.com/presentation/d/1m-LOrlMJboW4jTc_Ggir26Q3R4L_KK7oJKlEgT3Uxy8/edit#slide=id.g12d7b1ac9b_1_167)
* Random bitstream → unable to deterministically produce it in much shorter program
* Some bitstreams = special, can be produced by all programming languages in compact amount of space

## [Kolmogorov Complexity (Uncomputability)](https://docs.google.com/presentation/d/1m-LOrlMJboW4jTc_Ggir26Q3R4L_KK7oJKlEgT3Uxy8/edit#slide=id.g12d7b1ac9b_1_183)
* **Impossible** to write program that calculates/computes Kolmogorov Complexity of any bitstream → corollary → **impossible** to write "perfect" compression algorithm
    * No way to do it in reverse, impossible b/c if possible to produce smallest program could just see how long it is (to obtain Kolmogorov Complexity) → violates uncomputability of Kolmogorov Complexity

## [Problem Difficulty](https://docs.google.com/presentation/d/1m-LOrlMJboW4jTc_Ggir26Q3R4L_KK7oJKlEgT3Uxy8/edit#slide=id.g12d7b1ac9b_1_205)
* Hardest = impossible

### [Independent Set Problem](https://docs.google.com/presentation/d/1m-LOrlMJboW4jTc_Ggir26Q3R4L_KK7oJKlEgT3Uxy8/edit#slide=id.g12d7b1ac9b_1_245)
* Worst case each red vertex has $$N$$ neighbors → $$\forall$$ red vertex, check that neighbors are all white → $$O(k \cdot N)$$
* Computing next coloring fast → enumerate binary number (bitshifting for all possible permutations)

### [Reductions & "Cracking"](https://docs.google.com/presentation/d/1m-LOrlMJboW4jTc_Ggir26Q3R4L_KK7oJKlEgT3Uxy8/edit#slide=id.g12d7b1ac9b_1_285)
* Sorting = tool to solve median finding problem
* $$Y$$ = tool to solve $$X$$

### [The Class P](https://docs.google.com/presentation/d/1m-LOrlMJboW4jTc_Ggir26Q3R4L_KK7oJKlEgT3Uxy8/edit#slide=id.g12d7b1ac9b_1_468)
* ***Decision problem*** = problem w/ yes/no (true/false) answer
* $$\Theta(N \log{N}) \in O(N^{k})$$ where $$k = 2$$ → sorting is in complexity class P
* Solvable quickly
* [Matters b/c fast](https://docs.google.com/presentation/d/1m-LOrlMJboW4jTc_Ggir26Q3R4L_KK7oJKlEgT3Uxy8/edit#slide=id.g12d7b1ac9b_1_480)

### [THe Class NP](https://docs.google.com/presentation/d/1m-LOrlMJboW4jTc_Ggir26Q3R4L_KK7oJKlEgT3Uxy8/edit#slide=id.g12d7b1ac9b_1_474)
* NP problem = yes/no (true/false), & checkable/verifiable quickly

#### [Why Does The Complexity Class NP Matter?](https://docs.google.com/presentation/d/1m-LOrlMJboW4jTc_Ggir26Q3R4L_KK7oJKlEgT3Uxy8/edit#slide=id.g12d7b1ac9b_1_486)
* Computation may be hard
* NP = yes/true answers verifiable quickly
* [co-NP](https://en.wikipedia.org/wiki/Co-NP) = no/false answers verifiable quickly

### [Independent Set Difficulty](https://docs.google.com/presentation/d/1m-LOrlMJboW4jTc_Ggir26Q3R4L_KK7oJKlEgT3Uxy8/edit#slide=id.g12d7b1ac9b_1_491)
* $$P \subset NP$$

## [Problem Difficulty](https://docs.google.com/presentation/d/1m-LOrlMJboW4jTc_Ggir26Q3R4L_KK7oJKlEgT3Uxy8/edit#slide=id.g12d7b1ac9b_1_773)
* **Good Compression:** Given bitstream, is there sequence of bits $$<$$ 1 MB able to solve it? → NP problem

## [P = NP?](https://docs.google.com/presentation/d/1m-LOrlMJboW4jTc_Ggir26Q3R4L_KK7oJKlEgT3Uxy8/edit#slide=id.g12d7b1ac9b_1_584)
* If [P = NP](https://docs.google.com/presentation/d/1m-LOrlMJboW4jTc_Ggir26Q3R4L_KK7oJKlEgT3Uxy8/edit#slide=id.g12d7b1ac9b_1_597) → P = NP = NP Complete
    * Easily verifiable = easily solvable

## [Even More Impressive Consequences](https://docs.google.com/presentation/d/1m-LOrlMJboW4jTc_Ggir26Q3R4L_KK7oJKlEgT3Uxy8/edit#slide=id.g12d7b1ac9b_1_649)
* Program output by NP solver should contain structure (hierarchical, with functions/ideas)
* Compression provides understanding → know underlying pattern/structure
