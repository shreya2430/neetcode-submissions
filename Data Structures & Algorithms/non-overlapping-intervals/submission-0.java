class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a,b) -> Integer.compare(a[1], b[1]));

        int[] curr = intervals[0];
        int ans = 0;
        for(int i=1;i<intervals.length;i++){
            int[] interval = intervals[i];
            if(curr[1] > interval[0]){
                ans++;
            }else{
                curr = interval;
            }
        }
        return ans;
    }
}
