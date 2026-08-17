class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int tank = 0;
        int currentStation = 0;
        int totalGas = 0, totalCost = 0;
        for(int i = 0; i < gas.length; i++){
            totalCost += cost[i];
            totalGas += gas[i];
        }
        if(totalGas < totalCost)
            return -1;
        else{
            for(int i = 0; i < gas.length; i++){
                tank += gas[i];
                tank -= cost[i];
                if(tank < 0){
                    tank = 0;
                    currentStation = i + 1;
                }
            }
        }
        return currentStation;
    }
}