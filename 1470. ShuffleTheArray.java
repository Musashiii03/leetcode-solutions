class Solution {
    public int[] shuffle(int[] nums, int n) {
        int[] output = new int[2*n];
        int p1 = 0;
        int p2 = 0;
        while(p1 < n){
            output[p2] = nums[p1];
            output[p2+1] = nums[p1+n];
            p1++;
            p2 += 2;
        }
        return output;
    }
}