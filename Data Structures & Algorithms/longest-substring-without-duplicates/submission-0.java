class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int left = 0, ans = 0;
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            while(left < i && set.contains(ch)){
                set.remove(s.charAt(left));
                left++;
            }
            set.add(ch);
            ans = Math.max(ans, set.size());
        }
        return ans;
    }
}
