class NumMatrix {
    int[][] answer;

    public NumMatrix(int[][] matrix) {
        int rowLength = matrix.length;
        int colLength = matrix[0].length;
        answer = new int[rowLength+1][colLength+1];
        
        for(int i = 0; i < rowLength; i++){
            for(int j = 0; j < colLength; j++){
                int prefixSum = (answer[i+1][j] + answer[i][j+1] - answer[i][j]) + matrix[i][j];
                answer[i+1][j+1] = prefixSum;
            }
        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        int sum = answer[row2+1][col2+1] - answer[row1][col2+1] - answer[row2+1][col1] + answer[row1][col1];
        return sum;
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */