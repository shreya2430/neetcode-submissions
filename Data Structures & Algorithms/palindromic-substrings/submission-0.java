class Solution {
    public int countSubstrings(String s) {
        int count = 0;
        for(int i=0;i<s.length();i++){
            count += expand(s, i, i);  // for odd
            count += expand(s, i, i+1); // even
        }
        return count;
    }
    private int expand(String s, int l, int r){
        int c = 0;
        while(l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)){
            c++;
            l--;
            r++;
        }
        return c;
    }
}
/*
odd and even
aba && abba
*/