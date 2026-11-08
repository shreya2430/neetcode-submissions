/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public int minMeetingRooms(List<Interval> intervals) {
        int n = intervals.size();
        int[] start = new int[n];
        int[] end = new int[n];
        int idx = 0;

        for(Interval interval : intervals){
            start[idx] = interval.start;
            end[idx] = interval.end;
            idx++;
        }

        Arrays.sort(start);
        Arrays.sort(end);
        idx = 0;
        int rooms = 0;

        for(int i=0;i<n;i++){
            if(start[i] < end[idx]){
                rooms++;
            }else{
                idx++;
            }
        }
        return rooms;
    }
}

//0  5  15
//10 20 40 
