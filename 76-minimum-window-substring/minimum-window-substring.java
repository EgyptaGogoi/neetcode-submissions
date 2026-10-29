class Solution {
    public String minWindow(String s, String t) {
        int m = s.length();
        int n = t.length();
        if(m<n)
            return "";
        HashMap<Character,Integer> ht = new HashMap<>();
        for(int i = 0; i<n; i++)
            ht.put(t.charAt(i), ht.getOrDefault(t.charAt(i),0)+1);

        HashMap<Character,Integer> hs = new HashMap<>();
        int i = 0;
        int j = 0;
        int count = 0;
        int st = 0;
        int minLen = Integer.MAX_VALUE;
        while(j<m){
            char c = s.charAt(j);
            hs.put(c, hs.getOrDefault(c,0)+1);

            if(ht.containsKey(c)&& hs.get(c)<=ht.get(c))
                count++;

            while (count == n){
                if(j - i + 1 < minLen){
                    minLen = j - i + 1;
                    st = i;
                }
                
                char temp = s.charAt(i);
                if(ht.containsKey(temp) && hs.get(temp) <= ht.get(temp)){
                    count--;
                }
                i++;
                hs.put(temp, hs.get(temp)-1);
            }     

            j++;
        }
        if(minLen == Integer.MAX_VALUE )
            return "";
        return s.substring(st, st+minLen);
    }
}