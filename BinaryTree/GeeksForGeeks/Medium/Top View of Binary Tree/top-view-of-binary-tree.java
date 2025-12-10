/*
class Node {
    int data;
    Node left, right;

    Node(int val) {
        this.data = val;
        this.left = null;
        this.right = null;
    }
}
*/
class Solution {
    
    static class Pair{
        Node node;
        int hd;
        Pair(Node n,int  h){
            this.node = n;
            this.hd = h;
        }
    }
    
    public ArrayList<Integer> topView(Node root) {
        ArrayList<Integer> result = new ArrayList<>();
        
        if(root == null) return result;
        
        HashMap<Integer, Integer> map = new HashMap<>();
        ArrayDeque<Pair> q = new ArrayDeque<>();
        
        q.offer(new Pair(root, 0));
        
        while(!q.isEmpty()){
            Pair qpair = q.poll();
            Node qnode = qpair.node;
            int hd = qpair.hd;
            
            if(!map.containsKey(hd)){
                map.put(hd, qnode.data);
            }
            
            if(qnode.left != null) {
                q.offer(new Pair(qnode.left, hd -1 ));
            }
            
            if(qnode.right != null){
                q.offer(new Pair(qnode.right, hd + 1));
            }
        }
        
        ArrayList<Integer> keys = new ArrayList<>(map.keySet());
        Collections.sort(keys);
        
        for(int k : keys){
            result.add(map.get(k));
        }
        
        return result;
        
    }
}