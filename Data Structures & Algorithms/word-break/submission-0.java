class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Node root = new Node();

        for(String word : wordDict){
            Node curr = root;
            for(char ch : word.toCharArray()){
                if(curr.children[ch-'a'] == null){
                    curr.children[ch-'a'] = new Node();
                }
                curr = curr.children[ch-'a'];
            }
            curr.endOfWord = true;
        }
        int n = s.length();
        boolean[] dp = new boolean[n+1];
        dp[0] = true;

        for(int i=0;i<n;i++){
            if(!dp[i]){
                continue;
            }
            Node curr = root;
            for(int j=i;j<n;j++){
                char ch = s.charAt(j);
                if(curr.children[ch-'a'] == null){
                    break;
                }
                curr = curr.children[ch-'a'];
                if(curr.endOfWord){
                    dp[j+1] = true;
                } 
            }
        }
        return dp[n];
    }
}
class Node{
    Node[] children;
    boolean endOfWord;

    Node(){
        this.children = new Node[26];
    }
}
/**
wordDict = ["neet","code"]
[. . . . . . n . . . ]
n->e->e->t(true)->s
dp[n+1]
dp[0] = true
dp[4] = true;
dp[8] = true

return dp[n];
*/