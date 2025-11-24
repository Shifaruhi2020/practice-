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
//  link solution: https://www.youtube.com/watch?v=Yt50Jfbd8Po&list=PLgUwDviBIf0q8Hkd7bK2Bpryj2xVJk8Vk&index=16
class Solution {
    public boolean isBalanced(TreeNode root) {
        return dfsHeight(root) != -1;
    }

    int dfsHeight(TreeNode root){
        if(root == null) return 0;

        int left = dfsHeight(root.left);
        int right = dfsHeight(root.right);
        if(left == -1) return -1;
        if(right == -1) return -1;

        if(Math.abs(left - right) > 1) return -1;
        return Math.max(left , right) + 1;
    }
}