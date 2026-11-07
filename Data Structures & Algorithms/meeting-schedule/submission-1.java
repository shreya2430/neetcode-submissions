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

//(5 10), (15, 20), (0, 30); 
class Solution {
    public boolean canAttendMeetings(List<Interval> intervals) {
        if(intervals.size() <= 1){
            return true;
        }
        intervals.sort((a,b) -> Integer.compare(a.end, b.end));

        Interval curr = intervals.get(0);
        for(int i=1;i<intervals.size();i++){
            Interval interval = intervals.get(i);
            if(curr.end > interval.start){
                return false;
            }else{
                curr = interval;
            }
        }
        return true;

    }
}
