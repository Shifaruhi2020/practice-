# Topological Sort (BFS - Kahn’s Algorithm)

## 📌 Definition
Topological Sort = Linear ordering of nodes such that  
for every edge `u → v`, **u comes before v**

✔️ Only possible in **Directed Acyclic Graph (DAG)**

---

## 🧠 Core Idea
- Nodes with **indegree = 0** → no dependencies → process first
- Remove them → reduce indegree of neighbors
- Repeat

---

## ⚙️ Steps

1. Compute indegree of all nodes
2. Push all nodes with indegree = 0 into queue
3. While queue not empty:
   - Remove node
   - Add to answer
   - Reduce indegree of neighbors
   - If indegree becomes 0 → push to queue

---

## ⚠️ Cycle Detection

- If processed nodes < total nodes  
  ➝ **Cycle exists**
  ➝ Topo sort NOT possible

---

## ⏱️ Complexity

- Time: **O(V + E)**
- Space: **O(V)**

---

## 🔥 Key Patterns

👉 Use when you see:
- Dependencies
- Prerequisites
- Order of tasks
- Scheduling problems

---

## 🆚 BFS vs DFS

- **BFS (Kahn’s)** → uses indegree + queue  
- **DFS** → uses recursion + stack  

👉 BFS is easier for **cycle detection**

---

## 🚨 Common Mistakes

- Using wrong variable (`i` instead of `node`)
- Not updating indegree correctly
- Forgetting cycle check

---

## ✅ One-Line Memory Trick

👉 "Start with 0 indegree → remove → reduce → repeat"

---

