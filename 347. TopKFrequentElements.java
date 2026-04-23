import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            if(map.containsKey(nums[i]))
                map.put(nums[i], map.get(nums[i]) + 1);
            else
                map.put(nums[i], 1);
        }
        List<Integer>[] bucket = new List[nums.length + 1];
        for(int i = 0; i < bucket.length; i++)
            bucket[i] = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()){
            int num = entry.getKey();
            int val = entry.getValue();
            bucket[val].add(num);
        }
        int i = 0;
        int j = bucket.length-1;
        int[] output = new int[k];
        while(j >= 0){
            if(!bucket[j].isEmpty()){
                for(int num : bucket[j]){
                    output[i] = num;
                    i++;
                    if(i == k)
                        break;
                }
            }
            if(i == k)
                break;
            j--;
        }
        return output;
    }
}