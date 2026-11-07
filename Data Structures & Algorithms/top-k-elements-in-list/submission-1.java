class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int num : nums){
            map.put(num, map.getOrDefault(num,0)+1);
        }
        int n = nums.length;
        List<Integer>[] bucket = new ArrayList[n+1];
        for(Integer i : map.keySet()){
            int freq = map.get(i);
            if(bucket[freq] == null){
                bucket[freq] = new ArrayList<>();
            }
            bucket[freq].add(i);
        }
        int idx = 0;
        int[] res = new int[k];
        for(int i = n;i >= 0 && idx < k;i--){
            if(bucket[i] != null){
                for(Integer num : bucket[i]){
                    res[idx++] = num;
                    if(idx >= k){
                        break;
                    }
                }
            }
        }
        return res;
    }
}