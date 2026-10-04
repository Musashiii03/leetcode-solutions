import java.util.ArrayList;
import java.util.List;

class Solution {

    List<List<Integer>> result = new ArrayList<>();

    public void backtrack(int k, int n, int i, List<Integer> current, int currentSum){
        if(currentSum == n && current.size() == k){
            if(!result.contains(current))
                result.add(new ArrayList<>(current));
            return;
        }
        if(current.size() > k || currentSum > n || i > 9)
            return;
        if(current.size() < k && currentSum < n && i <= 9){
            current.add(i);
            currentSum += i;
            backtrack(k, n, i + 1, current, currentSum);
            current.removeLast();
            currentSum -= i;
            backtrack(k, n, i + 1, current, currentSum);
        }
    }

    public List<List<Integer>> combinationSum3(int k, int n) {
        List<Integer> current = new ArrayList<>();
        backtrack(k, n, 1, current, 0);
        return result;
    }
}