# Project 0: NBody

```java
public Dog(String name, String breed1, String breed2, int age) {
    this(name, breed1 + breed2, age);
}
```

is equivalent to

```java
public Dog(String name, String breed1, String breed2, int age) {
    _name = name;
    _breed = breed1 + breed2;
    _age = age;
}
```

where `Dog` is

```java
public class Dog {

    String _name;
    String _breed;
    int _age;

    public Dog(String name, String breed, int age) {
        _name = name;
        _breed = breed;
        _age = age;
    }
}
```
