class PrefixTree {
    Node root;
    public PrefixTree() {
         root = new Node();
    }

    public void insert(String word) {
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
        Node curr = root;
        for(char ch : word.toCharArray()){
            if(curr.children[ch-'a'] == null){
                return false;
            }
            curr = curr.children[ch-'a'];
        }
        return curr.endOfWord;
    }

    public boolean startsWith(String prefix) {
        Node curr = root;
        for(char ch : prefix.toCharArray()){
            if(curr.children[ch-'a'] == null){
                return false;
            }
            curr = curr.children[ch-'a'];
        }
        return true;
    }
}
class Node{
    Node[] children;
    boolean endOfWord;

    Node(){
        this.children = new Node[26];
    }
}
