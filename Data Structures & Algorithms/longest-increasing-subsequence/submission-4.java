class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] tail = new int[n];
        int size = 0;

        for(int i=0;i<nums.length;i++){
            if(size == 0 || nums[i] > tail[size-1]){
                tail[size] = nums[i];
                size++;
            }else{
                int idx = findPos(tail, nums[i], size);
                tail[idx] = nums[i];
            }
        }
        return size;
    }
    private int findPos(int[] nums, int target, int n){
        int start = 0, end = n-1;
        while(end > start){
            int mid = start + (end - start)/2;
            if(nums[mid] < target){
                start = mid+1;
            }else{
                end = mid;
            }
        }
        return start;
    }
}
/**
nums=[4,10,4,3,8,9]
tail = [4 10 ]
s = 1, e =1, mid = 0 target = 4
*/

