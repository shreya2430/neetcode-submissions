class Solution {
    public int maxProduct(int[] nums) {
              int maxP = nums[0], minP = nums[0], ans = nums[0];
        for(int i=1;i<nums.length;i++){
            int prevMax = maxP; //-2
            maxP = Math.max(nums[i], Math.max(maxP * nums[i], minP * nums[i])); //-2
            minP = Math.min(nums[i], Math.min(prevMax * nums[i], minP * nums[i])); //-12
            ans = Math.max(ans, maxP);
        }
        return ans;
    }
}
