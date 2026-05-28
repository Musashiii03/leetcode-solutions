import java.util.HashMap;

class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0,1);
        int prefixSum = 0;
        int subArrays = 0;
        for(int i = 0; i < nums.length; i++){
            prefixSum += nums[i];
            subArrays += map.getOrDefault(prefixSum - k,0);
            if(map.containsKey(prefixSum))
                map.put(prefixSum, map.get(prefixSum)+1);
            else
                map.put(prefixSum, 1);
        }
        return subArrays;
    }
}