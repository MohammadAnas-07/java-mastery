# Java Learning

Going through Java fundamentals one lesson at a time. Each lesson has its own package under [`src/fundamentals`](src/fundamentals), [`src/oop`](src/oop), or [`src/advanced`](src/advanced), with demo programs, a couple of mini-projects, and notes as I go.

## Project structure

```
JavaLearning/
├── src/
│   ├── fundamentals/
│   │   ├── lesson01/   → Environment Setup
│   │   ├── lesson02/   → Variables & Data Types
│   │   ├── lesson03/   → Operators
│   │   ├── lesson04/   → Decision Making (if-else)
│   │   ├── lesson05/   → Switch Statements
│   │   ├── lesson06/   → Loops & Pattern Printing
│   │   ├── lesson07/   → Methods & Mini Project
│   │   ├── lesson08/   → Arrays, Searching & Sorting
│   │   └── lesson09/   → Strings
│   ├── oop/
│   │   └── lesson10/   → Classes, Objects & full OOP (see its own README)
│   └── advanced/
│       └── lesson11/   → Collections, Generics, File Handling, Multithreading, Lambdas, Streams (see its own README)
└── bin/                → Compiled .class output (ignored by git)
```

## Progress

| # | Lesson | Topics | Status |
|---|--------|--------|--------|
| 01 | [Environment Setup](src/fundamentals/lesson01) | Hello World, project setup | Done |
| 02 | [Variables & Data Types](src/fundamentals/lesson02) | Primitive types, literals, naming conventions, type casting | Done |
| 03 | [Operators](src/fundamentals/lesson03) | Arithmetic, assignment, relational, logical, increment/decrement, short-circuit evaluation | Done |
| 04 | [Decision Making](src/fundamentals/lesson04) | if, if-else, else-if, nested if, ternary operator | Done |
| 05 | [Switch Statements](src/fundamentals/lesson05) | switch-case, fall-through, multiple cases, enhanced switch, switch vs if-else | Done |
| 06 | [Loops](src/fundamentals/lesson06) | while, do-while, for, break, continue, nested loops, pattern printing | Done |
| 07 | [Methods](src/fundamentals/lesson07) | Method declaration, parameters, return types, overloading, Student Result Management System (mini project) | Done |
| 08 | [Arrays](src/fundamentals/lesson08) | Declaration, traversal, searching, sorting, rotation & array utilities | Done |
| 09 | [Strings](src/fundamentals/lesson09) | Traversal, immutability, substring, concatenation, vowel/consonant count, reverse, palindrome, character frequency, duplicate removal, anagram, StringBuilder, StringBuffer | Done |
| 10 | [OOP](src/oop/lesson10) | Classes & Objects, Constructors & Overloading, Encapsulation, Inheritance, Polymorphism, Abstraction, Interfaces, Exception Handling | Done |
| 11 | [Advanced Java](src/advanced/lesson11) | ArrayList, HashMap, HashSet, LinkedList, Generics, File Handling, Multithreading, Lambda Expressions, Streams API | Done |

More lessons get added as I go.

## Lesson notes

A few things worth calling out from each lesson:

- **Lesson 02, Variables & Data Types**: the 8 primitive types, literals (integer, floating, char, string, boolean, null), naming conventions, and the difference between implicit and explicit casting.
- **Lesson 05, Switch**: fall-through behavior, `break`, `default`, the newer arrow-style switch (`->`), and when switch actually makes more sense than if-else.
- **Lesson 06, Loops**: `while` vs `do-while` vs `for`, nested loops, and nine pattern-printing programs (stars, numbers, characters).
- **Lesson 07, Methods**: overloading, plus a small Student Result Management System that calculates percentage, grade, and pass/fail, and prints a formatted marksheet.
- **Lesson 08, Arrays**: declaration and traversal, linear and binary search, bubble and selection sort, array reversal (including the actual reversal algorithm, not just `Arrays.sort` tricks), left/right rotation, duplicate detection, frequency counting, and finding the second-largest element.
- **Lesson 09, Strings**: `charAt` vs `toCharArray`, `==` vs `equals()` and why string pooling matters, why `String` is immutable and what that means for methods like `concat`/`toUpperCase`, `substring`'s `[start, end)` rule, vowel/consonant counting, string reversal and palindrome checks with two pointers, character frequency counting, duplicate detection/removal, anagram checking, and `StringBuilder`/`StringBuffer` for mutable strings.
- **Lesson 10, OOP**: the full set of core OOP concepts — classes/objects, constructor overloading with `this`, encapsulation (private fields + validated getters/setters), inheritance with `extends`/`super`, polymorphism (overriding + upcasting, and why fields don't behave polymorphically like methods do), abstraction with abstract classes, interfaces (including implementing multiple interfaces), and exception handling with `try`/`catch`/`finally` and multi-catch ordering rules. Full write-up with code, use cases, and an interview question bank lives in [`src/oop/lesson10/README.md`](src/oop/lesson10/README.md).
- **Lesson 11, Advanced Java**: the Collections Framework (`ArrayList`, `HashMap`, `HashSet`, `LinkedList`) and the tradeoffs between them, Generics and why they move type errors from runtime to compile time, file handling with checked exceptions and `try-with-resources`, multithreading (`start()` vs `run()`, why a thread can only be started once), lambda expressions and functional interfaces, and the Streams API (`filter`/`map`/`forEach` pipelines). Full write-up with code, use cases, and an interview question bank lives in [`src/advanced/lesson11/README.md`](src/advanced/lesson11/README.md).

## Running a file

Each file is a standalone, runnable class. From the project root:

```bash
javac -d bin src/fundamentals/lesson08/BinarySearchDemo.java
java -cp bin fundamentals.lesson08.BinarySearchDemo
```

Swap in the path and class name for whatever you want to run.

## Tech

- Java
- Compiled output goes to `bin/`, excluded from git via `.gitignore`