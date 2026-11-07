class Solution {
    public String minWindow(String s, String t) {
         Map<Character, Integer> tMap = new HashMap<>();
        for(char c : t.toCharArray()){
            tMap.put(c, tMap.getOrDefault(c, 0) + 1);
        }
        int unique = tMap.size();
        Map<Character, Integer> sMap = new HashMap<>();
        int j=0, i=0;
        int formed = 0;
        int start = 0, end = 0;
        int len =  Integer.MAX_VALUE;

        while(j < s.length()){
            char ch = s.charAt(j);
            sMap.put(ch, sMap.getOrDefault(ch, 0) + 1);
            if(tMap.containsKey(ch) && sMap.get(ch).intValue() == tMap.get(ch).intValue()){
                formed++;
            }
            while(formed == unique){
                int currLen = j-i;
                if(currLen < len){
                    len = currLen;
                    end = j;
                    start = i;
                }
                char left = s.charAt(i);
                sMap.put(left, sMap.get(left)-1);
                if(tMap.containsKey(left) && sMap.get(left).intValue() < tMap.get(left).intValue()){
                    formed--;
                }
                i++;
            }
            j++;
        }
        // System.out.println(start + " " + end);
        return len != Integer.MAX_VALUE ? s.substring(start, end+1) : "";
    }
}
