import java.util.Arrays;

class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        Arrays.sort(potions);
        int[] result = new int[spells.length];
        for(int i = 0; i < spells.length; i++){
            int low = 0;
            int high = potions.length - 1;
            int count = 0;
            while(low <= high){
                int mid = low + (high - low) / 2;
                long product = (long) spells[i] * potions[mid];
                if(product < success)
                    low = mid + 1;
                else
                    high = mid - 1;
            }
            result[i] = potions.length - low;
        }
        return result;
    }
}