import java.util.ArrayList;
import java.util.Arrays;

class Solution {
    public int findMinArrowShots(int[][] points) {
        ArrayList<int[]> result = new ArrayList<>();
        Arrays.sort(points, (a, b) -> Integer.compare(a[1], b[1]));
        result.add(points[0]);
        for(int i = 1; i < points.length; i++){
            int[] previous = result.get(result.size() - 1);
            int[] current = points[i];
            if(!(current[0] <= previous[1])){
                result.add(current);
            }
        }
        return result.size();
    }
}