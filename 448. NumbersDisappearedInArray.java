import java.util.List;
import java.util.ArrayList;

class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> output = new ArrayList<>();
        for(int i = 0; i < nums.length; i++){
            int value = Math.abs(nums[i]);
            int index = value-1;
            nums[index] = -Math.abs(nums[index]);
        }
        for(int i = 0; i < nums.length; i++){
            if(nums[i] > 0){
                int val = i+1;
                output.add(val);
            }
        }
        return output;
    }
}