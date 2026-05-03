import java.util.Stack;

class Solution {
    public String decodeString(String s) {
        Stack<String> stack = new Stack<>();
        int n = 0;
        for(int i = 0; i < s.length(); i++){
            if(Character.isDigit(s.charAt(i)))
                n = s.charAt(i) - '0';
            else if(s.charAt(i) == '['){
                while(s.charAt(i) != )
            }
        }
    }
}