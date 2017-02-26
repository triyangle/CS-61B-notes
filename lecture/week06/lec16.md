# Encapsulation, Lists, Delegation vs. Extension

## Delegation vs. Extension
* Safe to use inheritance w/in package, where subclass & superclass under control of the same programmers
* Safe to extend classes specifically designed & documented for extension
* Inheriting from ordinary concrete classes across package boundaries = dangerous
* When in doubt: use delegation & write trivial forwarding methods for each method
