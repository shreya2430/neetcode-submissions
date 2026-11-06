class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int num : nums){
            set.add(num);
        }
        int ans = 0;
        for(Integer num : set){
            if(!set.contains(num-1)){
                int count = 0;
                while(set.contains(num)){
                    count++;
                    num = num+1;
                }
                ans = Math.max(ans, count);
            }
        }
        return ans;
    }
}
