class Solution {
    public int maxArea(int[] height) {
        int volume = 0;
        int i = 0;
        int j = height.length-1;
        while(i < j){
            volume = Math.max(volume, (Math.min(height[i], height[j]) * (j-i)));
            if(height[i] <= height[j])
                i++;
            else
                j--;
        }
        return volume;
    }
}