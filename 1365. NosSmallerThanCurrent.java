class Solution {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int len = nums.length;
        int[] output = new int[len];
        int count = 0;
        for(int i = 0; i < len; i++){
            for(int j = 0; j < len; j++){
                if(nums[j] < nums[i])
                    count++;
            }
            output[i] = count;
            count = 0;
        }
        return output;
    }
}