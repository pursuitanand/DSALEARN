# DSA-LEARN

A personal Java playground for practising data structures, algorithms, and core language
concepts. Each topic lives in its own package, and most classes carry a `main` method so
they can be run standalone and their output inspected.

This is a learning repository, not a library: some classes are complete implementations,
others are scratch space or stubs left in place as reminders of what to implement next.

## Project layout

Plain IntelliJ IDEA module — no Maven or Gradle build. Sources follow the standard
`src/main/java` layout under the `com.anand` root package.

```
src/main/java/com/anand/
├── basic/          Language fundamentals: threads, inheritance, equality, casting
├── codility/       Codility-style coding problems
├── concurrency/    Thread, Runnable and volatile examples
├── design/         Design patterns (singleton variants)
├── ds/             Data structures and algorithms — the bulk of the repo
├── general/        Assorted Java exercises (strings, wrappers, iteration, final)
├── hashcode/       hashCode / equals behaviour experiments
├── recursion/      Recursive algorithms
└── xml/            XML / stream reading scratch work
```

## What's inside

### Data structures (`com.anand.ds`)

| Package | Contents |
| --- | --- |
| `ds.stack` | `MyStack` (array-backed stack), `SortStack`, `RecursionStackSort` |
| `ds.queue` | `QueueDemo` |
| `ds.heap` | `Heap` — array-backed binary heap with `fixUp`/`fixDown`; `AscendingHeap` |
| `ds.hashtable` | `MyHashTable` — open addressing with quadratic probing |
| `ds.btree`, `ds.binaryTree` | Binary tree and BST implementations, tree nodes |
| `ds.nonlinear.tree.bst` | Cleaner BST built behind a `Tree` interface, with a runnable `App` |
| `ds.graph` | `GraphAdjacencyList`, `RoomDoorProblem` (rooms/doors as an adjacency map) |
| `ds.holder.demo` | `IntHolder` / `IntHolderDemo` — call-by-value vs. holder-object semantics |
| `ds.autoboxing.problem` | Autoboxing behaviour demo |
| `ds.problem.cart` | Shopping basket / catalogue modelling exercise |

### Graph algorithms (`com.anand.ds.nonlinear.graph`)

Each algorithm sits in its own package with a `Vertex` type and a runnable `App`:

- `bfs` — breadth-first search
- `dfs` — depth-first search
- `cycledetection` — cycle detection on a directed graph
- `topologicalorder` — topological sort built on DFS plus a stack
- `webcrawler` — placeholder for a graph-traversal crawler

### Sorting (`com.anand.ds.sort`)

- `sort.merge.MergeSort` — recursive split → sort → merge with the three-pointer merge
- `sort.recurrence.QuickOrMergeSort` — quicksort with Lomuto partition, plus merge sort;
  driven by `RunSort` with tracing helpers in `SortUtil`
- `sort.linear.coverage.SelectionSort` — selection sort
- `sort.linear.ShellCountingBinSort` — stub for shell / counting / radix sort
- `codility.problem.BubbleSortExample` — bubble sort

### Algorithm problems

- `codility.problem` — `BinaryGap`, `FindPalindrome`, `FindFactorial`, `CheckIndexOf`,
  `ChinChoProblem`, `SmallestNumberDoNotOccur` (smallest missing positive integer)
- `recursion.problem.EuclidGCD` — Euclid's algorithm for GCD
- `general.problem` — `ReverseString`, `Percentage`, `IterationProblem`,
  `RandomizeDistributeList`, `StringTokenizerExample`, and friends

### Java concepts

- **Concurrency** — `concurrency.example` covers extending `Thread`, implementing
  `Runnable`, and a `volatile` visibility demo; `basic.concurrency.ThreadExample` and
  `general.problem.ObjectWaitInMain` cover the basics of `wait`/`notify`
- **Design patterns** — `design.pattern.singleton` compares eager init, lazy init,
  double-checked locking with `volatile`, and the enum singleton
- **Equality and hashing** — `basic.problems.CheckEquals`,
  `hashcode.problem.DiffHashCodeStringAndStringBuilder`, `hashcode.problem.Employee`
- **Inheritance, casting, finality** — `basic.inheritance.InheritanceExample`,
  `basic.problems.LegalTypeCastingAndCalculation`, `general.problem.FinalClassExample`

## Running an example

Any class with a `main` method can be compiled and run directly. From the repository root:

```bash
# Compile every source file into ./out
javac -d out $(find src/main/java -name "*.java")

# Run a single example
java -cp out com.anand.ds.sort.merge.MergeSort
java -cp out com.anand.ds.nonlinear.graph.bfs.App
java -cp out com.anand.recursion.problem.EuclidGCD
```

On Windows PowerShell:

```powershell
javac -d out (Get-ChildItem -Recurse -Filter *.java src\main\java | ForEach-Object FullName)
java -cp out com.anand.ds.sort.merge.MergeSort
```

Or simply open the project in IntelliJ IDEA (`DSALEARN.iml` is included) and run any
class with the gutter arrow.

## Notes

- A handful of classes are intentionally empty or commented out — they mark topics queued
  up for implementation rather than finished work.
- `xml.ReadXML` and `general.problem.DBConnectionTest2` reference local paths and external
  resources, so they will not run as-is without adjustment.
- Compiled output under `out/` is build residue; `*.class` files are covered by
  `.gitignore`.
