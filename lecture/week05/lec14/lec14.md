# Exceptions, Iterators, Iterables

## Uncaught Exceptions
* When exception thrown, descends call stack (stack of methods that gets called) if not caught
    * If exceptions reach bottom of stack, program crashes & Java provides message for user

## Checked vs Unchecked Exceptions
* Checked exceptions **must** be handled
    * Compiler requires these to be "**caught**"/"**specified**"
        * Goal = prevent avoidable program crashes that could have been handled
* Any subclass of **`RuntimeException`** or **`Error`** is _unchecked_
* All other `Throwable`s are _checked_
* Checked exceptions = part of **specification** of class

<p align="center">
    <img src="exceptions.png">
</p>

### Checking Exceptions
* **Specify** method as dangerous w/ ***`throws`*** keyword
    * Defers to someone else to handle exception
* If method uses a dangerous method (i.e. might throw checked exception), it becomes dangerous itself


## Iteration Intro
* Enhanced for loop/foreach loop = equivalent to iterating through `Iterator`

## Implementing Iterators
* `List` interface `extends` `Collection` `extends` `Iterable` interface → inherits abstract `iterator()` method
* Instantiate non-static nested class (inner class) → use `instance.new`

### Iteration Summary
* Implement `Iterable` interface to support enhanced for loop
    * `iterator()` method must return object that implements `Iterator` interface
