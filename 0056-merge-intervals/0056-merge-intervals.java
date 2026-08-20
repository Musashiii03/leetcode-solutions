import java.util.ArrayList;
import java.util.Arrays;

class Solution {
    public int[][] merge(int[][] intervals) {
        ArrayList<int[]> result = new ArrayList<>();
        Arrays.sort(intervals, (a,b) -> a[0] - b[0]);
        result.add(intervals[0]);
        for(int i = 1; i < intervals.length; i++){
            int[] first = result.get(result.size() - 1);
            int[] second = intervals[i];
            if(first[1] >= second[0]){
                result.removeLast();
                result.add(new int[] {first[0], Math.max(first[1], second[1])});
            } else
                result.add(second);
        }
        
        return result.toArray(new int [0][]);
    }
}