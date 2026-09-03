class Solution {
    public int longestOnes(int[] nums, int k) {

        int left = 0;
        int right = 0;
        int noOfZeroesUsed = 0;
        int maxOnes = 0;

        while(right < nums.length){
            if(nums[right] == 0)
                noOfZeroesUsed++;
            if(noOfZeroesUsed > k){
                if(nums[left] == 0)
                    noOfZeroesUsed--;
                left++;
            }
            maxOnes = Math.max(maxOnes, (right - left)+1);
            right++;
        }

        return maxOnes;
    }
}