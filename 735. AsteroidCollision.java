import java.util.Stack;

class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < asteroids.length; i++){
            boolean alive = true;
            if(asteroids[i]>0)
                stack.push(asteroids[i]);
            else{
                while(!stack.empty() && stack.peek() > 0){
                    if(stack.peek() > Math.abs(asteroids[i])){
                        alive = false;
                        break;
                    } else if(stack.peek() == Math.abs(asteroids[i])){
                        stack.pop();
                        alive = false;
                        break;
                    } else {
                        stack.pop();
                    }
                }
                if(alive == true)
                    stack.push(asteroids[i]);
            }
        }
        int[] output = new int[stack.size()];
        int i = stack.size() - 1;
        while(!stack.empty()){
            output[i] = stack.pop();
            i--;
        }
        return output;
    }
}