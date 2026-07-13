class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length())
            return false;
        HashMap<Character, Integer> freqT = new HashMap<>();
        for (int i=0; i< t.length(); i++){
            freqT.put(t.charAt(i), freqT.getOrDefault(t.charAt(i), 0)+1);
        }
        for (int i=0; i< s.length(); i++){
            if (!freqT.containsKey(s.charAt(i)))
                return false;
            freqT.put(s.charAt(i), freqT.get(s.charAt(i)) -1);
            if(freqT.get(s.charAt(i)) < 0)
                return false;  
        }
        return true;
    }
}
