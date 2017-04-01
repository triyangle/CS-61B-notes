# Encapsulation
* **Module:** Set of methods that work together as whole to perform task (or set of related tasks)
    * Module is ***encapsulated*** if implementation completely hidden → can only be accessed through documented interface
* Abstract data type (ADT) = encapsulated data structure
    * Not all encapsulated modules are ADTs
    * Algorithms (e.g. list sorters) & applications (e.g. network routing software) can also be encapsulated, even if distinct from data structures they use
* "Encapsulate" module by defining interface through which outside world can use, inspect, or manipulate it
    * Interface = set of prototypes & behaviors of methods (& fields) that access module or data structure
* Encapsulation benefits:
    * Implementation independent of functionality → new, better implementation can replace old one
    * ADTs can guarantee their invariants are preserved
    * Documentation & maintainability
* Interface = contract between module writers, specifying exactly how they will communicate
* Module = collection of methods that provide some functionality through single interface
    * ***Module*** = organized around *functionality* it provides
* ***Class*** = organized around *data storage unit* (object = repository of data)
* Module can be made up of several classes, or class could be made up of several modules
    * Module boundaries & class boundaries can be independent of each other
