class Solution {
    public int longestConsecutive(int[] nums) {
        HashMap<Integer,Integer> hm = new HashMap<>();

        //store in hm
        for(int i =0; i<nums.length; i++)
            hm.put(nums[i], i);
        HashSet<Integer> visited = new HashSet<>();
        int maxC = 0;
        for(int i =0; i<nums.length; i++){
            if(visited.contains(nums[i]))
                continue;

            int currC = 1;
            int next = nums[i];
            
            while(hm.containsKey(next+1)){
                visited.add(next); 
                currC++;
                next+=1;
            }

            next = nums[i];
            while(hm.containsKey(next-1)){
                visited.add(next); 
                currC++;
                next-=1;
            }
              
            maxC = Math.max(currC, maxC);
        }
        return maxC;
    }
}