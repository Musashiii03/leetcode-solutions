import java.util.HashMap;

class Solution {
    public int maxOperations(int[] nums, int k) {
        
        HashMap<Integer, Integer> map = new HashMap<>();
        int count = 0;

        for(int i = 0; i < nums.length; i++)
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);

        for(int i = 0; i < nums.length; i++){
            int comp = k - nums[i];
            if(nums[i] == comp && map.get(comp) < 2)
                continue;
            if(map.containsKey(comp) && map.get(comp) > 0 && map.get(nums[i]) > 0){
                count++;
                map.put(comp, map.get(comp) - 1);
                map.put(nums[i], map.get(nums[i]) - 1);
            }
        }

        return count;
    }
}