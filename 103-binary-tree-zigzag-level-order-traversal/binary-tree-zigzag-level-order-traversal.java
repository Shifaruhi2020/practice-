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
//  link for solution : https://www.youtube.com/watch?v=3OXWEdlIGl4&list=PLgUwDviBIf0q8Hkd7bK2Bpryj2xVJk8Vk&index=20
// Solution explaination in chatGPT
class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();

        if(root == null) return result;

        ArrayDeque<TreeNode> nodeQueue = new ArrayDeque<>();
        nodeQueue.offer(root);

        boolean lefttoRight = true;

        while(!nodeQueue.isEmpty()){
            int size = nodeQueue.size();
            ArrayList<Integer> level = new ArrayList<>();
            
            for(int i = 0 ; i < size; i++){
                TreeNode node = nodeQueue.poll();
                level.add(node.val);

                if(node.left != null) nodeQueue.offer(node.left);
                if(node.right != null) nodeQueue.offer(node.right);

            }

            if(!lefttoRight){
                Collections.reverse(level);
            }

            result.add(level);
            lefttoRight = !lefttoRight;
            }
        
        return result;
    }
}