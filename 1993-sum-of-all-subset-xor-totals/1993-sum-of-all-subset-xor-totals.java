class Solution {

    public int traverse(int[] nums, int i, int total){
        if(i == nums.length)
            return total;
        return traverse(nums, i + 1, total ^ nums[i]) + traverse(nums, i + 1, total);
    }

    public int subsetXORSum(int[] nums) {
        return traverse(nums, 0, 0);
    }
}