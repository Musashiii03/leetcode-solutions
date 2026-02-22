import java.util.HashMap;

class Solution {
    public boolean containsDuplicate(int[] nums) {
        boolean dup = false;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<nums.length; i++){
            if(map.containsKey(nums[i]))
                dup = true;
            map.put(nums[i], i);
        }
        return (dup);
    }
}