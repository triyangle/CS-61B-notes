# Asymptotics I
* Pick some representative operation → ***cost model***
* Big O: Bounding above (less than)
* Big 𝛀: Bounding below (greater than)
* **Big 𝚯:** Bounding above & below (equals)
* Pick some representative operation → _**cost model**_

## Big 𝚯
* Performance measurement $$R(N)$$, $$N = \text{size of problem}$$

$$R(N) \in \Theta(f(N)) \implies \exists\ \ k_1,\ k_2 > 0 \ |\ k_1 \cdot f(N) \leq R(N) \leq k_2 \cdot f(N)$$
$$\forall\ N > N_0$$

## Big O
* Only bounds from above
* Order of growth of $$R(N) \leq f(N)$$

$$R(N) \in O(f(N)) \implies \exists\ \ k > 0 \ |\ R(N) \leq k \cdot f(N)$$
When {% math %}a \ne 0{% endmath %}, there are two solutions to {% math %}(ax^2 + bx + c = 0){% endmath %} and they are {% math %}x = {-b \pm \sqrt{b^2-4ac} \over 2a}.{% endmath %}
## Summary
| Category               | Informal Meaning                              | Family          | Family Members                               |
|:----------------------:|:---------------------------------------------:|:---------------:|:--------------------------------------------:|
| Big 𝚯 $$\Theta(f(N))$$ | $$R(N) \propto f(N)$$                         | $$\Theta(N^2)$$ | $$\frac{N^2}{2}$$ $$2N^2$$ $$N^2 + 38N + N$$ |
| Big O $$O(f(N))$$      | $$R(N) \leq f(N)$$                            | $$O(N^2)$$      | $$\frac{N^2}{2}$$ $$2N^2$$ $$\log(N)$$       |
| Big 𝛀 $$\Omega(f(N))$$ | $$R(N) \geq f(N)$$                            | $$\Omega(N^2)$$ | $$\frac{N^2}{2}$$ $$2N^2$$ $$e^N$$           |
| Tilde $$\sim f(N)$$    | $$\lim_{n \to \infty} \frac{R(N)}{f(N)} = 1$$ | $$\sim 2N^2$$   | $$2N^2$$ $$2N^2 + 5$$                        |
