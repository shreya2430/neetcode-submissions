class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for(String s : strs){
            char[] ch = s.toCharArray();
            Arrays.sort(ch);
            String newS = Arrays.toString(ch);
            map.computeIfAbsent(newS, k -> new ArrayList<>()).add(s);
        }
        return new ArrayList<>(map.values());
    }
}
