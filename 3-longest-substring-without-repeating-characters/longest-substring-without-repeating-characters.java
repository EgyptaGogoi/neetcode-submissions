class Solution {
    public int lengthOfLongestSubstring(String s) {
        int[] visited = new int [128];
        int maxC = 0;
        int currC = 0;
        int i =0;
        int j =0;
        while(j < s.length()){
            char c = s.charAt(j);
            visited[c]++;
            while(visited[c]>1){             
                char k = s.charAt(i);
                visited[k]--;
                i++;
            }
            maxC = Math.max(maxC, j-i+1);
            j++;
        }
        return maxC;
    }
}