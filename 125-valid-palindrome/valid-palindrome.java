class Solution {
    public boolean isPalindrome(String s) {
        // if (s.length() == 1)
        //     return true;
        s = s.toLowerCase();
        s = s.replaceAll("[^a-zA-Z0-9]","");
        char [] char_arr = s.toCharArray();
        int i = 0;
        int j = s.length()-1;
        while(i<j){
            if(char_arr[i] != char_arr[j])
                return false;
            i++;
            j--;
        }
        return true;
    }
}