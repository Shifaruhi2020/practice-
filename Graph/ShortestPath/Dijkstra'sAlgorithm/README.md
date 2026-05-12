# Dijkstra's Algorithm

> Find the shortest distance from a source vertex to all other vertices in a weighted, undirected graph using Dijkstra's Algorithm.

---

## 📝 Problem Statement

Given a weighted, undirected graph with `V` vertices numbered from `0` to `V - 1`, and a 2D array `edges` where:

- `edges[i] = [u, v, weight]`

Where:

- `u` and `v` represent the two vertices connected by an undirected edge.
- `weight` represents the cost (distance) between them.

Given a source vertex `S`, return an array where:

- `answer[i]` = shortest distance from source `S` to vertex `i`.
- If a vertex is not reachable from `S`, its distance should be `10^9`.


---

## 📊 Example 1

![alt text](<Screenshot 2026-05-12 at 11.08.25 PM.png>)

### Input

V = 2
edges = [[0, 1, 9]]
S = 0


### Output

[0, 9]

### 💡 Explanation

The shortest distance from node 0(source) to node 0 is 0 and the shortest distance from node 0 to node 1 is 9.


---

## 📊 Example 2

![alt text](<Screenshot 2026-05-12 at 11.09.24 PM.png>)

### Input
 V = 3, edges = [[0, 1, 1], [0, 2, 6], [1, 2, 3]] , S=2



### Output
[4, 3, 0]



### 💡 Explanation

For node 0, the shortest path is 2->1->0 (distance=4)

For node 1, the shortest path is 2->1 (distance=3)









