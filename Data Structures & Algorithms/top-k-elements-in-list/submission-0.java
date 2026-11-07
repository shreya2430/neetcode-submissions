class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int num : nums){
            map.put(num, map.getOrDefault(num,0)+1);
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> Integer.compare(map.get(a), map.get(b)));

        for(Integer num : map.keySet()){
            pq.offer(num);
            if(pq.size() > k){
                pq.poll();
            }
        }
        int[] res = new int[pq.size()];
        int idx=0;
        while(!pq.isEmpty()){
            res[idx++] = pq.poll();
        }
        return res;

    }
}
