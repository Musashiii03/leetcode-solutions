import java.util.Stack;

class Solution {
    public String simplifyPath(String path) {
        int start = 1;
        Stack<String> stack = new Stack<>();
        for(int i = 1; i <= path.length(); i++){
            if(i == path.length() || path.charAt(i) == '/'){
                if(start < i){
                    String token = path.substring(start, i);
                    if(token.equals("..")){
                        if(stack.empty()){}
                        else{stack.pop();}
                    }
                    else if(token.equals(".")){}
                    else 
                        stack.push(token);
                }
                start = i + 1;
            }
        }
        StringBuilder output = new StringBuilder();
        if(stack.empty()){
            output.append('/');
            return output.toString();
        } else {
            int i = 0;
            while(i < stack.size()){
                output.append('/');
                output.append(stack.get(i));
                i++;
            }
        }
        return output.toString();
    }
}