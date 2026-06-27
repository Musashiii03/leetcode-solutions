import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int element1 = 0, element2 = 0;
        int count1 = 0, count2 = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == element1)
                count1++;
            else if(nums[i] == element2)
                count2++;
            else if(count1 == 0){
                element1 = nums[i];
                count1++;
            } else if(count2 == 0){
                element2 = nums[i];
                count2++;
            } else{
                count1--;
                count2--;
            }
        }
        ArrayList<Integer> result = new ArrayList<>(); 
        int freq1 = 0, freq2 = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == element1)
                freq1++;
            if(nums[i] == element2)
                freq2++;
        }
        if(freq1 > nums.length/3)
            result.add(element1);
        if(element1 != element2 && freq2 > nums.length/3)
            result.add(element2);
        return result;
    }
}