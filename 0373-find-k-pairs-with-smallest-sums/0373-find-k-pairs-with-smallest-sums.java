import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> result = new ArrayList<>();
        PriorityQueue<int[]> heap = new PriorityQueue<>((a,b) -> Integer.compare(a[0], b[0]));
        for(int i = 0; i < nums1.length; i++)
            heap.offer(new int[]{nums1[i] + nums2[0], i, 0});
        while(!heap.isEmpty() && result.size() < k){
            int[] current = heap.poll();
            int i = current[1];
            int j = current[2];
            result.add(Arrays.asList(nums1[i], nums2[j]));
            if(j+1 < nums2.length)
                heap.offer(new int[]{nums1[i] + nums2[j + 1], i, j + 1});
        }

        return result;
    }
}