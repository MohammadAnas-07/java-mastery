# Advanced Java

A complete reference for everything covered in **Lesson 11 — Advanced Java (Phase 3)**, going from the Collections Framework through Streams API. Each section has the core concept, working code, common mistakes made while learning it, real-world use cases, and interview questions.

## Table of Contents

1. [Collections Framework — Why It Exists](#1-collections-framework--why-it-exists)
2. [ArrayList](#2-arraylist)
3. [HashMap](#3-hashmap)
4. [HashSet](#4-hashset)
5. [LinkedList](#5-linkedlist)
6. [Generics](#6-generics)
7. [File Handling](#7-file-handling)
8. [Multithreading](#8-multithreading)
9. [Lambda Expressions](#9-lambda-expressions)
10. [Streams API](#10-streams-api)
11. [Common Mistakes Log](#11-common-mistakes-log-from-this-lesson)
12. [Interview Question Bank](#12-interview-question-bank)

---

## 1. Collections Framework — Why It Exists

A plain Java array has a fixed size decided at creation time — it can never grow or shrink. Resizing means manually creating a bigger array and copying every element over, which is exactly the same inefficiency `String` immutability caused for concatenation.

The Collections Framework is Java's set of ready-made, dynamically-resizable data structures (`ArrayList`, `HashMap`, `HashSet`, `LinkedList`, and more), each suited to a different kind of problem, all with built-in methods so common operations don't need to be hand-written with loops.

---

## 2. ArrayList

### Concept

A resizable, ordered collection — behaves like a "smart array" that grows automatically as elements are added.

```java
import java.util.ArrayList;

ArrayList<String> fruits = new ArrayList<>();
fruits.add("Apple");
fruits.add("Banana");
fruits.add("Mango");

System.out.println(fruits);          // [Apple, Banana, Mango]
System.out.println(fruits.size());    // 3
System.out.println(fruits.get(1));     // Banana
fruits.remove("Banana");                // remove by value
fruits.remove(0);                        // remove by index
System.out.println(fruits.contains("Mango")); // true
```

### The `remove(int)` vs `remove(Object)` trap

`remove()` is overloaded: `remove(int)` removes by **index**, `remove(Object)` removes by **value**. This becomes dangerous with an `ArrayList<Integer>` — writing `list.remove(1)` **always** resolves to the index version, even if your intent was to remove the value `1`.

```java
ArrayList<Integer> numbers = new ArrayList<>();
numbers.add(10); numbers.add(20); numbers.add(30);

numbers.remove(1);              // removes INDEX 1 → removes 20
numbers.remove(Integer.valueOf(1));  // this removes the VALUE 1 (if present)
```

### Use Cases

- Any ordered, growable list of items: a shopping cart, a to-do list, search results.
- Preferred over arrays whenever the number of elements isn't known upfront.

---

## 3. HashMap

### Concept

Stores **key → value** pairs. Every key is unique — `put()`-ing an existing key **overwrites** its value rather than creating a duplicate entry.

```java
import java.util.HashMap;

HashMap<String, Integer> ages = new HashMap<>();
ages.put("Anas", 22);
ages.put("Rahul", 25);
ages.put("Anas", 30);     // overwrites 22 with 30

System.out.println(ages.get("Anas"));           // 30
System.out.println(ages.containsKey("Anas"));    // true
```

### Practical use case — character frequency in O(n)

```java
String str = "hello";
HashMap<Character, Integer> freq = new HashMap<>();

for (int i = 0; i < str.length(); i++) {
    char ch = str.charAt(i);
    if (freq.containsKey(ch)) {
        freq.put(ch, freq.get(ch) + 1);
    } else {
        freq.put(ch, 1);
    }
}
// freq = {h=1, e=1, l=2, o=1}
```

This replaces the nested-loop character-frequency pattern from the Strings lesson. `containsKey`, `get`, and `put` are each O(1) on average, so the whole loop is **O(n)** instead of the nested loop's **O(n²)** — traded for **O(k) extra space**, where k is the number of unique keys (this is a space–time tradeoff, a recurring theme in DSA).

### Autoboxing

`charAt(i)` returns a primitive `char`, but `HashMap<Character, Integer>` needs the wrapper `Character` object. Java converts automatically — this automatic primitive-to-wrapper conversion is called **autoboxing** (and the reverse, wrapper-to-primitive, is **unboxing**).

### Use Cases

- Fast lookups by a unique identifier: user ID → user object, word → definition, product code → price.
- Counting/frequency problems (character counts, word counts, vote tallies).

---

## 4. HashSet

### Concept

Stores only **unique** elements — no key-value pairing, just a collection where duplicates are silently rejected (not overwritten, since there's no associated value to overwrite).

```java
import java.util.HashSet;

HashSet<String> names = new HashSet<>();
names.add("Anas");
names.add("Rahul");
names.add("Anas");   // silently ignored — no error, no change

System.out.println(names);   // [Anas, Rahul]
```

### Practical use case — extracting unique characters

```java
String str = "hello";
HashSet<Character> uniqueChars = new HashSet<>();

for (int i = 0; i < str.length(); i++) {
    uniqueChars.add(str.charAt(i));
}
// uniqueChars = {h, e, l, o}, size = 4
```

This replaces the manual `alreadyCounted` boolean + inner loop pattern from the Strings lesson — `add()` does the duplicate check internally.

### Collections Quick Comparison

| Collection | Duplicates? | Key-Value? | Order Guaranteed? |
|---|---|---|---|
| `ArrayList` | ✅ Allowed | ❌ No | ✅ Insertion order |
| `HashMap` | Keys: ❌, Values: ✅ | ✅ Yes | ❌ No |
| `HashSet` | ❌ No | ❌ No | ❌ No |

### Use Cases

- De-duplicating a list of items (unique visitor IDs, unique tags).
- Fast membership checks (`contains()`) where order doesn't matter.

---

## 5. LinkedList

### Concept

Unlike `ArrayList` (backed by a contiguous array), `LinkedList` stores elements as separate **nodes** scattered in memory, where each node holds its data plus a link (address) to the next node.

```
ArrayList:  [10][20][30][40][50]        → contiguous memory
LinkedList: (10) → (20) → (30) → (40) → (50)   → each node points to the next
```

### Why this matters — insertion cost

Inserting in the middle of an `ArrayList` requires shifting every subsequent element — O(n). Inserting in the middle of a `LinkedList` (given a reference to the position) only requires re-pointing two links — O(1).

```java
import java.util.LinkedList;

LinkedList<Integer> numbers = new LinkedList<>();
numbers.add(10);
numbers.add(20);
numbers.add(30);
numbers.add(1, 99);   // insert 99 at index 1

System.out.println(numbers);   // [10, 99, 20, 30]
```

### ArrayList vs LinkedList

| Operation | ArrayList | LinkedList |
|---|---|---|
| Insert/delete in the middle | Slow — O(n) (shifting) | Fast — O(1) if position is known |
| Random access (`get(index)`) | Fast — O(1) direct jump | Slow — O(n), must traverse from start |

### Use Cases

- Use `LinkedList` when insertions/deletions (especially at the front/middle) dominate.
- Use `ArrayList` when random access/reads by index dominate — which is most of the time, hence `ArrayList` being the default choice.

---

## 6. Generics

### Concept

Generics enforce **type safety at compile time** instead of letting type errors surface only at runtime. Without them, a collection could silently mix types and only fail later when the wrong type is cast/used.

```java
ArrayList list = new ArrayList();      // raw type — no safety
list.add(10);
list.add("Hello");                      // compiles fine — no warning
int x = (int) list.get(1);               // compiles, but CRASHES at runtime (ClassCastException)

ArrayList<Integer> safeList = new ArrayList<>();
safeList.add(10);
safeList.add("Hello");                   // ❌ compile error — caught immediately
```

**Core principle:** generics move type errors from runtime (discovered only when that code path actually executes, possibly in production) to compile time (caught immediately, before the program ever runs).

### Writing a generic class

```java
class Box<T> {
    T item;

    void setItem(T item) { this.item = item; }
    T getItem() { return item; }
}
```

`T` is a placeholder while the class is being *defined* — flexible at that stage. But once an object is created with a specific type argument, that type is **locked in** for that object:

```java
Box<Integer> intBox = new Box<>();
intBox.setItem(100);        // fine
intBox.setItem("text");      // ❌ compile error — this box is permanently an Integer box
```

The common misconception: generics do **not** mean "anything goes." They mean the opposite — flexible at the class-definition level, strictly enforced at the object level once a type is chosen.

### Use Cases

- All the built-in collections (`ArrayList<T>`, `HashMap<K,V>`) are generic — this is why they're type-safe.
- Writing reusable container/utility classes (a generic `Pair<A, B>`, a generic `Response<T>` wrapper) that work identically regardless of the data type they hold.

---

## 7. File Handling

### Concept

Reading from and writing to files using classes like `FileWriter` and `Scanner`.

```java
// Writing (try-with-resources — auto-closes even if an exception occurs)
try (FileWriter writer = new FileWriter("notes.txt")) {
    writer.write("Hello, this is my first file!");
} catch (IOException e) {
    System.out.println("Something went wrong: " + e.getMessage());
}

// Reading
try {
    File file = new File("notes.txt");
    Scanner reader = new Scanner(file);
    while (reader.hasNextLine()) {
        System.out.println(reader.nextLine());
    }
    reader.close();
} catch (FileNotFoundException e) {
    System.out.println("File not found!");
}
```

### Checked vs Unchecked Exceptions

| | Checked | Unchecked |
|---|---|---|
| Compiler forces handling? | ✅ Yes — won't compile without try/catch or `throws` | ❌ No — compiles either way, may crash at runtime |
| Examples | `IOException`, `FileNotFoundException`, `SQLException` | `ArithmeticException`, `ArrayIndexOutOfBoundsException`, `NullPointerException` |
| Why | Failure depends on external resources (disk, network, permissions) outside the program's control | Failure is usually a bug in the program's own logic |

### Why `close()` matters

- **Resource leak**: an open file handle is a limited OS resource; failing to close it can eventually block new files from being opened ("too many open files").
- **Data loss on writes**: writes are often buffered in memory first; `close()` guarantees the buffer is flushed to disk. Skipping it risks losing data even after `write()` was called.
- **try-with-resources** (`try (FileWriter writer = ...) { ... }`) is the safer modern pattern — Java calls `close()` automatically when the block exits, exception or not.

### Use Cases

- Persisting data between program runs (configs, logs, saved state) without a full database.
- Reading input data files (CSV imports, text processing).

---

## 8. Multithreading

### Concept

By default, Java code runs on a single thread — one line finishes before the next starts. Multithreading lets multiple independent paths of execution run concurrently within one program, similar to a phone playing music and running a messaging app at the same time.

```java
class MyThread extends Thread {
    @Override
    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println("Thread running: " + i);
        }
    }
}

public class ThreadDemo {
    public static void main(String[] args) {
        MyThread t1 = new MyThread();
        t1.start();
        System.out.println("Main method continues...");
    }
}
```

### `start()` vs `run()` — the critical distinction

- `run()` called directly is just a **normal method call** — it executes sequentially on the *current* thread, blocking everything after it until it finishes. No new thread is created.
- `start()` tells the JVM to allocate a **new, separate thread** and run `run()`'s code on it — the calling thread (e.g., `main`) continues immediately without waiting. Output ordering between threads becomes non-deterministic (interleaved).
- A given `Thread` object can only be `start()`-ed **once**. Calling `start()` a second time throws `IllegalThreadStateException` at runtime. To run the same logic again, create a fresh `Thread` object.

### Use Cases

- Performing a long-running task (download, file processing) without freezing the rest of the program (e.g., a UI).
- Handling multiple independent operations concurrently (server handling multiple client requests).

---

## 9. Lambda Expressions

### Concept

A compact way to implement an interface with **exactly one abstract method** (a "functional interface") without writing a full class.

```java
interface Greeting {
    void sayHello();
}

// Old way
class MyGreeting implements Greeting {
    @Override
    public void sayHello() { System.out.println("Hello!"); }
}

// Lambda way
Greeting g = () -> System.out.println("Hello!");
```

### With parameters

```java
interface Calculator {
    int add(int a, int b);
}

Calculator calc = (a, b) -> a + b;
System.out.println(calc.add(5, 3));   // 8
```

### The Functional Interface rule

Lambdas only work when the target interface has **exactly one** abstract method. With two or more methods, Java has no way to know which method the lambda's single implementation is meant for:

```java
interface Calculator {
    int add(int a, int b);
    int subtract(int a, int b);
}

Calculator calc = (a, b) -> a + b;  // ❌ compile error: not a functional interface
```

### Use Cases

- Passing small, inline behavior into methods that expect a functional interface — event handlers, comparators (`Comparator<T>`), and heavily throughout the Streams API below.

---

## 10. Streams API

### Concept

A pipeline-style way to process collections — chaining operations like `filter`, `map`, and `forEach` instead of writing manual loops. Streams are built to be used together with lambdas.

```java
ArrayList<Integer> numbers = new ArrayList<>();
numbers.add(10); numbers.add(15); numbers.add(20); numbers.add(25);

numbers.stream()
       .filter(n -> n % 2 == 0)   // keep only elements where condition is true
       .map(n -> n * 2)             // transform every remaining element
       .forEach(n -> System.out.println(n));

// Output: 20, 40
```

### `filter()` vs `map()`

| Method | What it does |
|---|---|
| `filter(condition)` | Removes elements that fail the condition; keeps the rest unchanged |
| `map(transformation)` | Transforms every element (nothing removed) |

### Manual loop vs Stream — same result, different readability

```java
// Manual loop
for (int i = 0; i < numbers.size(); i++) {
    if (numbers.get(i) % 2 == 0) {
        System.out.println(numbers.get(i));
    }
}

// Stream
numbers.stream().filter(n -> n % 2 == 0).forEach(System.out::println);
```

### Use Cases

- Concise data transformation pipelines: filtering a list of orders by status, then mapping to just the total amounts, then summing.
- Chaining multiple operations in one readable expression instead of nested loops with intermediate variables.

---

## 11. Common Mistakes Log (from this lesson)

1. **`list.remove(1)` on an `ArrayList<Integer>`** — always resolves to `remove(int)` (index), never `remove(Object)` (value), even when the intent was to remove the value `1`. Use `Integer.valueOf(1)` to force value-based removal.
2. **Misunderstanding Big-O for a single HashMap operation vs the whole method** — `containsKey`/`get`/`put` are each O(1), but a loop calling them n times is still O(n) overall, not O(1).
3. **Assuming HashMap-based solutions are strictly "better" without checking the tradeoff** — faster time complexity (O(n) vs O(n²)) came at the cost of extra space (O(k) for unique keys), not for free.
4. **Thinking generics mean "any type is now allowed"** — the opposite is true. `Box<T>` is flexible only until an object is created; `Box<Integer>` then permanently locks that object to `Integer`.
5. **Calling `run()` instead of `start()`** on a `Thread` subclass — this silently just runs the code sequentially on the current thread; no new thread is created, defeating the entire purpose.
6. **Assuming a `Thread` object can be restarted** — `start()` a second time throws `IllegalThreadStateException`; a fresh object is required to run the same logic again.
7. **Confusing checked and unchecked exceptions** — checked exceptions (`IOException` and similar) must be handled or declared, or the code won't compile; this is unlike `ArithmeticException`, which compiles fine even if unhandled.

---

## 12. Interview Question Bank

**Q1. Why use Collections instead of arrays?**
Arrays have a fixed size decided at creation and can't grow — resizing means manually creating a new array and copying everything over. Collections (`ArrayList` and friends) handle resizing internally and come with built-in methods for common operations.

**Q2. What's the difference between `ArrayList.remove(int)` and `ArrayList.remove(Object)`?**
`remove(int)` removes by index; `remove(Object)` removes by matching value. With `ArrayList<Integer>`, a bare integer literal always resolves to the index overload — removing the value itself requires wrapping it explicitly, e.g. `remove(Integer.valueOf(1))`.

**Q3. What happens if you `put()` a key that already exists in a HashMap?**
The existing value is overwritten with the new one — a HashMap never stores duplicate keys.

**Q4. What's the time and space complexity of counting character frequency with a HashMap vs nested loops?**
Nested loops: O(n²) time, O(1) space. HashMap: O(n) time, O(k) space where k is the number of unique characters — a classic space-for-time tradeoff.

**Q5. Does a HashSet overwrite duplicates like a HashMap does?**
No — a HashSet just silently ignores the duplicate `add()` call, since there's no associated value to update; it's a pure uniqueness constraint on elements, not a key-value mapping.

**Q6. Why is inserting into the middle of a LinkedList faster than an ArrayList?**
An ArrayList is backed by contiguous memory, so inserting in the middle requires shifting every subsequent element (O(n)). A LinkedList's elements are separate nodes connected by references, so inserting only requires re-pointing two links (O(1)), given a reference to the insertion point.

**Q7. If LinkedList is faster for insertion, why is ArrayList used more often?**
Because ArrayList offers O(1) random access via index, while LinkedList requires O(n) traversal from the start to reach a given position. Most real-world usage reads/accesses more often than it inserts in arbitrary middle positions.

**Q8. What problem do Generics solve?**
They move type-mismatch errors from runtime (a `ClassCastException` discovered only when the bad element is actually used, possibly in production) to compile time (caught immediately when the code is written).

**Q9. Once you create `Box<Integer> b = new Box<>();`, can you later store a String in it?**
No — the type parameter is fixed at object-creation time. `b.setItem("text")` is a compile error, because this specific object is now permanently bound to `Integer`.

**Q10. What's the difference between a checked and an unchecked exception?**
Checked exceptions (e.g., `IOException`) must be handled or declared, or the code won't compile — used for failures depending on external, uncontrollable resources like files or networks. Unchecked exceptions (e.g., `ArithmeticException`) compile regardless of whether they're handled, since they usually stem from a bug in the program's own logic rather than an external failure.

**Q11. Why is `close()` important after file operations?**
It releases the OS-level file handle (preventing resource leaks) and, for writes, flushes any buffered data to disk (preventing silent data loss) — both of which `try-with-resources` handles automatically even if an exception occurs mid-operation.

**Q12. What's the actual difference between calling `thread.start()` and `thread.run()`?**
`start()` allocates a new thread and runs the code concurrently with the calling thread. `run()` called directly is just an ordinary method call — it executes on the current thread synchronously, and no new thread is ever created.

**Q13. Can a Thread object be started twice?**
No — calling `start()` on an already-started thread throws `IllegalThreadStateException` at runtime. A new `Thread` object must be created to rerun the same logic.

**Q14. What is a functional interface, and why does it matter for lambdas?**
An interface with exactly one abstract method. Lambdas can only target functional interfaces, because a lambda supplies exactly one implementation — with two or more methods on the interface, Java has no way to know which one the lambda is meant to implement.

**Q15. What's the practical difference between `filter()` and `map()` in a stream?**
`filter()` removes elements that don't satisfy a condition (the stream may get shorter). `map()` transforms every element into something else without removing any (the stream stays the same length).

---

## Notes on this project

- This lesson leaned heavily on things learned in OOP: `Thread` is a class you `extend`, `run()` is a method you `@Override`, and lambdas are really just a shorthand for implementing an interface — all previously learned concepts, applied in a new context rather than replaced.
- Recurring theme worth carrying into DSA: **almost every "faster" data structure choice trades away something else** (HashMap trades space for time; LinkedList trades random-access speed for cheaper inserts). Always be able to state the tradeoff, not just the win.