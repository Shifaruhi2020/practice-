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

    static class Pair{
    TreeNode node;
    int direction;

    Pair(TreeNode node, int direction){
        this.node = node;
        this.direction = direction;
    }
}


    public List<Integer> topView(TreeNode root) {

        Queue<Pair> q = new LinkedList<Pair>();

        TreeMap<Integer, Integer> map = new TreeMap<>();

        List<Integer> ans = new ArrayList<>();

        if(root == null) return ans;

        q.offer(new Pair(root, 0));

        while(!q.isEmpty()){

            Pair curr = q.poll();

            int node_direction = curr.direction;

            if(!map.containsKey(node_direction)){
                map.put(node_direction, curr.node.data);
            }

            if(curr.node.left != null){
                q.offer (new Pair(curr.node.left, node_direction - 1));
            }

            if(curr.node.right != null){
                q.offer (new Pair(curr.node.right, node_direction + 1));
            }
        }

        for(int nodes : map.values()){
            ans.add(nodes);
        }

        return ans;


    }   
}