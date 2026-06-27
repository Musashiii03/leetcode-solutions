class Solution {

    public long daysTaken(int[] weights, int capacity){
        long days = 1;
        int i = 0;
        int currentLoad = 0;
        while(i < weights.length){
            if(weights[i] + currentLoad <= capacity)
                currentLoad += weights[i];
            else{
                days += 1;
                currentLoad = weights[i];
            }
            i++;
        }
        return days;
    }

    public int shipWithinDays(int[] weights, int days) {
        int max = 0;
        int sum = 0;
        for(int i = 0; i < weights.length; i++){
            max = Math.max(max, weights[i]);
            sum += weights[i];
        }
        int low = max;
        int high = sum;
        int result = Integer.MAX_VALUE;
        while(low <= high){
            int mid = low + (high - low) / 2;
            long daysTaking = daysTaken(weights, mid);
            if(daysTaking > days)
                low = mid + 1;
            else{
                high = mid - 1;
                result = Math.min(mid, result);
            }
        }
        return result;
    }
}