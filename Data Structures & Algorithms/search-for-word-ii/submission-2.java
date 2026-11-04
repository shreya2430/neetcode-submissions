class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        List<String> res = new ArrayList<>();
        Trie trie = new Trie();
        for(String word : words){
            trie.insert(word);
        }

        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[i].length;j++){
                dfs(board, i, j, trie.root, res);
            }
        }
        return res;
    }

    private void dfs(char[][] board, int i, int j, Node root, List<String> res){
        if(i<0 || i>= board.length || j<0 || j>= board[0].length || board[i][j] == '#'){
            return;
        }
        char ch = board[i][j];
        Node curr = root;
        if(curr.children[ch-'a'] == null){
            return;
        }
        curr = curr.children[ch-'a'];
        if(curr.word != null){
           res.add(curr.word);
           curr.word = null;
        }
        board[i][j] = '#';
        dfs(board, i+1, j, curr, res);
        dfs(board, i, j+1, curr, res);
        dfs(board, i-1, j, curr, res);
        dfs(board, i, j-1, curr, res);
        board[i][j] = ch;
    }
}
class Trie{
    Node root;
    Trie(){
        root = new Node();
    }

    public void insert(String word){
        Node curr = root;
        for(char ch : word.toCharArray()){
            if(curr.children[ch-'a'] == null){
                curr.children[ch-'a'] = new Node();
            }
            curr = curr.children[ch-'a'];
        }
        curr.word = word;
    }
}
class Node{
    Node[] children;
    String word;

    Node(){
        children = new Node[26];
        this.word = null;
    }
}
