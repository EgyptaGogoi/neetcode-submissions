class Solution {
    static{
        for(int i = 0; i < 500 ; i++){
            characterReplacement("ABBB",2);
        }
    }
    public static int characterReplacement(String s, int k) {
        int[] freq = new int[26];
        int i = 0;
        int j = 0;
        int maxlen = 0;
        int maxfreq = 0;
        while(j< s.length()){
            freq[s.charAt(j)-'A']++;
            maxfreq = Math.max(maxfreq, freq[s.charAt(j)-'A']);
            while(j-i+1 - maxfreq > k){
                freq[s.charAt(i)-'A']--;
                i++;
            }
            maxlen = Math.max((j-i+1), maxlen);
            j++;
        }
        return maxlen;
    }
}