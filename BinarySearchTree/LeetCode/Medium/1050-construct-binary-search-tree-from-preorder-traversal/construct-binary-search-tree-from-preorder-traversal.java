// solution vid link : https://www.youtube.com/watch?v=UmJT3j26t1I&feature=youtu.be
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {

    int index = 0;

    public TreeNode bstFromPreorder(int[] preorder) {
        return build(preorder, Integer.MAX_VALUE);
    }

    public TreeNode build(int[] preorder, int bound){
        if(index == preorder.length || preorder[index] > bound) {
            return null;
        }

        TreeNode root = new TreeNode(preorder[index++]);

        root.left = build(preorder, root.val);
        root.right = build(preorder, bound);

        return root;
    }
}