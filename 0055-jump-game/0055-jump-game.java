class Solution {
    public boolean canJump(int[] nums) {
        int lastIndex = nums.length - 1;
        int farthestReachable = 0;
        for(int i = 0; i < lastIndex; i++){
            if(farthestReachable < i)
                return false;
            farthestReachable = Math.max(i + nums[i], farthestReachable);
        }
        return (farthestReachable >= lastIndex);
    }
}