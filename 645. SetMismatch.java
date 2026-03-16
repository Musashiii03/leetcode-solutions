import java.util.HashMap;

class Solution {
    public int[] findErrorNums(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            if(map.containsKey(nums[i]))
                map.put(nums[i],map.get(nums[i])+1);
            else
                map.put(nums[i], 1);
        }
        int missing = 0;
        int duplicate = 0;
        for(int i = 0; i <= nums.length; i++){
            if(!map.containsKey(i))
                missing = i;
            else if(map.get(i) == 2)
                duplicate = i;
        }
        return new int[] {duplicate, missing};
    }
}