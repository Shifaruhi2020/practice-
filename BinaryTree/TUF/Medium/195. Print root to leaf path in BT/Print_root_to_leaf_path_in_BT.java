/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int data;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int val) { data = val; left = null, right = null }
 * }
 **/

class Solution {
    public ArrayList<Integer> allRootToLeaf(TreeNode root, ArrayList<Integer> arr,int x) {
        //your code goes here

        ArrayList<Integer> arr = new ArrayList<>();

        if(root == null) return arr;
        solve(root, arr, x);
        return arr;
    }

    public boolean solve(reeNode node, ArrayList<Integer> arr,int x){

        if(node == null) return false;

        arr.add(node.val);

        if(node.val == x){
            return true;
        }

        if(solve(node.left, arr, x) || solve(node.right, arr, x)){
            return true;
        }
        arr.remove(arr.size() - 1);

        return false;
    }
}