// class Solution {
//     public int trap(int[] block) {
//         if (block.length <= 2)
//             return 0;
//         int i = 0;
//         int currvol = 0;
//         int totvol = 0;
//         int l = block.length;
//         while(i<l-1 && block[i] < block[i+1]){
//             i++;
//         }
//         for(int j = i+1; j<l-1 ; j++){
            
//             currvol+=diff;
//             if(block[i] <= block[j+1]){
//                 i=j+1;
//                 totvol+=currvol;
//             }
//         }
//         return totvol;
//     }
// }
class Solution {
    public int trap(int[] block) {
        if (block.length <= 2)
            return 0;
        int i = 0;
        int totvol = 0;
        int l = block.length;
        while(i<l-1 && block[i] < block[i+1]){
            i++;
        }
        int j = l-1;
        int max_r = block[i];
        int max_l = block[j];

        while(i<j){
            // int curr_min = Math.min(max_r, max_l);
            if (max_r <= max_l){
                if(block[i+1] <= max_r)
                    totvol += max_r-block[i+1];
                else
                    max_r = block[i+1];
                i++;
            }
            else{
                if(block[j-1] <= max_l)
                    totvol += max_l-block[j-1];
                else
                    max_l = block[j-1];
                j--;
            }
        }
        return totvol;
    }
}