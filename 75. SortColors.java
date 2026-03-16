class Solution{

    public static void quickSort(int nums[], int start, int end){
        if(start >= end)
            return;
        int pivot = partition(nums, start, end);
        quickSort(nums, start, pivot-1);
        quickSort(nums, pivot+1, end);
    }

    public static int partition(int nums[], int start, int end){
        int pivot = nums[end];
        int i = start-1;
        for(int j = start; j < end; j++){
            if(nums[j] < pivot){
                i++;
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            }
        }

        i++;
        int temp = nums[i];
        nums[i] = nums[end];
        nums[end] = temp;

        return i;
    }

    public int[] sortColors(int[] nums) {
        int len = nums.length;
        quickSort(nums, 0, len-1);
        return nums;    
    }
}