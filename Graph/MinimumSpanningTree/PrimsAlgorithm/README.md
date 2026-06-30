# Minimum Spanning Tree (Prim's Algorithm)

## Problem Statement

Given a **weighted, undirected, and connected graph** with `V` vertices numbered from `0` to `V-1`, represented as an adjacency list, find the **sum of the weights of the edges** in its **Minimum Spanning Tree (MST)**.

The graph is given as:

```text
adj[u] = [[v1, w1], [v2, w2], ...]
```

where:

- `v` = adjacent vertex
- `w` = weight of the edge

A **Minimum Spanning Tree (MST)** is a subset of edges that:

- Connects all vertices.
- Contains no cycles.
- Has the minimum possible total edge weight.

---

## Examples

### Example 1

![alt text](<Screenshot 2026-06-30 at 11.31.47 PM.png>)

**Input**

```text
V = 4

adj = [
  [[1,1],[3,4]],
  [[0,1],[2,2]],
  [[1,2],[3,3]],
  [[0,4],[2,3]]
]
```

**Output**

```text
6
```

**Explanation**

MST includes the following edges:

```text
0 → 1 (weight = 1)
1 → 2 (weight = 2)
2 → 3 (weight = 3)
```

Total weight:

```text
1 + 2 + 3 = 6
```

---

### Example 2

**Input**

```text
V = 3

adj = [
  [[1,5],[2,15]],
  [[0,5],[2,10]],
  [[0,15],[1,10]]
]
```

**Output**

```text
15
```

**Explanation**

MST includes:

```text
0 → 1 (weight = 5)
1 → 2 (weight = 10)
```

Total weight:

```text
5 + 10 = 15
```

---

# Approach (Prim's Algorithm)

We use **Prim's Algorithm**, which greedily grows the Minimum Spanning Tree by always selecting the minimum-weight edge that connects a visited vertex to an unvisited vertex.

### Algorithm

1. Start from any node (usually node `0`).
2. Push all adjacent edges into a **Min Heap (Priority Queue)**.
3. Extract the edge with the smallest weight.
4. If the destination node is already visited, ignore it.
5. Otherwise:
   - Add its weight to the MST.
   - Mark the node as visited.
   - Push all of its unvisited neighbors into the priority queue.
6. Continue until all vertices are included.

---

# Dry Run

Consider:

```text
      1
  (0)---(1)
   |     |
 4 |     |2
   |     |
  (3)---(2)
      3
```

Priority Queue initially:

```text
(0, weight = 0)
```

### Step 1

Remove:

```text
(0,0)
```

Visited:

```text
{0}
```

Push:

```text
(1,1)
(3,4)
```

MST Weight = **0**

---

### Step 2

Remove:

```text
(1,1)
```

Visited:

```text
{0,1}
```

Push:

```text
(2,2)
```

MST Weight = **1**

---

### Step 3

Remove:

```text
(2,2)
```

Visited:

```text
{0,1,2}
```

Push:

```text
(3,3)
```

MST Weight = **3**

---

### Step 4

Remove:

```text
(3,3)
```

Visited:

```text
{0,1,2,3}
```

MST Weight = **6**

All vertices are visited.

Final Answer:

```text
6
```

---

# Why Prim's Algorithm Works

At every step, Prim's Algorithm chooses the **minimum-weight edge** that connects the current MST to an unvisited vertex.

Since it always expands the tree using the smallest available edge without creating cycles, it guarantees the minimum possible spanning tree.

---

# Time Complexity

Using a Priority Queue:

- Each edge may be inserted into the priority queue.
- Each insertion/removal costs **O(log V)**.

Overall:

```text
O(E log V)
```

where:

- `V` = Number of vertices
- `E` = Number of edges

---

# Space Complexity

- Visited array: **O(V)**
- Priority Queue: **O(E)**

Overall:

```text
O(V + E)
```

---

# Data Structures Used

- Adjacency List
- Min Heap (Priority Queue)
- Visited Array

---

# Key Concepts

- Greedy Algorithm
- Minimum Spanning Tree (MST)
- Prim's Algorithm
- Priority Queue (Min Heap)
- Graph Traversal
- Undirected Weighted Graph