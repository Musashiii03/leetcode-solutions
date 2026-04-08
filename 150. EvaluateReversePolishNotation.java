import java.util.Stack;

class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < tokens.length; i++){
            if(!tokens[i].equals("+") && !tokens[i].equals("/") && !tokens[i].equals("*") && !tokens[i].equals("-")){
                stack.push(Integer.parseInt(tokens[i]));
            } else {
                int a = stack.pop();
                int b = stack.pop();
                if(tokens[i].equals("+")) {stack.push(b + a);}
                if(tokens[i].equals("-")) {stack.push(b - a);}
                if(tokens[i].equals("*")) {stack.push(b * a);}
                if(tokens[i].equals("/")) {stack.push(b / a);}
            }
        }
        return stack.peek();
    }
}