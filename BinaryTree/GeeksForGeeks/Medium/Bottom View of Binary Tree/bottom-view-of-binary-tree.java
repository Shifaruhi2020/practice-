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
    static class Pair{
        Node node;
        int hd;//hd stands for horizontal distance
        Pair(Node n, int hd){
            this.node = n;
            this.hd = hd;
        }
    }
    public ArrayList<Integer> bottomView(Node root) {
        // code here
        ArrayDeque<Pair> q = new ArrayDeque<>();
        // map<hd, node.data>
        HashMap<Integer, Integer> map = new HashMap<>();
        ArrayList<Integer> ans = new ArrayList<>();  
        
        if(root == null) return ans;
        
        q.offer(new Pair(root, 0));
        
        while(!q.isEmpty()){
            Pair qpair = q.poll();
            Node qnode = qpair.node;
            int qhd = qpair.hd;
            
            map.put(qhd, qnode.data);
            
            if(qnode.left != null) q.offer(new Pair(qnode.left, qhd - 1));
            
            if(qnode.right != null) q.offer(new Pair(qnode.right, qhd + 1));
        }
        
        ArrayList<Integer> keys = new ArrayList<>(map.keySet());
        Collections.sort(keys);
        
        for(int k : keys){
            ans.add(map.get(k));
        }
        
        return ans;
    }
}