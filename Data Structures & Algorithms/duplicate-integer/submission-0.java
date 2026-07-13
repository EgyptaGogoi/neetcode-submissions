class Solution {
    public boolean hasDuplicate(int[] nums) {
        HashMap<Integer, Integer> freq = new HashMap<>();
        for(int ele: nums){
            if (freq.getOrDefault(ele, 0) == 1)
                return true;
            freq.put(ele, freq.getOrDefault(ele, 0)+1);
        }
        return false;
    }
}