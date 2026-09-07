class Solution {
    public int lengthOfLongestSubstring(String s) {
        int l = 0;
        int r = 0;
        int mlen = 0;
        HashSet<Character> set = new HashSet<>();
        while(r<s.length()){
            if (!set.contains(s.charAt(r))){
                set.add(s.charAt(r));
            }
            else{
                int currlen = (r - l);
                if(mlen < currlen)
                    mlen = currlen;
                while(l<r && set.contains(s.charAt(r)))
                    set.remove(s.charAt(l++));
                set.add(s.charAt(r));
            }
            r++;
        }
        if (l<r && mlen < (r-l))
            mlen = r-l;
        return mlen;
    }
}