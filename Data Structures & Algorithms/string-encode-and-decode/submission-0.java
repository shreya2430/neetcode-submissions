class Solution {

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for(String s : strs){
            sb.append(s.length()).append("#").append(s);
        }
        return sb.toString();
    }
// 5#Hello5#World
    public List<String> decode(String str) {
        int j=0,i=0;
        List<String> res = new ArrayList<>();
        while(j < str.length()){
            i=j;
            while(str.charAt(i) != '#'){
                i++;
            }
        int count = Integer.parseInt(str.substring(j, i));
        res.add(str.substring(i+1, count + i+1));
        j = count + i+1;
        }
        return res;
    }
}
