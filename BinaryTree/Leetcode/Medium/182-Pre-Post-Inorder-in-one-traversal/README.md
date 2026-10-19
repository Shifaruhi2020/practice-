# 182. Preorder, Inorder and Postorder in One Traversal

[Problem Link](https://takeuforward.org/practice/dsa/pre%2C-post%2C-inorder-in-one-traversal)

## Problem Statement

Given the root of a binary tree, return its **Inorder, Preorder, and Postorder traversals** in a single traversal.

The result should contain three lists in the following order:

1. Inorder Traversal
2. Preorder Traversal
3. Postorder Traversal

### Example 1

**Input:**
```text
root = [1, 3, 4, 5, 2, 7, 6]
```

**Output:**
```text
[
    [5, 3, 2, 1, 7, 4, 6],
    [1, 3, 5, 2, 4, 7, 6],
    [5, 2, 3, 7, 6, 4, 1]
]
```

**Explanation:**

- **Inorder:** `[5, 3, 2, 1, 7, 4, 6]`
- **Preorder:** `[1, 3, 5, 2, 4, 7, 6]`
- **Postorder:** `[5, 2, 3, 7, 6, 4, 1]`

### Example 2

**Input:**
```text
root = [1, 2, 3, null, null, null, 6]
```

**Output:**
```text
[
    [2, 1, 3, 6],
    [1, 2, 3, 6],
    [2, 6, 3, 1]
]
```

**Explanation:**

- **Inorder:** `[2, 1, 3, 6]`
- **Preorder:** `[1, 2, 3, 6]`
- **Postorder:** `[2, 6, 3, 1]`

## Traversal Rules

| Traversal | Visiting Order |
|---|---|
| Preorder | Root → Left → Right |
| Inorder | Left → Root → Right |
| Postorder | Left → Right → Root |

## Approach: Iterative Traversal Using One Stack

The idea is to traverse the tree using a stack and assign each node a state that indicates which traversal step should be performed next.

Each node is processed in three stages:

- **State 1 — Preorder:** Add the node's value to the preorder list, then move to its left child.
- **State 2 — Inorder:** Add the node's value to the inorder list, then move to its right child.
- **State 3 — Postorder:** Add the node's value to the postorder list and remove the node from the stack.

A stack stores pairs containing a tree node and its current state.

### Algorithm

1. Create three empty lists: `inorder`, `preorder`, and `postorder`.
2. If the root is not `null`, push `(root, 1)` onto the stack.
3. While the stack is not empty:
   - If the state is `1`, add the node to preorder, update its state to `2`, and push its left child if it exists.
   - If the state is `2`, add the node to inorder, update its state to `3`, and push its right child if it exists.
   - If the state is `3`, add the node to postorder and pop it from the stack.
4. Return the three lists in the order: inorder, preorder, postorder.

## Complexity Analysis

Let `N` be the number of nodes in the binary tree.

- **Time Complexity:** `O(N)` — Every node is processed a constant number of times.
- **Auxiliary Space Complexity:** `O(N)` — The stack can store up to `O(N)` nodes in the worst case.
- **Output Space:** `O(N)` for storing all three traversal lists.

## Key Takeaway

All three traversals can be obtained in a **single iterative traversal** by tracking the state of each node instead of performing three separate traversals.

Remember:

- State `1` → Preorder
- State `2` → Inorder
- State `3` → Postorder
