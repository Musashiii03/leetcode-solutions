class Solution {
    public int removeDuplicates(int[] nums) {
        int count = 1;
        int totalCount = 1;
        int p1 = 0;
        int p2 = 1;
        while(p1 <= nums.length-1 && p2 <= nums.length-1){
            if(nums[p1] == nums[p2] && count < 2){
                p1 = p2;
                p2 += 1;
                count += 1;
                totalCount += 1;
                nums[totalCount - 1] = nums[p1];
            } else if(nums[p1] == nums[p2] && count == 2){
                p2 += 1;
            } else {
                p1 = p2;
                p2 += 1;
                count = 1;
                totalCount += 1;
                nums[totalCount - 1] = nums[p1];
            }
        }
        return totalCount;      
    }
}