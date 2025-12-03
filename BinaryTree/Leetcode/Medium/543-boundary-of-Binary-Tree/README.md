<h2><a href="https://practice.geeksforgeeks.org/problems/boundary-traversal-of-binary-tree/1">
Boundary Traversal of Binary Tree
</a></h2> 
<img src="https://img.shields.io/badge/Difficulty-Medium-orange" alt="Difficulty: Medium" />
<hr>

<p>Given the <code>root</code> of a binary tree, return the boundary traversal of the tree in an anti-clockwise direction starting from the root.</p>

<p>The boundary includes:</p>
<ul>
    <li>Root node (if it's not a leaf)</li>
    <li>Left boundary (top-down, excluding leaves)</li>
    <li>All leaf nodes (left to right)</li>
    <li>Right boundary (bottom-up, excluding leaves)</li>
</ul>

<p>&nbsp;</p>

<p><strong class="example">Example 1:</strong></p>
<img src="https://files.codingninjas.in/boundarytraversal-5149.png">

<pre>
<strong>Input:</strong> root = [20,8,22,4,12,null,25,null,null,10,14]
<strong>Output:</strong> [20,8,4,10,14,25,22]
</pre>

<p><strong class="example">Example 2:</strong></p>
<pre>
<strong>Input:</strong> root = [1]
<strong>Output:</strong> [1]
</pre>

<p><strong class="example">Example 3:</strong></p>
<pre>
<strong>Input:</strong> root = []
<strong>Output:</strong> []
</pre>

<p>&nbsp;</p>

<p><strong>Constraints:</strong></p>
<ul>
	<li>The number of nodes in the tree is in the range <code>[1, 10<sup>5</sup>]</code>.</li>
	<li><code>-10<sup>9</sup> ≤ Node.data ≤ 10<sup>9</sup></code></li>
</ul>

---

### 🧠 Approach

1. Add root to result (if not leaf)
2. Traverse left boundary (ignore leaves)
3. Collect all leaf nodes using DFS
4. Traverse right boundary (ignore leaves) and reverse order

✔️ Time Complexity: <code>O(N)</code>  
✔️ Space Complexity: <code>O(H)</code> (recursion + stack)  

---

### 💡 Boundary Traversal Order

