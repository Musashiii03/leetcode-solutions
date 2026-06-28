class Solution {
    public boolean isValidSudoku(char[][] board) {

        // Checking Validity of Rows
        for(int i = 0; i < 9; i++){
            boolean[] arr = new boolean[9];
            for(int j = 0; j < 9; j++){
                if(board[i][j] == '.')
                    continue;
                else if(arr[board[i][j] - '1'] == true)
                    return false;
                else
                    arr[board[i][j] - '1'] = true;
            }
        }

        // Checking Validity of Columns
        for(int i = 0; i < 9; i++){
            boolean[] arr = new boolean[9];
            for(int j = 0; j < 9; j++){
                if(board[j][i] == '.')
                    continue;
                else if(arr[board[j][i] - '1'] == true)
                    return false;
                else
                    arr[board[j][i] - '1'] = true;
            }
        }

        // Checking Validity of 3x3 Boxes
        for(int a = 0; a < 9; a += 3){
            for(int b = 0; b < 9; b += 3){
                boolean[] arr = new boolean[9];
                for(int c = a; c < a + 3; c++){
                    for(int d = b; d < b + 3; d++){
                        if(board[c][d] == '.')
                            continue;
                        else if(arr[board[c][d] - '1'] == true)
                            return false;
                        else
                            arr[board[c][d] - '1'] = true;
                    }
                }
            }
        }
        
        return true;
    }
}