class Solution {
    public int removeDuplicates(int[] nums) {
        int p1 = 0;
        int p2 = 1;
        int count = 1;
        while(p2<nums.length){
            if (nums[p2] != nums[p1]){
                nums[count] = nums[p2];
                count += 1;
                p1 = p2;
                p2 = p1 + 1;
            } else {
                p2++;
            }
        }
        return count;       
    }
}