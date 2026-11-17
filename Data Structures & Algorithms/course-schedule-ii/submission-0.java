class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<Integer>[] adjList = new List[numCourses];
        int[] inDegree = new int[numCourses];

        for(int i=0;i<numCourses;i++){
            adjList[i] = new ArrayList<>();
        }
        for(int[] course : prerequisites){
            int u = course[0];
            int v = course[1];
            adjList[v].add(u);
            inDegree[u]++;
        }
        Deque<Integer> q = new ArrayDeque<>();
        for(int i=0;i<numCourses;i++){
            if(inDegree[i] == 0){
                q.offer(i);
            }
        }
        int[] res = new int[numCourses];
        int idx = 0;
        while(!q.isEmpty()){
            int completedCourse = q.poll();
            res[idx++] = completedCourse;
            for(Integer curr : adjList[completedCourse]){
                inDegree[curr]--;
                if(inDegree[curr] == 0){
                    q.offer(curr);
                }
            }
        }
        return idx == numCourses ? res : new int[0];
    }
}
