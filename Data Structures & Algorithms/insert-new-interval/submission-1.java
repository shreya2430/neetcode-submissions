class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        //loop new interval to right place
        //merge any overlapping interval
        // put rest of element in ans;

        List<int[]> res = new ArrayList<>();
        int n = intervals.length;

        int i=0;
        while(i < n && intervals[i][1] < newInterval[0]){
            res.add(intervals[i]);
            i++;
        }
//[1, 5]
        while(i < n && intervals[i][0] <= newInterval[1]){
            newInterval[0] = Math.min(intervals[i][0], newInterval[0]);
            newInterval[1] = Math.max(intervals[i][1], newInterval[1]);
            i++;
        }

        res.add(newInterval);

        while(i< n){
            res.add(intervals[i]);
            i++;
        }
        return res.toArray(new int[res.size()][]);

    }
}
