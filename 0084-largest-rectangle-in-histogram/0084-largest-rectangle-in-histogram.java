import java.util.Stack;

class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int area = 0;
        int width = 0;
        for(int i = 0; i < heights.length; i++){
            while(!stack.empty() && heights[stack.peek()] >= heights[i]){
                int popped = stack.pop();
                int height = heights[popped];
                if(stack.empty())
                    width = i;
                else
                    width = i - stack.peek() - 1;
                area = Math.max(area, height * width);
            }
            stack.push(i);
        }
        while(!stack.empty()){
            int popped = stack.pop();
                int height = heights[popped];
                if(stack.empty())
                    width = heights.length;
                else
                    width = heights.length - stack.peek() - 1;
                area = Math.max(area, height * width);
        }
        return area;
    }
}