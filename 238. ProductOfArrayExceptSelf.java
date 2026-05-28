class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] answers = new int[nums.length];
        int prefix = 1;
        int suffix = 1;
        for(int i = 0; i < nums.length; i++){
            if(i == 0){
                answers[i] = prefix;
                continue;
            }
            prefix = prefix * nums[i-1];
            answers[i] = prefix * suffix;
        }
        for(int i = nums.length-1; i >= 0; i--){
            answers[i] = answers[i] * suffix;
            suffix = suffix * nums[i];
        }
        return answers;
    }
}