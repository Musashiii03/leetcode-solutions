import java.util.HashMap;

class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        if(nums.length == 1)
            return false;
        int sum = 0;
        map.put(0, -1);
        for(int i = 0; i < nums.length; i++){
            sum += nums[i];
            int remainder = sum % k;
            if (map.containsKey(remainder) && (i - map.get(remainder) >= 2))
                return true;
            map.putIfAbsent(remainder, i);
        }
        return false;
    }
}