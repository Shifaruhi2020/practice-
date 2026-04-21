# 📚 Course Schedule (Cycle Detection using BFS - Kahn’s Algorithm)

## 🧠 Problem Idea

Given:

* `numCourses`
* `prerequisites[i] = [a, b]` → to take course **a**, you must first take **b**

👉 This forms a **directed graph**
👉 Goal: Check if all courses can be completed

---

## 🔑 Core Concept

> If the graph has a **cycle**, it's impossible to finish all courses.

We use:

* **Topological Sort (BFS - Kahn’s Algorithm)**
* **Indegree array**

---

## ⚙️ Steps Overview

1. Build adjacency list (`b → a`)
2. Compute indegree of each node
3. Add nodes with indegree `0` to queue
4. Perform BFS
5. Count processed nodes
6. Compare with `numCourses`

---

## 🔍 Dry Run Example

### Input

```
numCourses = 4
prerequisites = [[1,0], [2,0], [3,1], [3,2]]
```

---

### Step 1: Build Graph

```
0 → [1,2]
1 → [3]
2 → [3]
3 → []
```

---

### Step 2: Indegree Array

```
[0, 1, 1, 2]
```

---

### Step 3: Initialize Queue

```
Queue = [0]
```

---

### Step 4: BFS Processing

#### 👉 Process 0

* count = 1
* reduces indegree of 1 and 2

```
indegree = [0,0,0,2]
Queue = [1,2]
```

---

#### 👉 Process 1

* count = 2
* reduces indegree of 3

```
indegree = [0,0,0,1]
Queue = [2]
```

---

#### 👉 Process 2

* count = 3
* reduces indegree of 3

```
indegree = [0,0,0,0]
Queue = [3]
```

---

#### 👉 Process 3

* count = 4

```
Queue = []
```

---

### ✅ Final Check

```
count = 4
numCourses = 4
```

✔️ All nodes processed → **No cycle** → return `true`

---

## ❌ Cycle Case

### Input

```
numCourses = 2
prerequisites = [[1,0], [0,1]]
```

### Indegree

```
[1,1]
```

### Queue

```
[]
```

👉 No node with indegree 0
👉 BFS never starts
👉 count = 0

---

### ❌ Final Check

```
count != numCourses
```

❌ Cycle exists → return `false`

---

## 🧠 Key Intuition

* Nodes with **indegree = 0** → can be processed
* In a **cycle**, no node becomes 0
* So some nodes remain **unprocessed**

---

## 🔥 Final Rule

> If `count == numCourses` → ✅ possible
> Else → ❌ cycle exists

---

## 💡 One-Line Memory Trick

> **Topo sort processes only non-cyclic nodes**
