import java.util.Stack;

class Solution {
    public int calculate(String s) {
        class Node{
            int result;
            int sign;
            Node(int result, int sign){
                this.result = result;
                this.sign = sign;
            }
        }
        Stack<Node> stack = new Stack<>();
        int result = 0;
        int sign = 1;
        int num = 0;
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            if(ch == ' ')
                continue;
            else if(ch == '('){
                stack.push(new Node(result, sign));
                result = 0;
                sign = 1;
            } else if(ch == ')'){
                result += sign * num;
                num = 0;
                Node current = stack.pop();
                result = current.result + current.sign * result;
            } else if(ch == '+'){
                result += sign * num;
                num = 0;
                sign = 1;
            } else if(ch == '-'){
                result += sign * num;
                num = 0;
                sign = -1;
            } else{
                num = num * 10 + (ch - '0');
            }
        }
        result += sign * num;

        return result;
    }
}