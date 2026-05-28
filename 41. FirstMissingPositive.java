class Solution {
    public int firstMissingPositive(int[] nums) {
        for(int i = 0; i < nums.length; i++){
            while(nums[i] > 0 && nums[i] <= nums.length && nums[nums[i]-1] != nums[i]){
                int temp1 = nums[i] - 1;
                int temp = nums[i];
                nums[i] = nums[temp1];
                nums[temp1] = temp;
            }
        }       

        for(int i = 0; i < nums.length; i++){
            if(i+1 != nums[i])
                return i+1;
        }
        return nums.length + 1;
    }
}