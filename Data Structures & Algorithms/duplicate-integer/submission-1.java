class Solution {
    public boolean hasDuplicate(int[] nums) {
        Hashtable<Integer, Integer> freq = new Hashtable<>();
        for(int ele: nums){
            if (freq.containsKey(ele) == true)
                return true;
            freq.put(ele,1);
        }
        return false;
    }
}