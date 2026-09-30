import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class Solution {
    public int equalPairs(int[][] grid) {
        HashMap<List<Integer>, Integer> map = new HashMap<>();
        for(int i = 0; i < grid.length; i++){
            List<Integer> current = new ArrayList<>();
            for(int j = 0; j < grid.length; j++)
                current.add(grid[j][i]);
            map.put(current, map.getOrDefault(current, 0)+1);
        }
        int result = 0;
        for(int i = 0; i < grid.length; i++){
            List<Integer> current = new ArrayList<>();
            for(int j = 0; j < grid.length; j++)
                current.add(grid[i][j]);
            if(map.containsKey(current))
                result += map.get(current);
        }
        return result;
    }
}