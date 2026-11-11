/** solution Link : https://www.youtube.com/watch?v=u-yWemKGWO0
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
    public int countNodes(TreeNode root) {

        if(root == null) return 0;

        int left = leftSubtree(root);
        int right = rightSubtree(root);

        if(left == right){
            return (int) ((1L << left)- 1);
        }

        return 1 + countNodes(root.left) + countNodes(root.right);
    }

    public int leftSubtree(TreeNode node){
        int height = 0;

        while(node != null){
            height++;
            node = node.left;
        }

        return height;
    }

    public int rightSubtree(TreeNode node){
        int height = 0;

        while(node != null){
            height++;
            node = node.right;
        }

        return height;
    }
}