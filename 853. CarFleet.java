import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;

class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        HashMap<Integer, Double> map = new HashMap<>();
        Stack<Double> stack = new Stack<>();

        for(int i = 0; i < position.length; i++)
            map.put(position[i],(double)(target - position[i]) / speed[i]);

        Arrays.sort(position);
        int start = 0;
        int end = position.length - 1;
        while (start < end) {
            int temp = position[start];
            position[start] = position[end];
            position[end] = temp;
            start++;
            end--;
        }

        for(int i = 0; i < position.length; i++){
            if(stack.isEmpty() || map.get(position[i]) > stack.peek())
                stack.push(map.get(position[i]));
        }

        return stack.size();
    }
}