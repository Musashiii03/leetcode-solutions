class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int p1 = 0;
        int count = 0;
        int maxCount = 0;
        while(p1 < nums.length){
            if(nums[p1] == 1){
                count++;
                if (count > maxCount)
                    maxCount = count;
            }
            else
                count = 0;
            p1++;
        }
        return maxCount;
    }
} 