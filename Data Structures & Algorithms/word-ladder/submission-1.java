class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> set = new HashSet<>(wordList);
        if(!wordList.contains(endWord) || beginWord.equals(endWord)){
            return 0;
        }
        set.remove(beginWord);
        Deque<String> q = new ArrayDeque<>();
        q.offer(beginWord);
        int steps = 1;
        while(!q.isEmpty()){
            int len = q.size();
            for(int l =0;l<len;l++){
            char[] curr = q.poll().toCharArray();
            for(int i=0;i<curr.length;i++){
                char temp = curr[i];
                for(char c='a';c<='z';c++){
                    if(c == temp){
                        continue;
                    }
                    curr[i] = c;
                    String next = new String(curr);
                    if(next.equals(endWord)){
                        return 1 + steps;
                    }
                    if(set.remove(next)){
                        q.offer(next);
                    }
                }
                curr[i] = temp;
              }
            }
            steps++;
        }
        return 0;
    }
}
