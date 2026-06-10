import java.util.Stack;

class Solution {
    public String decodeString(String s) {
        Stack<Character> stack = new Stack<>();
        int len = s.length();

        for(int i = 0; i < len; i++){
            StringBuilder temp = new StringBuilder();

            if(Character.isLetterOrDigit(s.charAt(i)) || s.charAt(i) == '[')
                stack.push(s.charAt(i));

            if(s.charAt(i) == ']'){
                while(!(stack.peek() == '['))
                    temp.append(stack.pop());
                stack.pop();

                //int n = stack.pop() - '0';
                StringBuilder num = new StringBuilder();
                while(!stack.isEmpty() && Character.isDigit(stack.peek()))
                    num.append(stack.pop());
                num.reverse();
                int n = Integer.parseInt(num.toString());

                temp.reverse();
                String repeated = temp.toString().repeat(n);
                int repeatedLen = repeated.length();
                for(int j = 0; j < repeatedLen; j++)
                    stack.push(repeated.charAt(j));
            }
        }

        StringBuilder result = new StringBuilder();
        while(!stack.isEmpty())
            result.append(stack.pop());
        return result.reverse().toString();
    }
}