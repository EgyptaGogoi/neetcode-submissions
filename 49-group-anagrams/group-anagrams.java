class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,List<String>> hm = new HashMap<>();
        for (int i =0; i<strs.length; i++){
            char []str = strs[i].toCharArray();
            Arrays.sort(str);
            String newStr = new String(str);
            
            hm.computeIfAbsent(newStr, k -> new ArrayList<>()).add(strs[i]);
        }
        return new ArrayList<>(hm.values());
    }
}