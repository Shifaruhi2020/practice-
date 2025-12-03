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
// solution link : https://www.youtube.com/watch?v=0ca1nvR0be4&list=PLgUwDviBIf0q8Hkd7bK2Bpryj2xVJk8Vk&index=21
// solution followed from chatGPT
class Solution {
    public List<Integer> boundaryOfBinaryTree(TreeNode root) 
    {
        List<Integer> result = new ArrayList<>();

        if(root == null) return result;

        // add root
        if(!isLeaf(root)){
            result.add(root.val);
        }

        // if not root 
        addLeftNode(root.left, result);

        addLeaf(root, result);

        addRightNode(root.right, result);

        return result;
    }

    public boolean isLeaf(TreeNode node){
        return node != null && node.left == null && node.right == null;
    }

    public void addLeftNode(TreeNode node, List<Integer> result){

        while(node != null){
            if(!isLeaf(node)) result.add(node.val);
            if(node.left != null) node = node.left;
            else node = node.right;
        }
    }

    public void addRightNode(TreeNode node, List<Integer> result){
        Stack<Integer> storeRightNode = new Stack<>();

        while(node != null){
            if(!isLeaf(node)) storeRightNode.push(node.val);

            if(node.right != null) node = node.right;

            else node = node.left;  
        }

        while(!storeRightNode.isEmpty()){
            result.add(storeRightNode.pop());
        }
    }

    public void addLeaf(TreeNode node, List<Integer> result){
        if(node == null) return;

        if(isLeaf(node)){
            result.add(node.val);
            return;
        }

        addLeaf(node.left, result);
        addLeaf(node.right, result);
    }

}