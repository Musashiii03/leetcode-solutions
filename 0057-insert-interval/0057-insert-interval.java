import java.util.ArrayList;

class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {

        if(intervals.length == 0)
            return new int[][] {newInterval};

        ArrayList<int[]> result = new ArrayList<>();
        int i = 0;

        // Adding all intervals smaller than newInterval
        while(i < intervals.length && intervals[i][0] < newInterval[0]){
            result.add(intervals[i]);
            i++;
        }


        while(i < intervals.length && intervals[i][0] <= newInterval[1]){
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }

        if(result.isEmpty()){
            result.add(newInterval);
        } else {
            int[] first = result.get(result.size() - 1);
            if(newInterval[0] <= first[1]){
                result.removeLast();
                result.add(new int[] {first[0], Math.max(first[1], newInterval[1])});
            } else {
                result.add(newInterval);
            }
        }

        while(i < intervals.length){
            result.add(intervals[i]);
            i++;
        }

        return result.toArray(new int[0][]);
    }
}