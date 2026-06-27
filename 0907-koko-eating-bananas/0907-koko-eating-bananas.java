class Solution {

    public long hoursTaken(int[] piles, int speed){
        long totalHours = 0;
        for(int i = 0; i < piles.length; i++)
            totalHours += Math.ceilDiv(piles[i], speed);
        return totalHours;
    }

    public int minEatingSpeed(int[] piles, int h) {
        int max = 0;
        for(int i = 0; i < piles.length; i++)
            max = Math.max(max, piles[i]);
        int low = 1;
        int high = max;
        int result = Integer.MAX_VALUE;
        while(low <= high){
            int mid = low + (high - low) / 2;
            long hours = hoursTaken(piles, mid);
            if(hours > h)
                low = mid + 1;
            else{
                high = mid - 1;
                result = Math.min(mid, result);
            }
        }
        return result;
    }
}