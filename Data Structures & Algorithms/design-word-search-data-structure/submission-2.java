class WordDictionary {
    Node root;
    public WordDictionary() {
        root = new Node();
    }

    public void addWord(String word) {
        Node curr = root;
        for(char ch : word.toCharArray()){
            if(curr.children[ch-'a'] == null){
                curr.children[ch-'a'] = new Node();
            }
            curr = curr.children[ch-'a'];
        }
        curr.endOfWord = true;
    }

    public boolean search(String word) {
        return dfs(word, 0, root);
    }

    private boolean dfs(String word, int idx, Node root){
        if(idx >= word.length()){
            return root.endOfWord;
        }
        Node curr = root;
        char ch = word.charAt(idx);
        if(ch == '.'){
            for(Node child : curr.children){
                if(child != null && dfs(word, idx+1, child)){
                    return true;
                }
            }
            return false;
        }
        if(curr.children[ch-'a'] == null){
            return false;
        }
        curr = curr.children[ch-'a'];
        return dfs(word, idx+1, curr);
    }
}
class Node{
    Node[] children;
    boolean endOfWord;

    Node(){
        this.children = new Node[26];
        this.endOfWord = false;
    }
}