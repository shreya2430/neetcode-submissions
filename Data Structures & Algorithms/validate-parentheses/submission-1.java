class Solution {
    public boolean isValid(String s) {
        Deque<Character> st = new ArrayDeque<>();
        for(char ch : s.toCharArray()){
            if(ch == ']' || ch == ')' || ch == '}'){
                if(st.isEmpty()){
                    return false;
                }
                if(!isValidHelper(st.peek(), ch)){
                    return false;
                }
                st.pop();
            }else{
                st.push(ch);
            }
        }
        return st.isEmpty();
    }
    private boolean isValidHelper(char open, char close){
        if((open == '[' && close != ']') || 
           (open == '(' && close != ')') ||
           (open == '{' && close != '}')){
            return false;
           }
           return true;
    }
}
