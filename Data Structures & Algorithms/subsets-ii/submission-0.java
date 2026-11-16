class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        res = new ArrayList<>();
        Arrays.sort(nums);
        helper(nums, 0, new ArrayList<>());
        return res;
    }
    private void helper(int[] nums, int idx, List<Integer> currList){
        res.add(new ArrayList<>(currList));
        for(int i=idx;i<nums.length;i++){
            if(i > idx && nums[i] == nums[i-1]){
                continue;
            }
            currList.add(nums[i]);
            helper(nums, i+1, currList);
            currList.remove(currList.size()-1);
        }
    }
}
