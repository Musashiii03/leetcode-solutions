class Solution {
    public int longestSubarray(int[] nums) {
        int zeroes = 0;
        int left = 0;
        int right = 0;
        int maxNoOfOnes = 0;
        while(right < nums.length){
            if(nums[right] == 0)
                zeroes++;
            while(zeroes > 1){
                if(nums[left] == 0)
                    zeroes--;
                left++;
            }
            maxNoOfOnes = Math.max(maxNoOfOnes, (right- left));
            right++;
        }
        return maxNoOfOnes;
    }
}