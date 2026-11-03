class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<Integer>[] adjList = new List[numCourses];
        int[] indegree = new int[numCourses];

        for(int i=0;i<numCourses;i++){
            adjList[i] = new ArrayList<>();
        }
        for(int[] course : prerequisites){
            int u = course[0];
            int v = course[1];

            adjList[v].add(u);
            indegree[u]++;
        }
        Deque<Integer> courseOrder = new ArrayDeque<>();
        for(int i=0;i<numCourses;i++){
            if(indegree[i] == 0){
                courseOrder.offer(i);
            }
        }
        int count = 0;
        while(!courseOrder.isEmpty()){
            count++;
            Integer currCourse = courseOrder.poll();
            for(Integer c : adjList[currCourse]){
                indegree[c]--;
                if(indegree[c] == 0){
                    courseOrder.offer(c);
                }
            }
        }
        return count == numCourses;
    }
}
