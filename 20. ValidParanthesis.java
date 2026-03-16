import java.util.HashMap;
import java.util.Stack;

class Solution {
    public boolean isValid(String s) {
        HashMap<Character, Character> map = new HashMap<>();
        Stack<Character> stack = new Stack<>();
        map.put('[', ']');
        map.put('{', '}');
        map.put('(', ')');
        int len = s.length();
        if(s.charAt(0) == ']' || s.charAt(0) == ')' || s.charAt(0) == '}')
            return false;
        for(int i = 0; i<len; i++){
            if(s.charAt(i) == '[' || s.charAt(i) == '(' || s.charAt(i) == '{')
                stack.push(s.charAt(i));
            else{
                if(stack.isEmpty())
                    return false;
                char latest = map.get(stack.peek());
                if(latest == s.charAt(i)){
                    stack.pop();
                } else
                    return false;
            }
        }
        return stack.isEmpty();
    }
}