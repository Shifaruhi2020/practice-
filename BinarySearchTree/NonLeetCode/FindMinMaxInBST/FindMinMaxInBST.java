public int findMax(TreeNode root) {
    if (root == null) {
        return -1;
    }

    while (root.right != null) {
        root = root.right;
    }

    return root.val;
}

public int findMin(TreeNode root) {
    if (root == null) {
        return -1;
    }

    while (root.left != null) {
        root = root.left;
    }

    return root.val;
}