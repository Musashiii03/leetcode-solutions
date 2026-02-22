class Solution {
    public int maxSubArray(int[] nums) {
        int sum = 0;
        for(int i = 0; i < nums.length; i++){
            if(sum+nums[i] > sum){
                sum = sum + nums[i];
            }
        }
        return sum;
    }
}