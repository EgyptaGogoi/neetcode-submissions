class Solution {
    public int[] dailyTemperatures(int[] temp) {
        Deque<Integer> stack = new ArrayDeque<>();
        int l = temp.length;
        int[] ans = new int[l];

        ans[l-1] = 0;
        stack.push(l-1);

        int i = l-2;
        while(i>=0){
            while(!stack.isEmpty() && temp[i]>=temp[stack.peek()])
                stack.pop();
            if(stack.isEmpty())
                ans[i]=0;
            else
                ans[i] = stack.peek()-i;
            stack.push(i);
            i--;
        }

        return ans;
    }
}