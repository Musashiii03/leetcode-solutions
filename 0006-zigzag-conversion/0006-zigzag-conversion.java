class Solution {
    public String convert(String s, int numRows) {

        if(numRows == 1){return s;}

        StringBuilder[] rows = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++) {
            rows[i] = new StringBuilder();
        }

        boolean increasing = true;
        int currentRow = 1;
        for(int i = 0; i < s.length(); i++){
            rows[currentRow - 1].append(s.charAt(i));
            if(currentRow == numRows)
                increasing = false;
            else if(currentRow == 1)
                increasing = true;
            if(increasing)
                currentRow++;
            else
                currentRow--;
        }

        String result = "";
        for (int i = 0; i < numRows; i++) {
            result += rows[i].toString();
        }

        return result;
    }
}