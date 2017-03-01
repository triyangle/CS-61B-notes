# Asymptotics I
* Pick some representative operation → ***cost model***
* Big O: Bounding above (less than)
* Big 𝛀: Bounding below (greater than)
* **Big 𝚯:** Bounding above & below (equals)
* Pick some representative operation → _**cost model**_

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

## Summary
| Category                                   | Informal Meaning                                                  | Family                              | Family Members                                                                                           |
|:------------------------------------------:|:-----------------------------------------------------------------:|:-----------------------------------:|:--------------------------------------------------------------------------------------------------------:|
| Big 𝚯 {% math %}\Theta(f(N)){% endblock %} | {% math %}R(N) \propto f(N){% endblock %}                         | {% math %}\Theta(N^2){% endblock %} | {% math %}\frac{N^2}{2}{% endblock %} {% math %}2N^2{% endblock %} {% math %}N^2 + 38N + N{% endblock %} |
| Big O {% math %}O(f(N)){% endblock %}      | {% math %}R(N) \leq f(N){% endblock %}                            | {% math %}O(N^2){% endblock %}      | {% math %}\frac{N^2}{2}{% endblock %} {% math %}2N^2{% endblock %} {% math %}\log(N){% endblock %}       |
| Big 𝛀 {% math %}\Omega(f(N)){% endblock %} | {% math %}R(N) \geq f(N){% endblock %}                            | {% math %}\Omega(N^2){% endblock %} | {% math %}\frac{N^2}{2}{% endblock %} {% math %}2N^2{% endblock %} {% math %}e^N{% endblock %}           |
| Tilde {% math %}\sim f(N){% endblock %}    | {% math %}\lim_{n \to \infty} \frac{R(N)}{f(N)} = 1{% endblock %} | {% math %}\sim 2N^2{% endblock %}   | {% math %}2N^2{% endblock %} {% math %}2N^2 + 5{% endblock %}                                            |
