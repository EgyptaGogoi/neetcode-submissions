class Solution {
    public String sortString(String s){
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }
    public List<List<String>> groupAnagrams(String[] strs) {
        // if (strs.length <=1)
        //     return List.of(List.of(strs));
        HashSet<String> hs = new HashSet<>();
        List<List<String>> ans = new ArrayList<>();
        List<String> temp = new ArrayList<>();
        for(String ele : strs){
            String sorted_ele = sortString(ele);
            hs.add(sorted_ele);
        }
        for(String unq : hs){
            for(String ele : strs){
                String sorted_ele = sortString(ele);
                if(unq.equals(sorted_ele))
                    temp.add(ele);
            }
             ans.add(new ArrayList<>(temp));
            temp.clear();
        }
        return ans;
    }
}

// act = [act, cat]
// opst = [pots, tops, stop]
// aht = [har]
