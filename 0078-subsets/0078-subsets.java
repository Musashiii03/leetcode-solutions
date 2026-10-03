import java.util.ArrayList;
import java.util.List;

class Solution {

    List<List<Integer>> result = new ArrayList<>();
    List<Integer> current = new ArrayList<>();

    public void backtrack(int[] nums, int i, List<Integer> current){
        if(i == nums.length){
            result.add(new ArrayList<>(current));
            return;
        }
        current.add(nums[i]);
        backtrack(nums, i + 1, current);
        current.removeLast();
        backtrack(nums, i + 1, current);
    }
    
    public List<List<Integer>> subsets(int[] nums) {
        backtrack(nums, 0, current);
        return result;
    }
}