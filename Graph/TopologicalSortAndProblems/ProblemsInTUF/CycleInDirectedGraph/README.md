# 🔄 Detect Cycle in a Directed Graph

## 📌 Problem

Given a **directed graph** with `V` vertices (0 to V-1) represented as an adjacency list `adj`, determine whether the graph contains a **cycle**.

- `adj[i]` contains all nodes reachable from node `i`
- Return `true` if a cycle exists, otherwise `false`

---

## 🧪 Examples

### Example 1

Input:

V = 6

adj = [[1], [2,5], [3], [4], [1], []]

![alt text](<Screenshot 2026-04-18 at 4.25.39 PM.png>)

Output:

true


**Explanation:**  
Cycle exists → `1 → 2 → 3 → 4 → 1`

---

### Example 2

Input:

V = 4

adj = [[1,2], [2], [], [0,2]]

Output:

false