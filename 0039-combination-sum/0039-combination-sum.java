import java.util.ArrayList;
import java.util.List;

class Solution {

    List<List<Integer>> result = new ArrayList<>();

    public void backtrack(int[] candidates, int target, List<Integer> current, int i, int currentSum){
        if(currentSum == target){
            if(!result.contains(current))
                result.add(new ArrayList<>(current));
            return;
        }
        if(i == candidates.length || currentSum > target)
            return;
        if(currentSum < target){
            current.add(candidates[i]);
            currentSum += candidates[i];
            backtrack(candidates, target, current, i, currentSum);
            current.removeLast();
            currentSum -= candidates[i];
            backtrack(candidates, target, current, i + 1, currentSum);
        }   
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<Integer> current = new ArrayList<>();
        backtrack(candidates, target, current, 0, 0);
        return result;
    }
}