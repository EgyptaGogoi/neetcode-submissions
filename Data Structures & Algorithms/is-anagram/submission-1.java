class Solution {
    public boolean isAnagram(String s, String t) {
        HashMap<Character, Integer> freqT = new HashMap<>();
        HashMap<Character, Integer> freqS = new HashMap<>();
        for (int i=0; i< t.length(); i++){
            freqT.put(t.charAt(i), freqT.getOrDefault(t.charAt(i), 0)+1);
        }
        for (int i=0; i< s.length(); i++){
            freqS.put(s.charAt(i), freqS.getOrDefault(s.charAt(i), 0)+1);
        }
        for (Character key : freqT.keySet()) {
            if (freqS.get(key) != freqT.get(key))
                return false;
        }
        return true;
    }
}
