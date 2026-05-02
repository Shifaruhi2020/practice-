# Shortest Path in DAG

## 📌 Problem Statement

Given a **Directed Acyclic Graph (DAG)** with `N` vertices labeled from `0` to `N-1` and `M` edges, represented as a 2D array `edges`, where:

- `edges[i][0]` → source vertex  
- `edges[i][1]` → destination vertex  
- `edges[i][2]` → weight (distance)

Your task is to find the **shortest path from the source vertex (0) to all other vertices**.

If a vertex is **not reachable**, return `-1` for that vertex.

---

## 🧠 Approach

- Since the graph is a **DAG**, we can use **Topological Sorting**.
- Steps:
  1. Perform **Topological Sort** using DFS.
  2. Initialize distances:
     - `dist[0] = 0`
     - All others = `∞`
  3. Process nodes in **topological order**:
     - Relax edges (`dist[u] + weight < dist[v]`)
  4. Replace unreachable (`∞`) values with `-1`

---

## 📥 Input Format

- `N` → Number of vertices  
- `M` → Number of edges  
- `edges[][]` → List of edges `[u, v, wt]`

---

## 📤 Output Format

- Array of shortest distances from node `0` to all nodes

---

## ✅ Example 1

![alt text](<Screenshot 2026-05-02 at 2.11.22 PM.png>)

**Input:**

N = 4, M = 2

edges = [[0,1,2],[0,2,1]]


**Output:**

0 2 1 -1


**Explanation:**
- Shortest path to `1`: `0 → 1` = 2  
- Shortest path to `2`: `0 → 2` = 1  
- Node `3` is unreachable → `-1`

---

## ✅ Example 2

**Input:**

N = 6, M = 7

edges = [[0,1,2],[0,4,1],[4,5,4],[4,2,2],[1,2,3],[2,3,6],[5,3,1]]


**Output:**

0 2 3 6 1 5


**Explanation:**
- `0 → 1` = 2  
- `0 → 4 → 2` = 1 + 2 = 3  
- `0 → 4 → 5 → 3` = 1 + 4 + 1 = 6  
- `0 → 4` = 1  
- `0 → 4 → 5` = 1 + 4 = 5  

---

## ⚙️ Complexity

- **Time Complexity:** `O(N + M)`  
- **Space Complexity:** `O(N + M)`

---

## 🚀 Key Concepts

- Topological Sort (DFS / BFS - Kahn’s Algorithm)
- Graph Traversal
- Relaxation Technique (like Dijkstra but optimized for DAG)

---

## 💡 Notes

- Works only for **Directed Acyclic Graphs (DAG)**
- Faster than Dijkstra for DAG since no priority queue is needed

---

## 📎 Tags

`Graph` `DAG` `Topological Sort` `Shortest Path` `DFS`

---

