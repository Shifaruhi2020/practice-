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
    public ArrayList<Integer> leftView(Node root) {
        // code here
        ArrayList<Integer> ans = new ArrayList<>();
        LeftSideView(root, ans, 0);
        return ans; 
    }
    
    static void LeftSideView(Node node, List<Integer> ans, int level){
        if(node == null) return;

        if(level == ans.size()){
            ans.add(node.data);
        }

        LeftSideView(node.left, ans, level + 1);
        LeftSideView(node.right, ans, level + 1);
    }
}