# 195. Print Root to Node Path in a Binary Tree

## Problem Statement

Given the root of a Binary Tree and a target value `x`, find the path from the root node to the node containing `x`.

Return the path as a list of node values.

### Example

**Input:**
```text
          1
        /   \
       2     3
      / \   / \
     4   5 6   7

Target: x = 5
```

**Output:**
```text
[1, 2, 5]
```

**Explanation:**

The path from the root node `1` to the target node `5` is:

`1 → 2 → 5`

---

## Approach: DFS + Backtracking

### Intuition

We can use **Depth First Search (DFS)** to find the target node.

Starting from the root:
1. Add the current node's value to the path.
2. Check if the current node contains the target value `x`.
3. If found, return `true` because the required path is complete.
4. Recursively search the left subtree.
5. If not found in the left subtree, search the right subtree.
6. If the target is not found in either subtree, remove the current node from the path (backtracking) and return `false`.

### Algorithm

1. Create an empty list `path` to store the node values.
2. Call the recursive DFS function with the root and target value.
3. If the current node is `null`, return `false`.
4. Add the current node's value to `path`.
5. If the current node's value equals `x`, return `true`.
6. Recursively search the left and right subtrees.
7. If either recursive call returns `true`, return `true`.
8. If both searches fail, remove the last element from `path` and return `false`.
9. Return the path.

---

## Java Code

```java
class Solution {

    public boolean findPath(TreeNode root, int x, ArrayList<Integer> path) {

        if (root == null) {
            return false;
        }

        path.add(root.data);

        if (root.data == x) {
            return true;
        }

        if (findPath(root.left, x, path) ||
            findPath(root.right, x, path)) {
            return true;
        }

        path.remove(path.size() - 1);

        return false;
    }

    public ArrayList<Integer> solve(TreeNode root, int x) {

        ArrayList<Integer> path = new ArrayList<>();

        findPath(root, x, path);

        return path;
    }
}
```

---

## Dry Run

**Input Tree:**

```text
          1
        /   \
       2     3
      / \   / \
     4   5 6   7

Target = 5
```

We perform DFS, exploring the left subtree before the right subtree.

| Step | Current Node | Operation | Path |
|---|---|---|---|
| 1 | 1 | Add 1 | [1] |
| 2 | 2 | Add 2 | [1, 2] |
| 3 | 4 | Add 4 | [1, 2, 4] |
| 4 | 4 | Target not found, backtrack | [1, 2] |
| 5 | 5 | Add 5 | [1, 2, 5] |
| 6 | 5 | Target found, return true | [1, 2, 5] |

Since node `5` is found, the recursive calls return `true` all the way back to the root.

**Final Output:**
```text
[1, 2, 5]
```

### Understanding Backtracking

Consider the search for node `4`.

- We add `1`, then `2`, then `4` to the path.
- If the target is not `4`, we remove `4` from the path.
- This ensures that the path contains only nodes belonging to the successful route.

**Important:** We remove a node from the path only when neither its left nor right subtree contains the target.

---

## Complexity Analysis

Let `N` be the total number of nodes in the binary tree and `H` be the height of the tree.

**Time Complexity: O(N)**

- In the worst case, we may visit every node if the target is the last node searched or does not exist.
- Each node is processed at most once.

**Space Complexity: O(H)**

- Recursive call stack requires O(H) space.
- The path list requires O(H) space in the worst case.
- Excluding the output path, auxiliary recursion space is O(H).

For a balanced binary tree, height is O(log N).

For a skewed binary tree, height is O(N).

---

## Edge Cases

1. **Target is the root node**
   - Input: `x = 1`
   - Output: `[1]`

2. **Target is a leaf node**
   - Input: `x = 5`
   - Output: `[1, 2, 5]`

3. **Target is in the right subtree**
   - Input: `x = 7`
   - Output: `[1, 3, 7]`

4. **Target does not exist**
   - Input: `x = 10`
   - Output: `[]`

5. **Empty tree**
   - Input: `root = null`
   - Output: `[]`

---

## Key Takeaways

- DFS is useful for exploring paths in a binary tree.
- Backtracking helps maintain only the nodes belonging to the successful path.
- Add the current node before exploring its children.
- Remove the current node only when both subtree searches fail.
- Returning a boolean helps propagate the successful search back to the root.
- The `||` operator ensures that the right subtree is explored only if the left subtree does not contain the target.

**Pattern:** Binary Tree + DFS + Backtracking

**Related Concepts:** Recursion, Path Finding, Tree Traversal