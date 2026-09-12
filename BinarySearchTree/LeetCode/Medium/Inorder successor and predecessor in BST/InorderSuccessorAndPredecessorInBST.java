// solution link : https://www.youtube.com/watch?v=SXKAD2svfmI
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
    List<Integer> succPredBST(TreeNode root, int key) {
        int prev = -1 ;
        int next = -1;

        while(root != null){

            // checking left
            if(root.data > key){
                next = root.data;
                root = root.left;
            }
            // checking right
            else if(root.data < key){
                prev = root.data;
                root = root.right;
            }
            // if we found the key
            else{

                TreeNode temp = root.left;

                // exploring the left subtree first

                while(temp != null){
                    prev = temp.data;
                    temp = temp.right;
                }

                // exploring the right subtree after finding the key
                temp = root.right;

                while(temp != null){
                    next = temp.data;
                    temp = temp.left;
                }

                break;
            }
        }

        List<Integer> result = new ArrayList<>();

        result.add(prev);
        result.add(next);

        return result;
    }
}