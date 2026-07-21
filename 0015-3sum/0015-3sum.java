import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

class Solution {

    public static void quickSort(int arr[], int start, int end){
        if(end <= start)
            return;
        int pivot = partition(arr, start, end);
        quickSort(arr, start, pivot-1);
        quickSort(arr, pivot+1, end);
    }

    public static int partition(int arr[], int start, int end){
        int pivot = arr[end];
        int i = start-1;
        for(int j = start; j < end; j++){
            if(arr[j] < pivot){
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        i++;
        int temp = arr[i];
        arr[i] = arr[end];
        arr[end] = temp;

        return i;
    }

    public List<List<Integer>> threeSum(int[] nums) {
        quickSort(nums, 0, nums.length-1);
        List<List<Integer>> result = new ArrayList<>();
        for(int i = 0; i < nums.length; i++){
            if(i > 0 && nums[i-1] == nums[i])
                continue;
            int j = i+1;
            int k = nums.length-1;
            while(j < k){
                if(nums[j] + nums[k] < -nums[i])
                    j++;
                else if(nums[j] + nums[k] > -nums[i])
                    k--;
                else{
                    result.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    j++;
                    k--;
                    while(j < k && nums[j-1] == nums[j])
                        j++;
                    while(j < k && nums[k+1] == nums[k])
                        k--;
                }
            }
        }
        return result;
    }
}