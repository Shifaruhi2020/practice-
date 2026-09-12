# Inorder Successor and Predecessor in BST

## Problem Statement

Given the root node of a **Binary Search Tree (BST)** and an integer `key`, return the **inorder predecessor** and **inorder successor** of the given key.

### Note

* The `key` will always be present in the given BST.
* If the predecessor or successor does not exist, return `-1`.

---

## Examples

### Example 1

**Input:**

```text
root = [5, 2, 10, 1, 4, 7, 12]
key = 10
```

**Output:**

```text
[7, 12]
```

**Explanation:**

For `key = 10`:

* Inorder predecessor = `7`
* Inorder successor = `12`

Example 1![](<Screenshot 2026-09-13 at 1.35.45 AM.png>)

---

### Example 2

**Input:**

```text
root = [5, 2, 10, 1, 4, 7, 12]
key = 12
```

**Output:**

```text
[10, -1]
```

**Explanation:**

For `key = 12`:

* Inorder predecessor = `10`
* Inorder successor does not exist, so return `-1`.

Example 2![](<Screenshot 2026-09-13 at 1.35.45 AM-1.png>)

---

## Approach

Since the given tree is a **BST**, we can use its ordering property to find the predecessor and successor efficiently.

### Inorder Predecessor

The predecessor of `key` is the **largest value smaller than `key`**.

* If `root.data < key`:

  * Current node can be a predecessor.
  * Move to the **right subtree** to find a potentially larger value.
* Otherwise:

  * Move to the **left subtree**.

### Inorder Successor

The successor of `key` is the **smallest value greater than `key`**.

* If `root.data > key`:

  * Current node can be a successor.
  * Move to the **left subtree** to find a potentially smaller value.
* Otherwise:

  * Move to the **right subtree**.

---

## Algorithm

1. Initialize `predecessor = -1` and `successor = -1`.
2. Traverse the BST to find the predecessor:

   * If `root.data < key`, update `predecessor` and move right.
   * Otherwise, move left.
3. Traverse the BST to find the successor:

   * If `root.data > key`, update `successor` and move left.
   * Otherwise, move right.
4. Return `[predecessor, successor]`.

---

## Complexity

* **Time Complexity:** `O(h)`
* **Space Complexity:** `O(1)`

Where `h` is the height of the BST.

For a balanced BST:

```text
O(log n)
```

For a skewed BST:

```text
O(n)
```

---

## Key Concept

For a BST:

```text
Inorder traversal → sorted order
```

Therefore:

```text
Predecessor = largest value < key
Successor   = smallest value > key
```
