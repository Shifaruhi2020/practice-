# 📌 Topological Sort (Kahn's Algorithm)

## 🧠 Problem Statement

Given a **Directed Acyclic Graph (DAG)** with `V` vertices labeled from `0` to `V-1`, the graph is represented using an adjacency list where `adj[i]` contains all nodes connected to node `i`.

👉 Your task is to **find any valid Topological Sorting** of the graph.

---

## 🔍 What is Topological Sorting?

Topological sorting is a linear ordering of vertices such that:

> For every directed edge `u → v`, node `u` appears **before** node `v`.

✅ This is only possible for **DAGs (Directed Acyclic Graphs)**.

---

## ⚙️ Approach: Kahn's Algorithm (BFS)

Kahn’s Algorithm is a **BFS-based approach** that works using **indegree**.

### 🪜 Steps:

1. Compute **indegree** of all nodes
2. Add all nodes with **indegree = 0** to a queue
3. While queue is not empty:
   - Remove node from queue
   - Add it to result
   - Reduce indegree of its neighbors
   - If indegree becomes 0 → add to queue
4. Return the result

---

## 📥 Function Requirement

Return an array representing the **topological order**.

✔️ The result will be validated automatically:
- ✅ Prints `True` → Valid ordering
- ❌ Prints `False` → Invalid ordering

---

## 📊 Example 1

### Input

V = 6

adj = [ [], [], [3], [1], [0,1], [0,2] ]

![alt text](<Screenshot 2026-04-17 at 12.39.39 AM.png>)


### Output

[5, 4, 2, 3, 1, 0]


### 💡 Explanation

- Node `5` → before `0` and `2`
- Node `2` → before `3`
- Node `3` → before `1`
- Node `4` → before `0` and `1`

✅ One valid ordering:

[5, 4, 2, 3, 1, 0]


---

## 📊 Example 2

### Input

V = 4

adj = [ [], [0], [0], [0] ]

![alt text](<Screenshot 2026-04-17 at 12.41.04 AM.png>)

### Output

[3, 2, 1, 0]


### 💡 Explanation

- Nodes `1`, `2`, `3` must come before `0`
- Their internal order can vary

✅ One valid ordering:

[3, 2, 1, 0]


---

## 🧾 Notes

- A graph can have **multiple valid topological orderings**
- Topological sort is used in:
  - Task scheduling
  - Course prerequisites
  - Dependency resolution

---

## 🚀 Time & Space Complexity

- **Time Complexity:** `O(V + E)`
- **Space Complexity:** `O(V)`

---

## 🏁 Summary

✔️ Works only for DAG  
✔️ Uses BFS + Indegree  
✔️ Ensures correct dependency ordering  

---

Happy Coding! 💻🔥

