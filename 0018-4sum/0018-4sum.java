import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        for(int i = 0; i < nums.length; i++){
            if(i>0 && nums[i-1] == nums[i])
                continue;
            for(int j = i+1; j < nums.length; j++){
                if(j>i+1 && nums[j-1] == nums[j])
                    continue;
                int k = j+1;
                int l = nums.length - 1;
                while(k < l){
                    long complement = (long)target - ((long)nums[i] + (long)nums[j]);
                    if((long)nums[k] + (long)nums[l] > complement)
                        l--;
                    else if((long)nums[k] + (long)nums[l] < complement)
                        k++;
                    else{
                        result.add(Arrays.asList(nums[i], nums[j], nums[k], nums[l]));
                        k++;
                        l--;
                        while(k<l && nums[k-1] == nums[k])
                            k++;
                        while(k<l && nums[l+1] == nums[l])
                            l--;
                    }
                }
            }
        }
        return result;   
    }
}