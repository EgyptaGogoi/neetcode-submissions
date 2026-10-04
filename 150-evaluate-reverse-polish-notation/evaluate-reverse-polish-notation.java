class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> ans = new Stack<>();
        for (int i = 0; i < tokens.length; i++){
            String ch = tokens[i];
            if (!ch.equals("+") && !ch.equals("-") &&
    !ch.equals("*") && !ch.equals("/")){
                ans.push(Integer.parseInt(ch));
            }
            else{
                int a = ans.pop();
                int b = ans.pop();
                if(ch.equals("+"))
                    ans.push(a+b);
                if(ch.equals("-"))
                    ans.push(b - a);
                if(ch.equals("*"))
                    ans.push(a*b);
                if(ch.equals("/")){
                    ans.push(b/a);
                }
            }
        }
        return ans.pop();
        
    }
}