# Packages, Access Control, Objects

## Packages in IntelliJ
* Package = Java syntax idea, addresses fact that multiple classes might share names
    * Package = ***namespace*** that organizes classes & interfaces
    * If using class from outside, use entire ***canonical name***, `ug.joshh.animal.Dog`
        * Can use ***simple name*** if imported
    * If used from another class in same package, can use just ***simple name***, `Dog`
* Any Java class w/out package name at top = part of "default" package
* Cannot import/use/access code from default package from within different package

## JAR Files
* `.jar` file contains all `.class` files
    * JAR files really just zip files, but w/ extra info added

## Access Control
### Access Control w/ Inheritance & Packages
* ***`protected`*** modifier allows package members & subclasses to use class member
* Package private: no modifier → allows classes from same package, _but not subclasses_ to access member

#### Access Levels
| Modifier      | Class | Package | Subclass | World |
|:-------------:|:-----:|:-------:|:--------:|:-----:|
| `public`      | Y     | Y       | Y        | Y     |
| `protected`   | Y     | Y       | Y        | N     |
| _no modifier_ | Y     | Y       | N        | N     |
| `private`     | Y     | N       | N        | N     |


## Access Control Subtleties
* Access based **only** on static types

### Access Control at the Top Level
* Two levels: `public`, no modifier (package-private)
    * Can't declare top level class as `private`/`protected`
* No such thing as a sub-package, `ug.joshh.Animal` & `ug.joshh.Plant` = 2 completely different packages


## Object Methods
* Test equality of arrays → `Arrays.equal`, `Arrays.deepEquals`

### `.equals()`
* Default implementation of `.equals()` uses `==`
* JUnit `assertEquals` uses `.equals()`
* `.equals()` parameter must take `Object`, cast to actual type w/in `.equals()` method
* Generally will need:
    * Reference check
    * `null` check
    * Class check w/ `.getClass()`
    * Cast to same type
    * Check fields
