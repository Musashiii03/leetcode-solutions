import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class Solution {

    Stack<Character> stack = new Stack<>();
    List<String> result = new ArrayList<>();

    public void backtrack(int n, int openCount, int closedCount){
        
        if(n == openCount && openCount == closedCount){
            StringBuilder string = new StringBuilder();
            for(char c : stack)
                string.append(c);
            result.add(string.toString());
        }

        if(openCount < n){
            stack.push('(');
            backtrack(n, openCount + 1, closedCount);
            stack.pop();
        }

        if(closedCount < openCount){
            stack.push(')');
            backtrack(n, openCount, closedCount + 1);
            stack.pop();
        }
    }
    
    public List<String> generateParenthesis(int n) {
        backtrack(n, 0, 0);
        return result;
    }
}