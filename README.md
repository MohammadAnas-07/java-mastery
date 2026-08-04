# Java Learning

Going through Java fundamentals one lesson at a time. Each lesson has its own package under [`src/fundamentals`](src/fundamentals), with demo programs, a couple of mini-projects, and notes as I go.

## Project structure

```
JavaLearning/
├── src/fundamentals/
│   ├── lesson01/   → Environment Setup
│   ├── lesson02/   → Variables & Data Types
│   ├── lesson03/   → Operators
│   ├── lesson04/   → Decision Making (if-else)
│   ├── lesson05/   → Switch Statements
│   ├── lesson06/   → Loops & Pattern Printing
│   ├── lesson07/   → Methods & Mini Project
│   └── lesson08/   → Arrays, Searching & Sorting
└── bin/            → Compiled .class output (ignored by git)
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

More lessons get added as I go.

## Lesson notes

A few things worth calling out from each lesson:

- **Lesson 02, Variables & Data Types**: the 8 primitive types, literals (integer, floating, char, string, boolean, null), naming conventions, and the difference between implicit and explicit casting.
- **Lesson 05, Switch**: fall-through behavior, `break`, `default`, the newer arrow-style switch (`->`), and when switch actually makes more sense than if-else.
- **Lesson 06, Loops**: `while` vs `do-while` vs `for`, nested loops, and nine pattern-printing programs (stars, numbers, characters).
- **Lesson 07, Methods**: overloading, plus a small Student Result Management System that calculates percentage, grade, and pass/fail, and prints a formatted marksheet.
- **Lesson 08, Arrays**: declaration and traversal, linear and binary search, bubble and selection sort, array reversal (including the actual reversal algorithm, not just `Arrays.sort` tricks), left/right rotation, duplicate detection, frequency counting, and finding the second-largest element.

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