# Radix Sorts

## [Comparison Based Sorting](https://docs.google.com/presentation/d/1pPdoaB7E9v_K5YyD1-fCOypxNFh2gKNGJ_Ur1v9RljE/edit#slide=id.g76a36da6d_0_20)
* Insertion sort $$\Theta(N)$$ for almost sorted array
    * Doesn't violate rule that sorting requires $$\Omega(N \log{N})$$ compares in worst/general case
    * Almost sorted array $$\neq$$ puppy-cat-dog
* For $$N$$ items → $$N!$$ possible answers to puppy-cat-dog → if asking yes/no questions, given $$Q$$ possible answers need tree w/ $$\geq \lg{Q}$$ questions in worst case to find correct answer
    * Nature of binary questions → binary decision tree

## [Avoiding Need to Compare](https://docs.google.com/presentation/d/1pPdoaB7E9v_K5YyD1-fCOypxNFh2gKNGJ_Ur1v9RljE/edit#slide=id.g465e07215_0164)

### [Sleep Sort](https://docs.google.com/presentation/d/1pPdoaB7E9v_K5YyD1-fCOypxNFh2gKNGJ_Ur1v9RljE/edit#slide=id.g465e07215_0170)
* Exploits time to "avoid" $$\log{N}$$
* Actually still $$\Theta(N \log{N})$$, since OS must maintain sorted list of processes

### [Counting Sort](https://docs.google.com/presentation/d/1pPdoaB7E9v_K5YyD1-fCOypxNFh2gKNGJ_Ur1v9RljE/edit#slide=id.g465e07215_0175)

#### [Generalizing Counting Sort](https://docs.google.com/presentation/d/1pPdoaB7E9v_K5YyD1-fCOypxNFh2gKNGJ_Ur1v9RljE/edit#slide=id.g465e07215_0180)
* Count based sorting doesn't use comparisons

#### [Implementing Counting Sort w/ Counting Arrays](https://docs.google.com/presentation/d/1pPdoaB7E9v_K5YyD1-fCOypxNFh2gKNGJ_Ur1v9RljE/edit#slide=id.g465fbc6ea_149)

#### [Counting Sort vs. Quicksort](https://docs.google.com/presentation/d/1pPdoaB7E9v_K5YyD1-fCOypxNFh2gKNGJ_Ur1v9RljE/edit#slide=id.g76b0ea46c_0_0)
* If using `Map` instead of large array of possible values, answer is less clear

#### [Runtime Analysis](https://docs.google.com/presentation/d/1pPdoaB7E9v_K5YyD1-fCOypxNFh2gKNGJ_Ur1v9RljE/edit#slide=id.g76adfa6c9_0_8)
* If sorting destructively/in-place, sorting array originally given → copy back from sorted array to original array
* If $$R \geq N$$, less useful since wasting time counting things that don't matter (not in array)
* Want to keep $$R$$, size of alphabet small

#### [Sort Summary](https://docs.google.com/presentation/d/1pPdoaB7E9v_K5YyD1-fCOypxNFh2gKNGJ_Ur1v9RljE/edit#slide=id.g76adfa6c9_0_2)
* Only when $$N$$ very large will counting sort be guaranteed to be faster than quicksort
    * In general, even if $$N \geq R$$, need to run empirical timing tests to see which is better

## [LSD Radix Sort]()
* Least Significant Digit Radix Sort
* Generalize counting sort → make useful even if items aren't from alphabet

### [Radix Sort]()
* Generalize counting sort to handle Strings/sequences of characters from an alphabet
    * Can have String/sequence of letters/suits/numbers/etc.

### [LSD (Least Significant Digit) Radix Sort]()
* Start by sorting from LSD (rightmost digit)
    * Items stay in same relative order from sorting based on previous digit → counting sort = stable
    * Don't need to use counting sort when sorting by digit, can technically use any sort
* MSD sort generally better

### [Non-equal Key Lengths](https://docs.google.com/presentation/d/1pPdoaB7E9v_K5YyD1-fCOypxNFh2gKNGJ_Ur1v9RljE/edit#slide=id.g76adfa6c9_0_55)
* Pad empty digits w/ dots → dots $$\prec$$ any other character

### [LSD Runtime Analysis](https://docs.google.com/presentation/d/1pPdoaB7E9v_K5YyD1-fCOypxNFh2gKNGJ_Ur1v9RljE/edit#slide=id.g76adfa6c9_0_139)
* Need to do counting sort on each digit

## LSD Radix Sort vs. Comparison Sorting

### [Long Dissimilar Strings](https://docs.google.com/presentation/d/1pPdoaB7E9v_K5YyD1-fCOypxNFh2gKNGJ_Ur1v9RljE/edit#slide=id.g76adfa6c9_0_164)
* When comparing for merge sort, only need to look at most significant few characters to determine ordering → most characters never even looked at
* Essentially comparing $$W$$ w/ $$\log{N}$$ → in general expect $$W > \log{N}$$ for this case

### [Long Similar Strings](https://docs.google.com/presentation/d/1pPdoaB7E9v_K5YyD1-fCOypxNFh2gKNGJ_Ur1v9RljE/edit#slide=id.g76adfa6c9_0_152)
* Each compare for merge sort takes some amount of time
    * Comparison for highly similar strings (particularly in top characters) or all the same takes time proportional to length of strings
    * Comparisons not constant time if taking width of strings into consideration
* Usually ignore cost of each compare
    * In this case, relevant because LSD sort takes width into consideration → need to also include $$W$$ in merge sort time
* Comparing `long` = constant time on modern computer → compares 2 64-bit numbers in one clock cycle
* ML inference can be done w/ 8-bit arithmetic
* ML training takes 64-bit arithmetic

### [Overall](https://docs.google.com/presentation/d/1pPdoaB7E9v_K5YyD1-fCOypxNFh2gKNGJ_Ur1v9RljE/edit#slide=id.g76adfa6c9_0_176)
* Can only tell for sure in boundary/extreme cases

## [MSD (Most Significant Digit) Radix Sort](https://docs.google.com/presentation/d/1pPdoaB7E9v_K5YyD1-fCOypxNFh2gKNGJ_Ur1v9RljE/edit#slide=id.g465fbc6ea_1144)
* $$R$$ subproblems → sort each separately
* Typically implemented recursively

### [Runtime of MSD](https://docs.google.com/presentation/d/1pPdoaB7E9v_K5YyD1-fCOypxNFh2gKNGJ_Ur1v9RljE/edit#slide=id.g76adfa6c9_0_182)
* **Best Case:** All top characters unique → only need to go through top character of each to sort (instead of all characters) → $$\Theta(N + R)$$
    * $$N \leq R$$
* **Worst Case:** Have to go through every character (every string/sequence equal) → degenerates to LSD sort → $$\Theta(WN + WR)$$
    * Exactly like LSD sort, except w/ recursion

### [Sorting Runtime Analysis](https://docs.google.com/presentation/d/1pPdoaB7E9v_K5YyD1-fCOypxNFh2gKNGJ_Ur1v9RljE/edit#slide=id.g76adfa6c9_0_194)
### [Overall](https://docs.google.com/presentation/d/1pPdoaB7E9v_K5YyD1-fCOypxNFh2gKNGJ_Ur1v9RljE/edit#slide=id.g76adfa6c9_0_201)
