class Solution {
    public int getMaxFreq(int[] arr){
        int max = 0;
        for(int i: arr){
            if (max < i)
                max = i;
        }
        return max;
    }
    public int characterReplacement(String s, int k) {
        int[] freq = new int[26];
        int i = 0;
        int j = 0;
        int maxlen = 0;
        int maxfreq = 0;
        while(j< s.length()){
            freq[s.charAt(j)-'A']++;
            maxfreq = Math.max(maxfreq, freq[s.charAt(j)-'A']);
            while(j-i+1 - getMaxFreq(freq) > k){
                freq[s.charAt(i)-'A']--;
                i++;
            }
            maxlen = Math.max((j-i+1), maxlen);
            j++;
        }
        return maxlen;
    }
}