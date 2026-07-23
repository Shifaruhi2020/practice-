# Floor and Ceil in a Binary Search Tree (BST)

## Problem Statement

Given the root of a **Binary Search Tree (BST)** and a **key**, find the **floor** and **ceil** values for that key.

- **Floor:** The greatest value in the BST that is **less than or equal to** the key.
- **Ceil:** The smallest value in the BST that is **greater than or equal to** the key.

If either the floor or ceil does not exist, return **-1** for that value.

---

## Examples

### Example 1

![alt text](<Screenshot 2026-07-24 at 12.36.09 AM.png>)

**Input**
```text
root = [8, 4, 12, 2, 6, 10, 14]
key = 11
```

**Output**
```text
[10, 12]
```

**Explanation**

- Floor of 11 = **10**
- Ceil of 11 = **12**

---

### Example 2

![alt text](<Screenshot 2026-07-24 at 12.36.09 AM-1.png>)

**Input**
```text
root = [8, 4, 12, 2, 6, 10, 14]
key = 15
```

**Output**
```text
[14, -1]
```

**Explanation**

- Floor of 15 = **14**
- No value greater than or equal to 15 exists, so Ceil = **-1**

---

## Practice Example

**Input**
```text
root = [8, 4, 12, 2, 6, 10, 14]
key = 1
```

**Output**
```text
[-1, 2]
```

**Explanation**

- No value less than or equal to 1 exists, so Floor = **-1**
- The smallest value greater than or equal to 1 is **2**

---

## Constraints

- `1 <= Number of Nodes <= 5000`
- `1 <= Node.val <= 10^7`
- `1 <= key <= 10^7`

---

# Approach

Since the tree is a **Binary Search Tree**, we can efficiently find both floor and ceil by traversing from the root.

### Finding Floor

- If the current node equals the key, it is the floor.
- If the current node is less than the key:
  - It is a potential floor.
  - Move to the right subtree to find a larger valid value.
- If the current node is greater than the key:
  - Move to the left subtree.

### Finding Ceil

- If the current node equals the key, it is the ceil.
- If the current node is greater than the key:
  - It is a potential ceil.
  - Move to the left subtree to find a smaller valid value.
- If the current node is less than the key:
  - Move to the right subtree.

---

# Algorithm

### Floor

1. Initialize `floor = -1`.
2. Start from the root.
3. While the current node is not null:
   - If `node.data == key`, return `key`.
   - If `node.data < key`:
     - Update `floor`.
     - Move right.
   - Else:
     - Move left.
4. Return `floor`.

### Ceil

1. Initialize `ceil = -1`.
2. Start from the root.
3. While the current node is not null:
   - If `node.data == key`, return `key`.
   - If `node.data > key`:
     - Update `ceil`.
     - Move left.
   - Else:
     - Move right.
4. Return `ceil`.

---

# Complexity Analysis

| Operation | Time Complexity | Space Complexity |
|-----------|-----------------|------------------|
| Find Floor | **O(H)** | **O(1)** |
| Find Ceil | **O(H)** | **O(1)** |

Where **H** is the height of the BST.

- **Balanced BST:** `O(log N)`
- **Skewed BST:** `O(N)`

---

# Key Takeaways

- Utilize the BST property to avoid traversing the entire tree.
- Floor and ceil can each be found in a single traversal.
- No extra data structures are required.
- The solution uses constant auxiliary space.