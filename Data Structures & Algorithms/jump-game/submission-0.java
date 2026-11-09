class Solution {
    public boolean canJump(int[] nums) {
        int far = 0;
        for(int i=0;i<=far;i++){
            far = Math.max(far, i + nums[i]);
            if(far >= nums.length-1){
                return true;
            }
        }
        return false;
    }
}
/**
dp[T ]
*/