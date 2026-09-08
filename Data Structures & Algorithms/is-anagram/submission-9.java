class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length())
            return false;
        HashMap<Character,Integer> freq = new HashMap<>();
        for(char c: s.toCharArray()){
            freq.put(c, freq.getOrDefault(c, 0)+1);
        }
        for(char c: t.toCharArray()){
            freq.put(c, freq.getOrDefault(c, 0)-1);
        }
        for(Integer f : freq.values()){
            if(f!=0)
                return false;
        }
        return true;
    }
}
