class Solution {
    public int[] productExceptSelf(int[] nums) {
          int n = nums.length;
        int[] output = new int[n];
        int p = 1;
        for(int i=0;i<n;i++){
            output[i] = p;
            p = p * nums[i];
        }
        p = 1;
        for(int i=n-1;i>=0;i--){
            output[i] *= p;
            p = p * nums[i];
        }
        return output;
    }
}  
