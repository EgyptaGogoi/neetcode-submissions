class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,List<String>> hm = new HashMap<>();

        for(int i = 0; i < strs.length; i++){
            char[] sort_str = strs[i].toCharArray();
            Arrays.sort(sort_str);
            String ss = new String(sort_str);

            hm.computeIfAbsent(ss, k -> new ArrayList<>()).add(strs[i]);
        }
        return new ArrayList<>(hm.values());
    }
}