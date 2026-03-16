import java.util.Stack;

class Solution {
    public int calPoints(String[] operations) {
        Stack<String> stack = new Stack<>();
        int len = operations.length;
        for(int i = 0; i < len; i++){
            if(Character.isDigit(operations[i].charAt(operations[i].length()-1)))
                stack.push(operations[i]);
            else if(operations[i].equals("C"))
                stack.pop();
            else if(operations[i].equals("D")){
                int num = Integer.parseInt(stack.peek());
                int d = 2*num;
                stack.push(Integer.toString(d));
            } else {
                int num1 = Integer.parseInt(stack.get(stack.size()-1));
                int num2 = Integer.parseInt(stack.get(stack.size()-2));
                int sum = num1+num2;
                stack.push(Integer.toString(sum));
            }
        }
        int size = stack.size();
        int sum = 0;
        for(int i = 0; i < size; i++){
            if(!stack.empty()){
                sum += Integer.parseInt(stack.peek());
                stack.pop();
            }
        }
        return sum;
    }
}