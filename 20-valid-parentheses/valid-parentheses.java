class Solution {
    public boolean isValid(String s) {
        if(s.length()%2 == 1)
            return false;
        Set<Character> set = new HashSet<>();
        set.add('(');
        set.add('[');
        set.add('{');
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i< s.length(); i++){
            char ch = s.charAt(i);
            if (set.contains(ch))
                stack.add(ch);
            else {
                if (stack.isEmpty())
                    return false;
                if(((stack.peek() == '(' && ch == ')')||
                (stack.peek() == '[' && ch == ']') ||
                (stack.peek() == '{' && ch == '}')))
                    stack.pop();
                else
                    return false;
            }
        }
        return stack.isEmpty();
    }
}