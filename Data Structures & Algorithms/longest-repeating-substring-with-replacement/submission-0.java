class Solution {
    public int characterReplacement(String s, int k) {
      int[] freq = new int[26];
      int maxFreq = 0;
      int i=0,j=0;
      int ans = 0;
      while(j < s.length()){
        freq[s.charAt(j) - 'A']++;
        maxFreq = Math.max(freq[s.charAt(j) - 'A'], maxFreq);
        //curLen - maxfreq > k
        while(j-i+1 - maxFreq > k){
            freq[s.charAt(i) - 'A']--;
            i++;
        }
        ans = Math.max(ans, j-i+1);
        j++;
      }
      return ans;
    }
}
