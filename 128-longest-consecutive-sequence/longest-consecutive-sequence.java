class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> hs = new HashSet<>();

        //store in hs
        for(int i =0; i<nums.length; i++)
            hs.add(nums[i]);

        int maxC = 0;
        for(int n: hs){
            if(!hs.contains(n-1)){
                int currC = 1;
                while(hs.contains(n+currC))
                    currC++;
                maxC = Math.max(currC, maxC);
            }
        }
        return maxC;
    }
}