class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> hm = new HashMap<>();
        for (String ele : strs){
            char[] arr = ele.toCharArray();
            Arrays.sort(arr);
            String key = new String(arr);

            if(!hm.containsKey(key)){
                hm.put(key, new ArrayList<>());
            }
            hm.get(key).add(ele);
        }
        return new ArrayList<>(hm.values());
    }
}
