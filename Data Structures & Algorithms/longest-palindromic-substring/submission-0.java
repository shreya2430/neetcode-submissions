class Solution {
    int start = 0;
    int len = 0;
    public String longestPalindrome(String s) {
        for(int i=0;i<s.length();i++){
            helper(s, i, i); // odd
            helper(s, i, i+1); // even
        }
        return s.substring(start,  start + len);
    }
    private void helper(String s, int l, int r){
        while(l>= 0 && r<s.length() && s.charAt(l) == s.charAt(r)){
            if(r - l + 1 > len){
                start = l;
                len = r - l + 1;
            }
            l--;
            r++;
        }
    }
}
/**
abbc

*/