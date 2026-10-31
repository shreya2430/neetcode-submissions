class Solution {
    public String foreignDictionary(String[] words) {
       //create a MAP
        //kahns algo -
        
        Map<Character, Set<Character>> wordsMap = new HashMap<>();
        Map<Character, Integer> indegree = new HashMap<>();

        for(String word : words){
            for(char ch : word.toCharArray()){
                wordsMap.putIfAbsent(ch, new HashSet<>());
                indegree.putIfAbsent(ch, 0);
            }
        }
        //built the map like adjMap a -> [b,c,d]
        for(int i=0;i<words.length-1;i++){
            String word1 = words[i], word2 = words[i+1];
            if(word1.length() > word2.length() && word1.startsWith(word2)){
                return "";
            }
            int len = Math.min(word1.length(), word2.length());
            for(int j=0;j<len;j++){
                char c1 = word1.charAt(j);
                char c2 = word2.charAt(j);

                if(c1 != c2){
                    if(wordsMap.get(c1).add(c2)){
                       indegree.put(c2, indegree.get(c2) + 1);
                    }
                    //as I get first non matching chars i know rules for those two chars, so break it;
                    break;
                }
            }
        }
        Deque<Character> q = new ArrayDeque<>();
        for(Character key : indegree.keySet()){
            if(indegree.get(key) == 0){
                q.offer(key);
            }
        }
        StringBuilder res = new StringBuilder();
        //traverse
        while(!q.isEmpty()){
            char curr = q.poll();
            res.append(curr);
            for(Character ch : wordsMap.get(curr)){
               indegree.put(ch, indegree.get(ch)-1);
               if(indegree.get(ch) <= 0){
                q.offer(ch);
               }
            }
        }
        return indegree.size() == res.length() ? res.toString() : "";
    }
}
