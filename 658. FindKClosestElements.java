import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {

        int low = 0;
        int high = arr.length - 1;
        while(low <= high){
            int mid = (low + high) /2;
            if(arr[mid] >= x)
                high = mid - 1;
            else 
                low = mid + 1;
        }

        int position = low;
        int left = position - 1;
        int right = position;
        int windowSize = right - left - 1;

        while(windowSize != k){
            if(left < 0){
                right++;
                windowSize++;
            } else if (right >= arr.length){
                left--;
                windowSize++;
            } else {
                if(Math.abs(x - arr[left]) <= Math.abs(arr[right] - x)){
                    left--;
                    windowSize++;
                } else {
                    right++;
                    windowSize++;
                }
            }
        }

        List<Integer> list = new ArrayList<>();
        for(int i = left + 1; i < right; i++)
            list.add(arr[i]);

        return list;
    }
}