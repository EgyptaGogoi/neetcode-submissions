class Solution {

    public String encode(List<String> strs) {
        if (strs.size() == 0)
            return "";
        String ans = new String("");
        for(String ele: strs){
            char[] chr = ele.toCharArray();
            ans += (char)chr.length;
            ans += '#';
            ans += ele;
        }
        return ans;
    }

    public List<String> decode(String str) {
        if (str.length() == 0)
            return new ArrayList<>(List.of(""));
        List<String> ans = new ArrayList();
        int l = 0;
        while(l<str.length()){
            int len = str.charAt(l);
            l+=2;
            ans.add(str.substring(l,l+len));
            l+=len;
        }
        return ans;
    }
}
