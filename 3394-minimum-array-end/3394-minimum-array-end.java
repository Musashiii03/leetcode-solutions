class Solution {
    public long minEnd(int n, int x) {
        long ans = x;
        long temp = x;
        long k = n - 1;
        for(int i = 0; k > 0; i++){
            if(((temp >> i) & 1) == 0){
                ans |= (k & 1L) << i;
                k >>= 1;
            }
        }
        return ans;
    }
}