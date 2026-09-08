class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length())
            return false;
        HashMap<Character,Integer> freq_s = new HashMap<>();
        HashMap<Character,Integer> freq_t = new HashMap<>();
        for(char c: s.toCharArray()){
            freq_s.put(c, freq_s.getOrDefault(c, 0)+1);
        }
        for(char c: t.toCharArray()){
            freq_t.put(c, freq_t.getOrDefault(c, 0)+1);
        }
        for(Character key : freq_s.keySet()){
            if(!freq_s.get(key).equals(freq_t.get(key)))
                return false;
        }
        return true;
    }
}
