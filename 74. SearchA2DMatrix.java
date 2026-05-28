class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int i = 0;
        if(target > matrix[m-1][n-1] || target < matrix[0][0])
            return false;
        while(i < m){
            if(target > matrix[i][n-1]){
                i++;
            }
            else if (target < matrix[i][n-1]){
                int low = 0;
                int high = n-1;
                while(low <= high){
                    int mid = (low + high) /2;
                    if(matrix[i][mid]>target){
                        high = mid - 1;
                    } else if (matrix[i][mid] < target){
                        low = mid + 1;
                    } else {
                        return true;
                    }
                }
                return false;
            }
            else return true;
        }
        return false;
    }
}