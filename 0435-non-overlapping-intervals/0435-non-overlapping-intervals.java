import java.util.Arrays;

class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        int countOfRemovedIntervals = 0;
        Arrays.sort(intervals, (a,b) -> a[1] - b[1]);
        int[] previous = intervals[0];
        for(int i = 1; i < intervals.length; i++){
            int[] current = intervals[i];
            if(current[0] < previous[1])
                countOfRemovedIntervals++;
            else
                previous = current;
        }
        return countOfRemovedIntervals;
    }
}