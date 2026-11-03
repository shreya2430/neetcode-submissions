class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        backtracking(nums, target, 0, new ArrayList<>(), res);
        return res;
    }
    private void backtracking(int[] nums, int target, int idx, List<Integer> l,  List<List<Integer>> res){

        if(target < 0){
            return;
        }
        if(target == 0){
            res.add(new ArrayList<>(l));
            return;
        }
        for(int i=idx;i<nums.length;i++){
            if(nums[i] > target){
                continue;
            }
            l.add(nums[i]);
            backtracking(nums, target-nums[i], i, l, res);
            l.remove(l.size()-1);
        }
    }
}
