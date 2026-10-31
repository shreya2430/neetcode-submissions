class Solution {
    public int rob(int[] nums) {
        //since u can't rob house 1st and last one
        // rob house from 0 to n-1 && 1 to n and check max
        int n= nums.length;
        if(n == 1){
            return nums[0];
        }
        if(n == 2){
            return Math.max(nums[0], nums[1]);
        }
        return Math.max(helper(nums, 0, n-1), helper(nums, 1, n));
    }
    private int helper(int[] nums, int s, int e){
        int len = e-s;
        int a = nums[s];
        int b = Math.max(nums[s], nums[s+1]);
        for(int i=2;i<len;i++){
            int c = Math.max(b, nums[i+s] + a);
            a = b;
            b = c;
        }
        return b;
    }
}
