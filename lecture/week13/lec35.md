# Sorting & Algorithmic Bounds

## [$$\log{(N!)} \in \Theta(N \log{N})$$](https://docs.google.com/presentation/d/16rqFtnhrD0fpEPKRZ74CawjFoJ-TrIIs0jvP4loonG4/edit#slide=id.g1d7ce38570_0_64)
* $$\log{(N!)}$$ asymptotically same function as $$N \log{N}$$

## [Puppy, Cat, Dog, Walrus](https://docs.google.com/presentation/d/16rqFtnhrD0fpEPKRZ74CawjFoJ-TrIIs0jvP4loonG4/edit#slide=id.g769a55e71_0_131)
* Decision tree not complete binary tree → round up to next integer tree height/depth

### [Generalized](https://docs.google.com/presentation/d/16rqFtnhrD0fpEPKRZ74CawjFoJ-TrIIs0jvP4loonG4/edit#slide=id.g12b7767647_0_382)
* Tree needs at least $$\lceil \log{(N!)} \rceil$$ levels to have $$N!$$ leaves

### [Reducing](https://docs.google.com/presentation/d/16rqFtnhrD0fpEPKRZ74CawjFoJ-TrIIs0jvP4loonG4/edit#slide=id.g2fc129f8d_0_338)
* Sorting = specific solution to general problem of puppy, cat, dog → any lower bound on difficulty of puppy, cat, dog must ALSO apply to sorting

## [Optimality](https://docs.google.com/presentation/d/16rqFtnhrD0fpEPKRZ74CawjFoJ-TrIIs0jvP4loonG4/edit#slide=id.g2fc129f8d_0_78)
* Sorting via sequential (non-parallel) comparisons → can't do better than $$\Theta(N \log{N})$$

## [Random Numbers](https://docs.google.com/presentation/d/16rqFtnhrD0fpEPKRZ74CawjFoJ-TrIIs0jvP4loonG4/edit#slide=id.g1d7ce1e520_46_11)
* Recording random stuff = expensive → usually rely on pseudorandomness instead (overflow via repeated multiplication on starting seed value)
