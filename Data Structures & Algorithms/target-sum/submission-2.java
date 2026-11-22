class Solution {
    Map<String, Integer> cache;
    public int findTargetSumWays(int[] nums, int target) {
      int sum = 0;
      cache = new HashMap<>();
      for(int num : nums){
        sum += num;
      }
      if(Math.abs(target) > sum || (sum-target)%2 != 0){
        return 0;
      }
      return dfs(nums, 0, 0, target);
    }
    private int dfs(int[] nums, int idx, int sum, int target){
      if(idx == nums.length){
        return sum == target ? 1 : 0;
      }
      String key = String.valueOf(sum + "," + idx);
      if(cache.containsKey(key)){
        return cache.get(key);
      }
      int plus = dfs(nums, idx+1, sum+nums[idx], target);
      int minus = dfs(nums, idx+1, sum-nums[idx], target);
      cache.put(key, plus+minus);
      return plus + minus;
    }
}
