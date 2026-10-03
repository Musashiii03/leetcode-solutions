class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        
        int n = nums1.length;
        int m = nums2.length;
        int middle = 0;

        if((n + m) % 2 != 0)
            middle = (nums1.length + nums2.length) / 2;
        else
            middle = (nums1.length + nums2.length) / 2 - 1;

        int i = 0, j = 0;
        int indexOfMerged = 0;
        int current = 0;
        while(i < nums1.length && j < nums2.length){
            if(nums1[i] < nums2[j]){
                current = nums1[i];
                i++;
            } else if(nums1[i] >= nums2[j]){
                current = nums2[j];
                j++;
            }
            indexOfMerged++;
            if(indexOfMerged == middle + 1)
                break;
        }

        if(indexOfMerged != middle + 1){
            while(i < nums1.length){
                current = nums1[i];
                i++;
                indexOfMerged++;
                if(indexOfMerged == middle + 1)
                    break;
            }
            while(j < nums2.length){
                current = nums2[j];
                j++;
                indexOfMerged++;
                if(indexOfMerged == middle + 1)
                    break;
            }
        }

        if((n + m) % 2 == 0){
            int next;
            if (i == nums1.length)
                next = nums2[j];
            else if (j == nums2.length)
                next = nums1[i];
            else
                next = Math.min(nums1[i], nums2[j]);

            return (double) (current + next) / 2;
        } else
            return (double) current; 
    }
}