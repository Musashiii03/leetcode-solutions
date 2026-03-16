/*  Quick Sort Implementation but Time Limit Exceeded

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

    public int[] sortArray(int[] nums) {
        int len = nums.length;
        quickSort(nums, 0, len-1);
        return nums;    
    }
}
*/

class Solution{

    public static void mergeSort(int[] array){
        int length = array.length;
        if (length <= 1)
            return;
        int middle = length/2;
        int[] leftArray = new int[middle];
        int[] rightArray = new int[length - middle];
        int i = 0, j = 0;
        for(; i < length; i++){
            if(i < middle)
                leftArray[i] = array[i];
            else{
                rightArray[j] = array[i];
                j++;
            }
        }
        mergeSort(rightArray);
        mergeSort(leftArray);
        merge(array, leftArray, rightArray);
    }

    public static void merge(int[] array, int[] leftArray, int[] rightArray){
        int leftSize = array.length / 2;
        int rightSize = array.length - leftSize;
        int i=0, r=0, l=0;

        while(l < leftSize && r < rightSize){
            if(leftArray[l] < rightArray[r]){
                array[i] = leftArray[l];
                i++;
                l++;
            } else {
                array[i] = rightArray[r];
                i++;
                r++;
            }
        }
        while(l < leftSize){
            array[i] = leftArray[l];
            i++;
            l++;
        }
        while(r < rightSize){
            array[i] = rightArray[r];
            i++;
            r++;
        }
    }

    public int[] sortArray(int[] nums) {
        mergeSort(nums);
        return nums;    
    }
}