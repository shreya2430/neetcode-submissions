class Solution {
    public boolean isPalindrome(String s) {
        int st = 0, e = s.length()-1;
        while(e >= st){
            while(e >= st && !Character.isLetterOrDigit(s.charAt(st))){
                st++;
            }
            while(e >= st && !Character.isLetterOrDigit(s.charAt(e))){
                e--;
            }
            if(e >= st && Character.toLowerCase(s.charAt(st)) != Character.toLowerCase(s.charAt(e))){
                return false;
            }
            st++;
            e--;
        }
        return true;
    }
}
