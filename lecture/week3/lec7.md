# Testing
* `org.junit.Assert.assertEquals(expected, input)`, deprecated
* `org.junit.Assert.assertArrayEquals(expected, input)`

## Unit Testing
* Idea = write tests for every "unit"

## Test-Driven Development (TDD)
* Test-Driven Development = write unit tests before code
* Identify new feature
* Write test for feature → run test → should fail
* Write code that passes test
* Refactor code to make it faster/cleaner/etc.

## Complementary Approach to Unit Testing: Integration Testing
* Idea = tests cover many units at once (entire program)
* Not JUnit's focus, but can be used
* Unit testing not enough to ensure modules interact properly or that system works as expected
