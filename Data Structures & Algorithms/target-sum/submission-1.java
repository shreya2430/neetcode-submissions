class Solution {
    Map<String, Integer> cache;
    public int findTargetSumWays(int[] nums, int target) {
        cache = new HashMap<>();
        return dfs(nums, 0, 0, target);
    }
    private int dfs(int[] nums, int idx, int sum, int target){
        if(idx == nums.length){
            return sum == target ? 1 : 0;
        }
        String key = String.valueOf(idx + " " + sum);
        if(cache.containsKey(key)){
            return cache.get(key);
        }
        int plus = dfs(nums, idx+1, sum+nums[idx], target);
        int minus = dfs(nums, idx+1, sum-nums[idx], target);
        cache.put(key, plus + minus);
        return plus + minus;
    }
}
