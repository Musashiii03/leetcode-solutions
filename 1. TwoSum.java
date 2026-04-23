import java.util.HashMap;

class Solution{
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i<nums.length; i++){
            int complement = target-nums[i];
            if(map.containsKey(complement)){
                int j = map.get(complement);
                return new int[] {i, j};
            }
            map.put(nums[i], i);
        }
        return new int[] {-1, -1};
    }
}

/*
class Solution{
    public int[] twoSum(int[] nums, int target) {
        for(int i = 0; i < nums.length; i++){
            for(int j = i+1; j < nums.length; j++){
                if(target == nums[i]+nums[j]){
                    return new int[] {i,j};
                }
            }
        }
        return new int[] {};
    }
}
*/