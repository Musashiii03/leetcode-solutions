import java.util.Arrays;

class Solution {
    public int candy(int[] ratings) {

        int[] candies = new int[ratings.length];
        Arrays.fill(candies, 1);

        // Checking all the left neighbours
        for(int i = 1; i < ratings.length; i++){
            if(ratings[i] > ratings[i - 1])
                candies[i] = candies[i - 1] + 1;
        }
        
        // Checking all the right neighbours
        for(int i = ratings.length - 2; i >= 0; i--){
            if(ratings[i] > ratings[i + 1])
                candies[i] = Math.max(candies[i], candies[i + 1] + 1);
        }

        // Getting total candies
        int totalCandies = 0;
        for(int i = 0; i < candies.length; i++)
            totalCandies += candies[i];

        return totalCandies;
    }
}