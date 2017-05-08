# Compression

## [Compression Model #1: Algorithms Operating on Bits](https://docs.google.com/presentation/d/1IMXPc6fXVomjlTRqkFDYKygFlMjtQGMELkhybXcqaWE/edit#slide=id.g536bf0065_038)
* ***Lossless*** algorithm → original bitstream recoverable perfectly from compressed bitstream

## [Increasing Optimality of Coding](https://docs.google.com/presentation/d/1IMXPc6fXVomjlTRqkFDYKygFlMjtQGMELkhybXcqaWE/edit#slide=id.g536bf0065_074)
* Alternate strategy instead of having pauses → ***prefix free code***

### [Morse Code (as a Tree)](https://docs.google.com/presentation/d/1IMXPc6fXVomjlTRqkFDYKygFlMjtQGMELkhybXcqaWE/edit#slide=id.g12cd24d732_0_0)
* M (--) = prefix of G (--•) → issue b/c need to differentiate between ends of characters to be unambiguous (pause used in practice)
* Alternate strategy = allow no character to be prefix of any other

### [Prefix-Free Codes](https://docs.google.com/presentation/d/1IMXPc6fXVomjlTRqkFDYKygFlMjtQGMELkhybXcqaWE/edit#slide=id.g536bf0065_0121)

## [Code Calculation Approach #1 (Shannon-Fano Coding)](https://docs.google.com/presentation/d/1IMXPc6fXVomjlTRqkFDYKygFlMjtQGMELkhybXcqaWE/edit#slide=id.g536bf0065_0150)
* Approach for taking set of characters & finding ideal prefix-free code
* Given set of text → generate prefix-free code
* Recursive procedure

### [Efficiency Assessment of Shannon-Fano Coding](https://docs.google.com/presentation/d/1IMXPc6fXVomjlTRqkFDYKygFlMjtQGMELkhybXcqaWE/edit#slide=id.g396aa99777b164d5_121)

## [Code Calculation Approach #2: Huffman Coding](https://docs.google.com/presentation/d/1IMXPc6fXVomjlTRqkFDYKygFlMjtQGMELkhybXcqaWE/edit#slide=id.g536bf0065_084)
* Bottom-up vs top-down (Shannon-Fano)
* Instead of splitting most significant bit first → splits by least significant bit first

## [Prefix-Free Codes Data Structures](https://docs.google.com/presentation/d/1IMXPc6fXVomjlTRqkFDYKygFlMjtQGMELkhybXcqaWE/edit#slide=id.g9acb87931_55_0)
* `HashMap` computation of `hashCode()` & bucket # & looking through `LinkedList` bucket requires non-trivial amount of overhead

## [Huffman Decompression Example](https://docs.google.com/presentation/d/1IMXPc6fXVomjlTRqkFDYKygFlMjtQGMELkhybXcqaWE/edit#slide=id.g21593356b7_0_206)
* Data has prefix relationship w/ trie/encoding
* None of characters in trie/encoding are prefixes of each other
* No multiple prefixes b/c code is prefix-free

## [Huffman Coding Summary](https://docs.google.com/presentation/d/1IMXPc6fXVomjlTRqkFDYKygFlMjtQGMELkhybXcqaWE/edit#slide=id.g5379302a5_169)

## [Compression Algorithms (General)](https://docs.google.com/presentation/d/1IMXPc6fXVomjlTRqkFDYKygFlMjtQGMELkhybXcqaWE/edit#slide=id.g7742bd016_1_835)

## [Universal Compression: An Impossible Idea](https://docs.google.com/presentation/d/1IMXPc6fXVomjlTRqkFDYKygFlMjtQGMELkhybXcqaWE/edit#slide=id.g396aa99777b164d5_423)
* Pigeonhole principle

## [The LZW Approach](https://docs.google.com/presentation/d/1IMXPc6fXVomjlTRqkFDYKygFlMjtQGMELkhybXcqaWE/edit#slide=id.g53705ba95_0259)
