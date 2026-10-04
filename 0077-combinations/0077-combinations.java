import java.util.ArrayList;
import java.util.List;

class Solution {

    List<List<Integer>> result = new ArrayList<>();

    public void backtrack(int n, int k, List<Integer> current, int i){
        if(current.size() == k){
            result.add(new ArrayList<>(current));
            return;
        }
        if(current.size() > k || i > n)
            return;

        current.add(i);
        backtrack(n, k, current, i + 1);
        current.removeLast();
        backtrack(n, k, current, i + 1);
    }

    public List<List<Integer>> combine(int n, int k) {
        List<Integer> current = new ArrayList<>();
        backtrack(n, k, current, 1);
        return result;
    }
}