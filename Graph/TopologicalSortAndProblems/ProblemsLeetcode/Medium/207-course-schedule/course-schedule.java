// solution link : https://www.youtube.com/watch?v=WAOfKpxYHR8&feature=youtu.be
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int n = prerequisites.length;

        List<List<Integer>> adj = new ArrayList<>();

        for(int i = 0; i < numCourses; i++){
            adj.add(new ArrayList<>());
        }

        for(int i = 0; i < n; i++){
            int a = prerequisites[i][0];
            int b = prerequisites[i][1];

            adj.get(b).add(a);
        }

        int[] indegree = new int[numCourses];

        Queue<Integer> q = new LinkedList<>();

        for(int i = 0; i < numCourses; i++){
            for(int neighbour: adj.get(i)){
                indegree[neighbour]++;
            }
        }

        for(int i = 0; i < indegree.length; i++){
            if(indegree[i] == 0){
                q.add(i);
            }
        }

        int count = 0;
        while(!q.isEmpty()){
            int node = q.poll();
            count++;
            
            for(int neighbour : adj.get(node)){
                indegree[neighbour]--;
                if(indegree[neighbour] == 0){
                    q.add(neighbour);
                }
            }
        } 

        if(count != numCourses) return false;

        return true;    
    }
}