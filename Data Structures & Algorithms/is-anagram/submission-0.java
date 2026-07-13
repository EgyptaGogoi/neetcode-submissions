class Solution {
    public boolean isAnagram(String s, String t) {
        HashMap<Character, Integer> freqT = new HashMap<>();
        for (int i=0; i< t.length(); i++){
            freqT.put(t.charAt(i), freqT.getOrDefault(t.charAt(i), 0)+1);
        }
        for (int i=0; i< s.length(); i++){
            if(!freqT.containsKey(s.charAt(i)))
                return false;
        }
        return true;
    }
}
