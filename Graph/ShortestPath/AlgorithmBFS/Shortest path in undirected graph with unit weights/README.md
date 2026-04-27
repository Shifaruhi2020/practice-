# 🚀 Shortest Path in Undirected Graph (Unit Weights)

## 📌 Problem Statement

Given an **undirected graph** with:

- `N` vertices labeled from `0` to `N-1`
- `M` edges
- A 2D integer array `edges[][]`, where each edge represents a connection:

edges[i][0] ↔ edges[i][1]


All edges have **unit weight (1)**.

---

## 🎯 Objective

Find the **shortest path distance from source node `0`** to all other nodes.

- If a node is **unreachable**, return `-1` for that node.

---

## 💡 Approach

Since all edges have equal weight, we use:

👉 **Breadth-First Search (BFS)**

### Why BFS?
- Explores nodes level by level
- Guarantees shortest path in unweighted graphs

---

## ⚙️ Algorithm

1. Create an **adjacency list** from edges
2. Initialize a `distance[]` array with a large value (`∞`)
3. Set `distance[0] = 0`
4. Use a **queue** to perform BFS
5. For each node:
 - Traverse its neighbors
 - Update distance if a shorter path is found
6. Replace unreachable nodes (`∞`) with `-1`

---

## 🧠 Complexity

- **Time Complexity:** `O(N + M)`
- **Space Complexity:** `O(N + M)`

---

## 🧾 Example 1

**Input:**

n = 9, m = 10

edges = [[0,1],[0,3],[3,4],[4,5],[5,6],[1,2],[2,6],[6,7],[7,8],[6,8]]


**Output:**

0 1 2 1 2 3 3 4 4


---

## 🧾 Example 2

**Input:**

n = 8, m = 10

edges = [[1,0],[2,1],[0,3],[3,7],[3,4],[7,4],[7,6],[4,5],[4,6],[6,5]]


**Output:**

0 1 2 1 2 3 3 2
