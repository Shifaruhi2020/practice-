/*
class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}
*/
// solution link : https://www.youtube.com/watch?v=0FtVY6I4pB8&list=PLgUwDviBIf0q8Hkd7bK2Bpryj2xVJk8Vk&index=24
class Solution {
    
    class Pair{
        TreeNode node;
        int level;

        Pair(TreeNode node, int level){
            this.node = node;
            this.level = level;
        }
    }

    public List<Integer> bottomView(TreeNode root) {
        //your code goes here
        Queue<Pair> q = new LinkedList<>();

        TreeMap<Integer, Integer> map = new TreeMap<>();

        List<Integer> ans = new ArrayList<>();

        if(root == null) return ans;

        q.offer(new Pair(root, 0));

        while(!q.isEmpty()){

            Pair cur = q.poll();

            TreeNode curnode = cur.node;

            int level = cur.level;

            if(curnode.left != null){
                q.offer(new Pair(curnode.left, level - 1));
            }

            if(curnode.right != null){
                q.offer(new Pair(curnode.right, level + 1));  
            }

            map.put(level, curnode.data);
        }

        for(int nodes : map.values()){
            ans.add(nodes);
        }

        return ans;
    }
}