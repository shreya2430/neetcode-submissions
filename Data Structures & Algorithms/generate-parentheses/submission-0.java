class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        dfs(n, 0, 0, new StringBuilder(), res);
        return res;
    }
    void dfs(int n, int openP, int closeP, StringBuilder sb ,List<String> res){
        if(openP > n || closeP > n){
            return;
        }
        if(openP == n && closeP == n){
            res.add(new String(sb.toString()));
            return;
        }
        if(openP < n){
             dfs(n, openP+1, closeP, sb.append('('), res);
             sb.deleteCharAt(sb.length()-1);
        }
        if(closeP < openP){
             dfs(n, openP, closeP+1, sb.append(')'), res);
             sb.deleteCharAt(sb.length()-1);
        }
        
    }
}
