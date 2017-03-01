# Asymptotics I
* Pick some representative operation → ***cost model***
* Big O: Bounding above (less than)
* Big 𝛀: Bounding below (greater than)
* **Big 𝚯:** Bounding above & below (equals)

## Big 𝚯
* Performance measurement $$R(N)$$, $$N = \text{size of problem}$$

$$
R(N) \in \Theta(f(N)) \implies \exists\ \ k_1,\ k_2 > 0 \ |\ k_1 \cdot f(N) \leq R(N) \leq k_2 \cdot f(N)
$$
$$
\forall\ N > N_0
$$

## Big O
* Only bounds from above
* Order of growth of $$R(N) \leq f(N)$$

$$
R(N) \in O(f(N)) \implies \exists\ \ k > 0 \ |\ R(N) \leq k \cdot f(N)
$$
$$
\forall\ N > N_0
$$

## Summary
| Category                   | Informal Meaning                              | Family          | Family Members                                       |
|:--------------------------:|:---------------------------------------------:|:---------------:|:----------------------------------------------------:|
| Big 𝚯 <br>$$\Theta(f(N))$$ | $$R(N) \propto f(N)$$                         | $$\Theta(N^2)$$ | $$\frac{N^2}{2}$$ <br>$$2N^2$$ <br>$$N^2 + 38N + N$$ |
| Big O <br>$$O(f(N))$$      | $$R(N) \leq f(N)$$                            | $$O(N^2)$$      | $$\frac{N^2}{2}$$ <br>$$2N^2$$ <br>$$\log(N)$$       |
| Big 𝛀 <br>$$\Omega(f(N))$$ | $$R(N) \geq f(N)$$                            | $$\Omega(N^2)$$ | $$\frac{N^2}{2}$$ <br>$$2N^2$$ <br>$$e^N$$           |
| Tilde <br>$$\sim f(N)$$        | $$\lim_{n \to \infty} \frac{R(N)}{f(N)} = 1$$ | $$\sim 2N^2$$   | $$2N^2$$ <br>$$2N^2 + 5$$                            |
