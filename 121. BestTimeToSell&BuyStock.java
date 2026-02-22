class Solution {
    public int maxProfit(int[] prices) {
        int lowVal = prices[0];
        int profit = 0;
        for(int i = 1; i < prices.length; i++){
            if(prices[i]<lowVal)
                lowVal = prices[i];
            else {
                profit = Math.max(profit, prices[i]-lowVal);
            }
        }
        return profit;
    }
}