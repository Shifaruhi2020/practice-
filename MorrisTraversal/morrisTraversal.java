// link vid : https://www.youtube.com/watch?v=80Zug6D1_r4
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {

        List<Integer> ans = new ArrayList<>();

        TreeNode curr = root;

        while (curr != null) {

            // CASE 1: No left child
            if (curr.left == null) {

                ans.add(curr.val);
                curr = curr.right;

            }

            // CASE 2: Left child exists
            else {

                TreeNode prev = curr.left;

                // Find the rightmost node in left subtree
                while (prev.right != null && prev.right != curr) {
                    prev = prev.right;
                }

                // First time visiting curr → Create thread
                if (prev.right == null) {

                    prev.right = curr;
                    curr = curr.left;

                }

                // Second time visiting curr → Remove thread
                else {

                    prev.right = null;
                    ans.add(curr.val);
                    curr = curr.right;
                }
            }
        }

        return ans;
    }
}