class Solution {
    private Set<Integer> set;
    private Set<Integer> visited;
    
    public int longestConsecutive(int[] nums) {
        if(nums.length == 0) return 0;

        set = new HashSet<>();
        visited = new HashSet<>();

        int maxL = 0;

        for(int num: nums)
            set.add(num);
        
        for(int num: set) {
            if(visited.contains(num)) continue;
            int count = 1;
            visited.add(num);

            int curr = num;
            while(set.contains(++curr)) {
                visited.add(curr);
                count++;
            }

            curr = num;
            while(set.contains(--curr)) {
                visited.add(curr);
                count++;
            }
            maxL = Math.max(maxL, count);
        }

        return maxL;
    }
}