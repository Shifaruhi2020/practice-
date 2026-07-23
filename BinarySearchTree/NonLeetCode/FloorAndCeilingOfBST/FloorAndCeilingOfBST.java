
// solution link : https://www.youtube.com/watch?v=xm_W1ub-K-w&list=PLgUwDviBIf0q8Hkd7bK2Bpryj2xVJk8Vk&index=44
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
    public List<Integer> floorCeilOfBST(TreeNode root, int key) {
        //your code goes here

        int floor = findFloor(root, key);

        int ceil = findCeil(root, key);

        // ArrayList<Integer> ans = new ArrayList<>();

        return Arrays.asList(floor, ceil);
    }

    public int findFloor(TreeNode root, int key){
        int floor = -1;

        while(root != null){

            if(root.data == key){
                floor = root.data;
                return floor;
            }

            if(key > root.data){
                floor = root.data;
                root = root.right;
            }

            else{
                root = root.left;
            }
        }

        return floor;
    }

    public int findCeil(TreeNode root, int key){
         int ceil = -1;

        while(root != null){

            if(root.data == key){
                ceil = root.data;
                return ceil;
            }

            if(key < root.data){
                ceil = root.data;
                root = root.left;
            }

            else {
                root = root.right;
            }
        }

        return ceil;
    }
}