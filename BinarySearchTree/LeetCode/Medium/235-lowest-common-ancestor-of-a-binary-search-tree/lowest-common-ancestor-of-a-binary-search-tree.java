// solution link : https://www.youtube.com/watch?v=cX_kPV_foZc
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        if(root == null) return null;

        TreeNode cur = root;
        if(cur.val < p.val && cur.val < q.val){
            return lowestCommonAncestor(cur.right, p, q);
        }

        if(cur.val > p.val && cur.val > q.val){
            return lowestCommonAncestor(cur.left, p, q);
        }

        return root;    
    }
}