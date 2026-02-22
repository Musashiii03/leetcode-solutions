// Better Soluntion with o(n) time complexity and o(n) space complexity

/* import java.util.HashMap;

class Solution {
    public int majorityElement(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            if(!map.containsKey(nums[i]))
                map.put(nums[i], 1);
            else
                map.put(nums[i], map.get(nums[i])+1);
            if(map.get(nums[i]) > (nums.length/2))
                return nums[i];
        }
        return 0;
    }
} */

// Optimal Solution with o(n) time complexity & O(1) space complexity
class Solution {
    public int majorityElement(int[] nums) {
        int count = 0;
        int element = 0;
        for (int i = 0; i < nums.length; i++){
            if(count == 0){
                count = 1;
                element = nums[i];
            } else if(nums[i] == element)
                count++;
            else
                count--;
        }
        return element;
    }
}