# Object-Oriented Programming in Java

A complete reference for everything covered in **Lesson 10 — OOP**, going from Classes & Objects through Exception Handling. Each section has the core concept, working code, common mistakes made while learning it, real-world use cases, and interview questions.

## Table of Contents

1. [Classes & Objects](#1-classes--objects)
2. [Constructors & Constructor Overloading](#2-constructors--constructor-overloading)
3. [Encapsulation](#3-encapsulation)
4. [Inheritance](#4-inheritance)
5. [Polymorphism](#5-polymorphism)
6. [Abstraction](#6-abstraction)
7. [Interfaces](#7-interfaces)
8. [Exception Handling](#8-exception-handling)
9. [The Four Pillars — Quick Comparison](#9-the-four-pillars--quick-comparison)
10. [Common Mistakes Log](#10-common-mistakes-log-from-this-lesson)
11. [Interview Question Bank](#11-interview-question-bank)

---

## 1. Classes & Objects

### Concept

A **class** is a blueprint — it defines what data (fields) and behavior (methods) something will have, but it isn't a real thing by itself. An **object** is an actual instance created from that blueprint, with its own real values in memory.

One class can produce many objects, and each object holds its **own independent copy** of the instance data.

### Code

```java
class Car {
    String color;
    int speed;

    void honk() {
        System.out.println("Beep beep!");
    }
}

public class Main {
    public static void main(String[] args) {
        Car myCar = new Car();
        Car yourCar = new Car();

        myCar.color = "Red";
        yourCar.color = "Blue";

        System.out.println(myCar.color);   // Red
        System.out.println(yourCar.color); // Blue
        myCar.honk();                      // Beep beep!
    }
}
```

### Default Values (when a field is never assigned)

| Type | Default Value |
|---|---|
| `int`, `long`, `short`, `byte` | `0` |
| `double`, `float` | `0.0` |
| `boolean` | `false` |
| `char` | `'\u0000'` |
| Any object type (`String`, custom classes) | `null` |

### Why it matters

- Primitives always have a "zero-like" default — they can never be `null`.
- Objects/references default to `null` because they don't point to anything in memory yet.

### Use Cases

- Modeling real-world entities: `User`, `Order`, `BankAccount`, `Employee`.
- Every framework you'll use later (Spring, Android, etc.) is built entirely on this pattern — data + behavior bundled together.

---

## 2. Constructors & Constructor Overloading

### Concept

A **constructor** is a special method that runs automatically when an object is created with `new`. It lets you set up an object's initial state in one step instead of assigning fields one by one afterward.

- Constructor name **must match the class name exactly**.
- No return type — not even `void`.
- **Constructor overloading**: multiple constructors in the same class with different parameter lists. Java picks the correct one based on the number/type of arguments passed at the call site.

### The `this` keyword

`this` refers to the current object. It's required whenever a parameter name shadows a field name, to distinguish "the field" from "the parameter":

```java
class Car {
    String color;
    int speed;

    // Constructor 1 — full details
    Car(String color, int speed) {
        this.color = color;   // this.color = field, color = parameter
        this.speed = speed;
    }

    // Constructor 2 — overloaded, partial details
    Car(String color) {
        this.color = color;
        this.speed = 0;
    }

    // Constructor 3 — overloaded, no-arg
    Car() {
        this.color = "not assigned";
    }
}
```

```java
Car car1 = new Car("Red", 100);   // Constructor 1 runs
Car car2 = new Car("Blue");        // Constructor 2 runs, speed = 0
Car car3 = new Car();               // Constructor 3 runs, color = "not assigned", speed = 0 (default)
```

### Common Pitfall

If `this` is omitted when a parameter shares a field's name, `color = color` just reassigns the parameter to itself — the field is **never actually set**, and silently stays at its default (`null`/`0`). No compile error, no runtime error — just a wrong result. This is a classic silent bug.

### Use Cases

- Forcing mandatory data at creation time (e.g., a `BankAccount` that can't exist without an `accountNumber`).
- Providing sensible defaults when the caller has partial information.

---

## 3. Encapsulation

### Concept

Encapsulation means **hiding internal data** (`private` fields) and only exposing controlled access through **public methods** (getters and setters). It is *not* just "making fields private" — a class with only private fields and no accessors is useless. The full pattern is:

```
private fields + public getters/setters (with validation) = encapsulation
```

### Code

```java
class Car {
    private String color;
    private int speed;

    void setSpeed(int speed) {
        if (speed < 0) {
            System.out.println("Speed can't be negative!");
        } else {
            this.speed = speed;
        }
    }

    int getSpeed() {
        return speed;
    }

    void setColor(String color) {
        this.color = color;
    }

    String getColor() {
        return color;
    }
}
```

```java
Car myCar = new Car();
myCar.setSpeed(-500);   // rejected: "Speed can't be negative!"
myCar.setSpeed(100);    // accepted
System.out.println(myCar.getSpeed()); // 100

// myCar.speed = 100;   // ❌ compile error — private, no direct access
```

### Why it matters (not just "security")

The real value isn't secrecy — it's **data integrity and control**:

- You can validate every write (reject negative speed, empty names, etc.).
- You can change the internal representation later (e.g., store speed in a different unit) without breaking code outside the class, since outside code only ever talks to `getSpeed()`/`setSpeed()`.

### Use Cases

- Validating input before it's stored (age can't be negative, email must contain `@`, balance can't go below zero without an overdraft rule).
- Read-only fields — expose a getter but no setter (e.g., `accountNumber` shouldn't change after creation).

---

## 4. Inheritance

### Concept

Inheritance lets one class (**child/subclass**) automatically acquire the fields and methods of another (**parent/superclass**) using the `extends` keyword, while also being able to add its own new fields/methods.

```java
class Vehicle {
    int speed;

    Vehicle(int speed) {
        this.speed = speed;
        System.out.println("Vehicle constructor called");
    }

    void move() {
        System.out.println("Vehicle is moving");
    }
}

class Bike extends Vehicle {
    boolean hasGear;

    Bike(int speed, boolean hasGear) {
        super(speed);          // must be the FIRST line
        this.hasGear = hasGear;
    }
}
```

### The `super` keyword

- `super(args)` calls the parent's constructor. It **must be the first statement** in the child constructor.
- If the child class doesn't define a constructor, Java implicitly tries to call the parent's no-arg constructor. If the parent has no no-arg constructor (only a parameterized one), this fails to compile — the child **must** define a constructor that calls `super(...)` explicitly.

### Terminology

| Term | Also called |
|---|---|
| `Vehicle` | Parent / Superclass / Base class |
| `Bike` | Child / Subclass / Derived class |

### Use Cases

- Sharing common behavior across related types: `Employee → Manager, Developer, Intern`.
- Avoiding duplicated code: shared logic lives once in the parent.

---

## 5. Polymorphism

### Concept

"Many forms" — the same method call behaves differently depending on which object is actually involved.

**Two kinds:**

| Type | Also called | How Java decides |
|---|---|---|
| Method/Constructor Overloading | Compile-time Polymorphism | By argument count/types, decided at compile time |
| Method Overriding | Runtime Polymorphism | By the actual object type, decided at runtime |

### Method Overriding

```java
class Animal {
    void makeSound() {
        System.out.println("Animal makes a sound");
    }
}

class Dog extends Animal {
    @Override
    void makeSound() {
        System.out.println("Woof Woof!");
    }
}

class Cat extends Animal {
    @Override
    void makeSound() {
        System.out.println("Meow Meow!");
    }
}
```

`@Override` isn't mandatory, but it's a strong safety net — if the method signature doesn't actually match a parent method (e.g., a typo), the compiler flags it immediately instead of silently creating an unrelated new method.

### Upcasting — where the "runtime" part actually shows

```java
Animal myAnimal = new Dog();
myAnimal.makeSound();   // "Woof Woof!" — NOT "Animal makes a sound"
```

The **reference type** (`Animal`) only controls which methods you're *allowed* to call (checked at compile time). The **actual object** (`Dog`) decides which *version* of an overridden method runs (resolved at runtime).

### Critical exception: fields do NOT follow this rule

```java
class Circle extends Shape {
    double radius = 5;
}

Shape s = new Circle();
s.calculateArea();  // ✅ runs Circle's version (runtime resolution — methods)
s.radius;            // ❌ compile error — Shape has no `radius` field (compile-time resolution — fields)
```

Fields are resolved purely by the **reference type** at compile time. Only method calls get runtime polymorphic behavior. This is a very common interview trap.

### Use Cases

- Writing code against a general type (`Animal`, `Shape`, `PaymentMethod`) that works correctly no matter which specific subtype is actually passed in — the foundation of writing extensible, "closed for modification, open for extension" code.

---

## 6. Abstraction

### Concept

Abstraction means exposing *what* something does while hiding *how* it does it. In Java this is done with `abstract` classes and `abstract` methods.

```java
abstract class Shape {
    abstract double calculateArea();   // no body — just a contract
}

class Circle extends Shape {
    double radius;

    Circle(double radius) { this.radius = radius; }

    @Override
    double calculateArea() {
        return 3.14159 * radius * radius;
    }
}

class Rectangle extends Shape {
    double length, width;

    Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    @Override
    double calculateArea() {
        return length * width;
    }
}
```

### Rules

- `abstract class` **cannot be instantiated** — `new Shape()` is a compile error, no matter how "harmless" it seems, because an abstract method has no body to run.
- Any concrete (non-abstract) subclass **must implement every abstract method**, or it must also be declared `abstract` itself (deferring the obligation further down the hierarchy).
- An abstract class *can* also contain regular, fully-implemented methods — it's not required to be 100% abstract.

### Use Cases

- Defining a common contract for a family of related types where each one genuinely needs its own implementation: `Shape → Circle/Rectangle/Triangle`, `PaymentProcessor → CreditCardProcessor/UpiProcessor`.
- Forcing every subclass to think about a required behavior instead of silently inheriting a meaningless default.

---

## 7. Interfaces

### Concept

An interface is a **pure contract** — method signatures only, no implementation (by default). Unlike a class, which can only `extends` one parent, a class can `implements` **multiple** interfaces — this is how Java works around not having multiple class inheritance.

```java
interface Swimmer {
    void swim();
}

interface Flyer {
    void fly();
}

class Duck implements Swimmer, Flyer {
    @Override
    public void swim() {
        System.out.println("Duck is swimming");
    }

    @Override
    public void fly() {
        System.out.println("Duck is flying");
    }
}
```

### Key rules

- Use `implements`, not `extends`.
- Methods declared in an interface are `public` and abstract by default — the implementing class **must** mark its overriding methods `public` explicitly.
- A class can implement any number of interfaces (comma-separated), unlike single class inheritance.
- Just like with abstract classes, a non-abstract implementing class must provide bodies for **all** interface methods.

### Abstract Class vs Interface

| | Abstract Class | Interface |
|---|---|---|
| Keyword | `extends` | `implements` |
| Multiple inheritance | ❌ only one parent | ✅ multiple interfaces |
| Can have fully-implemented methods | ✅ yes | Traditionally no (Java 8+ allows `default` methods, but that's beyond this lesson) |
| Can have constructors | ✅ yes | ❌ no |
| Use when | Related classes share common state/code | Unrelated classes share only a capability/behavior |

### Use Cases

- Modeling "capabilities" that cut across unrelated class hierarchies: `Comparable`, `Runnable`, `Serializable` in the Java standard library.
- Designing pluggable systems: any class that `implements PaymentGateway` can be swapped in without the rest of the code changing.

---

## 8. Exception Handling

### Concept

An **exception** is an abnormal event during program execution (divide by zero, invalid array index, null access) that interrupts the normal flow. Without handling, it crashes the program. `try-catch-finally` lets the program recover gracefully instead.

```java
try {
    int result = 10 / 0;
    System.out.println(result);          // never reached
} catch (ArithmeticException e) {
    System.out.println("Error: Cannot divide by zero!");
} finally {
    System.out.println("This always runs!");
}

System.out.println("Program continues...");
```

**Output:**
```
Error: Cannot divide by zero!
This always runs!
Program continues...
```

### The three blocks

| Block | Runs when |
|---|---|
| `try` | Contains the risky code. Runs until an exception is thrown or it completes normally. |
| `catch` | Runs **only if** a matching exception type was thrown in `try`. Skipped entirely if nothing went wrong. |
| `finally` | Runs **always** — whether an exception occurred or not, whether it was caught or not. Used for cleanup (closing files, releasing connections). |

### Multiple catch blocks

```java
try {
    int[] arr = {1, 2, 3};
    System.out.println(arr[5]);
} catch (ArithmeticException e) {
    System.out.println("Math error!");
} catch (ArrayIndexOutOfBoundsException e) {
    System.out.println("Array index is invalid!");
}
```

Java checks catch blocks **top to bottom** and runs the **first one that matches** the thrown exception's type.

### Ordering rule — specific before general

All exceptions inherit from the class `Exception`. Because of that inheritance relationship, a broad `catch (Exception e)` will catch *anything* — `ArithmeticException`, `ArrayIndexOutOfBoundsException`, everything — since every specific exception "IS-A" `Exception` (the same upcasting idea from Polymorphism).

```java
// ❌ Compile error — the general catch makes the specific one unreachable
catch (Exception e) { ... }
catch (ArithmeticException e) { ... }

// ✅ Correct order — specific first, general last as a safety net
catch (ArithmeticException e) { ... }
catch (Exception e) { ... }
```

### Why bother with specific catches at all?

A single `catch (Exception e)` technically handles everything, but it can only give a generic message. Specific catch blocks let you:

- Give a precise, useful message for each failure type.
- Take different recovery actions per error type (retry, use a default value, ask for new input).
- Debug faster by knowing exactly what went wrong.

### Use Cases

- Reading user input that might be malformed.
- File/network operations that can fail (file not found, connection timeout).
- Any operation where failure is expected occasionally and the program should recover instead of crashing (e.g., a calculator app, a form validator, an API client).

---

## 9. The Four Pillars — Quick Comparison

| Pillar | One-line definition | Java keyword(s) |
|---|---|---|
| **Encapsulation** | Hide data, expose controlled access | `private`, getters/setters |
| **Inheritance** | Reuse and extend behavior from a parent | `extends`, `super` |
| **Polymorphism** | Same call, different behavior based on actual object | `@Override`, upcasting |
| **Abstraction** | Expose *what*, hide *how* | `abstract`, `interface` |

---

## 10. Common Mistakes Log (from this lesson)

A record of real mistakes made while learning these topics, kept because re-reading your own bugs sticks better than reading a generic list.

1. **`this` omitted when parameter shadows field** — `color = color` silently does nothing to the field; no error, just a wrong/default value.
2. **`super()` not on the first line** of a subclass constructor — compile error, since the parent must finish constructing before the child adds anything.
3. **A subclass with no constructor when the parent has no no-arg constructor** — Java's implicit `super()` call fails because there's nothing for it to call.
4. **Confusing "method call priority" with "field access rules"** — methods resolve by actual object (runtime), but fields resolve by reference type (compile-time). These are not the same mechanism.
5. **Two unrelated classes with the same name in the same package** (`Car` defined in two different files) — `duplicate class` compile error; the whole file fails to compile, producing a cascade of unrelated-looking errors.
6. **Stale `.class` files** — running against an old compiled class after editing the source, producing confusing errors like `NoSuchMethodError` that have nothing to do with the current code. Fix: clean the `bin` folder and recompile fresh, and stick to one consistent way of compiling/running (don't mix an IDE's internal build with manual `javac`/`java` commands).
7. **`catch (Exception e)` placed before a more specific catch** — compile error, because the general catch makes the specific one unreachable.
8. **Class named the same as a built-in Java class** (e.g., naming a demo class `StringBuilder`) — causes ambiguous references; always suffix custom classes (`...Demo`) to avoid shadowing standard library names.

---

## 11. Interview Question Bank

**Q1. What's the difference between a class and an object?**
A class is a blueprint/template that defines structure and behavior; an object is a concrete instance of that blueprint with real values in memory. One class can produce many independent objects.

**Q2. Why is `this` needed in a constructor?**
Only needed when a parameter name shadows a field name — it disambiguates "the field on this object" from "the local parameter," since Java would otherwise resolve the bare name to the closer (parameter) scope.

**Q3. What's the real definition of encapsulation — is it just making fields private?**
No. Encapsulation is `private` fields *combined with* `public` getters/setters that can validate input. Private fields with no accessors make the object impossible to use.

**Q4. Can a Java class extend more than one class?**
No — Java doesn't support multiple class inheritance, precisely to avoid ambiguity when two parents define the same method (the "diamond problem"). This is exactly why interfaces exist — a class can implement multiple interfaces instead.

**Q5. What's the difference between method overloading and method overriding?**
Overloading: same method name, different parameter list, resolved at **compile time** (compile-time polymorphism). Overriding: subclass redefines a parent's method with the same signature, resolved at **runtime** based on the actual object (runtime polymorphism).

**Q6. If `Animal a = new Dog();`, and `Dog` overrides `makeSound()`, which version runs?**
`Dog`'s version. The reference type (`Animal`) only determines which methods are *callable* at compile time; the actual object type determines *which implementation* runs at runtime.

**Q7. Do fields show the same polymorphic behavior as overridden methods?**
No. Fields are resolved by the **reference type** at compile time and do not participate in runtime polymorphism — accessing a field the parent type doesn't declare is a compile error even if the actual object has it.

**Q8. Can you instantiate an abstract class?**
No — `new` on an abstract class is a compile error, because its abstract methods have no implementation to execute.

**Q9. What happens if a concrete subclass doesn't implement all abstract methods (from a class or interface)?**
Compile error: `X is not abstract and does not override abstract method ...`. The subclass must either implement every abstract method, or be declared abstract itself.

**Q10. Abstract class vs interface — when do you choose which?**
Abstract class: related classes that share common state and some common implemented behavior, and only need single inheritance. Interface: unrelated classes that just need to share a capability/contract, especially when a class needs to satisfy multiple such contracts at once.

**Q11. Why must `super()` be the first line of a subclass constructor?**
Because the parent portion of the object must be fully constructed before the subclass can safely add or reference its own fields — enforcing that a "complete" parent exists before the child builds on top of it.

**Q12. What is the purpose of the `finally` block?**
It runs unconditionally — whether an exception was thrown or not, whether it was caught or not — making it the correct place for cleanup code like closing files or releasing resources, since it's guaranteed to execute.

**Q13. Why does catch-block order matter?**
Java checks blocks top-to-bottom and executes the first matching one. Because all exceptions inherit from `Exception`, placing a general `catch (Exception e)` before a specific one makes the specific block unreachable — the compiler rejects this outright.

**Q14. If you only write `catch (Exception e)`, does it catch everything?**
Yes — since every specific exception type is-a `Exception` through inheritance, a single general catch will match all of them. The tradeoff is losing the ability to give type-specific messages or recovery logic.

**Q15. What are Java's default values for fields, and why do primitives and objects differ?**
Primitives get a type-appropriate "zero" value (`0`, `0.0`, `false`, `'\u0000'`) because they store the value directly. Object references default to `null` because they store an address to an object, and no object has been assigned yet.

---

## Notes on this project

- Each concept above was built incrementally with dry runs before writing final code — that habit is worth continuing into Phase 3 (Advanced Java) and Phase 4 (DSA).
- The recurring bug pattern worth watching for going forward: **assuming Java resolves something the way "it felt like it should"** (e.g., assuming fields behave like methods under polymorphism, or assuming `this` is optional whenever a name matches) — always verify against the actual rule, not intuition.