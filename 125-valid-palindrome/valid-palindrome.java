class Solution {
    public boolean isPalindrome(String s) {
        if (s.length() == 1)
            return true;
        s = s.toLowerCase().replaceAll("[^a-z0-9]", "");

        int i = 0;
        int j = s.length() - 1;
        while(i<j){
            if(s.charAt(i) != s.charAt(j))
                return false;
            // if(arr[i] != arr[j])
            i++;
            j--;
        }
        return true;
    }
}