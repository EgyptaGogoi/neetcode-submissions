class Solution {
    public String minWindow(String s, String t) {
        if (s.length() < t.length())
            return "";

        HashMap<Character, Integer> tMap = new HashMap<>();
        HashMap<Character, Integer> sMap = new HashMap<>();;
        
        for(int k =0; k<t.length(); k++){
            char ch = t.charAt(k);
            tMap.put(ch, tMap.getOrDefault(ch,0)+1);
        }
        int min = Integer.MAX_VALUE;
        int smli = 0;
        int count = 0;
        int i =0;
        int j =0;

        while(j<s.length()){
            char ch = s.charAt(j);
            sMap.put(ch, sMap.getOrDefault(ch,0)+1);
            
            if(tMap.containsKey(ch)&& sMap.get(ch)<=tMap.get(ch))
                count++;

            while(count == t.length()){
                if(j - i + 1 < min){
                    min = j - i + 1;
                    smli = i;
                }

                char left = s.charAt(i);
                if(tMap.containsKey(left)&& sMap.get(left)<=tMap.get(left))
                    count--;
                sMap.put(left,sMap.get(left)-1);
                i++;

            }
            j++;
        }
        if (min == Integer.MAX_VALUE)
            return "";
        return s.substring(smli, smli+min);
    }
}