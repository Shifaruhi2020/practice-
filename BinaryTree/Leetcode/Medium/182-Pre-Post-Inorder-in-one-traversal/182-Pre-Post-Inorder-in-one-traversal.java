// solution Link : https://www.youtube.com/watch?v=ySp2epYvgTE
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
        TreeNode root;
        int state;

        Pair(TreeNode root, int state){
            this.root = root;
            this.state = state;
        }
    }

    List<List<Integer>> treeTraversal(TreeNode root) {

        List<Integer> preorder = new ArrayList<>();
        List<Integer> inorder = new ArrayList<>();
        List<Integer> postorder = new ArrayList<>();

        if(root == null){
            return Arrays.asList(preorder, inorder, postorder);
        }

        Stack<Pair> st = new Stack<>();
        st.push(new Pair(root, 1));

        while(!st.isEmpty()){
            Pair cur = st.peek();

            if(cur.state == 1){
                preorder.add(cur.root.data);
                cur.state = 2;

                if(cur.root.left != null){
                    st.push(new Pair(cur.root.left, 1));
                }
            }

            else if(cur.state == 2){
                inorder.add(cur.root.data);
                cur.state = 3;

                if(cur.root.right != null){
                    st.push(new Pair(cur.root.right, 1));
                }
            }

            else{
                postorder.add(cur.root.data);
                st.pop();
            }
        }

        return Arrays.asList(preorder,inorder,postorder);
     }
}