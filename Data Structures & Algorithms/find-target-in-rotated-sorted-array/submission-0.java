class Solution {
    public int search(int[] nums, int target) {
        int n = nums.length;
        int beg = 0, end = n-1;
        while(end >= beg){
            int mid = beg + (end-beg)/2;
            if(nums[mid] == target){
                return mid;
            }
            //right part is sorted
            else if(nums[mid] < nums[end]){
                if(nums[mid] < target && target <= nums[end]){
                    beg = mid+1;
                }else{
                    end = mid-1;
                }
            }
            //left part is sorted
            else{
                if(target >= nums[beg] && target < nums[mid]){
                    end = mid-1;
                }else{
                    beg = mid+1;
                }
            }
        }
        return -1;
    }
}
