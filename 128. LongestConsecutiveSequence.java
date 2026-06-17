import java.util.HashSet;

class Solution {
    public int longestConsecutive(int[] nums) {
        
        HashSet<Integer> set = new HashSet<>();
        for(int i = 0; i < nums.length; i++)
            set.add(nums[i]);

        int maxElements = 0;
        for (int num : set){
            if(!set.contains(num - 1)){
                int currentNum = num;
                int currentLength = 1;

                while(set.contains(currentNum + 1)){
                    currentNum++;
                    currentLength++;
                }

                maxElements = Math.max(maxElements, currentLength);
            }
        }

        return maxElements;
    }
}