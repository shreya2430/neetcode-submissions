class Solution {
    public int climbStairs(int n) {
        if(n == 1){
            return 1;
        }
        int oneStair = 1;
        int twoStairs = 2;
        for(int i=2;i<n;i++){
            int currCounts = oneStair + twoStairs;
            oneStair = twoStairs;
            twoStairs = currCounts;
        }
        return twoStairs;
    }
}
