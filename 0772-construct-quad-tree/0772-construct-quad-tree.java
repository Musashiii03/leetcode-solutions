/*
// Definition for a QuadTree node.
class Node {
    public boolean val;
    public boolean isLeaf;
    public Node topLeft;
    public Node topRight;
    public Node bottomLeft;
    public Node bottomRight;

    
    public Node() {
        this.val = false;
        this.isLeaf = false;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }
    
    public Node(boolean val, boolean isLeaf) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }
    
    public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft, Node bottomRight) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = topLeft;
        this.topRight = topRight;
        this.bottomLeft = bottomLeft;
        this.bottomRight = bottomRight;
    }
}
*/

class Solution {
    
    public Node traverse(int[][] grid, int row, int column, int n){
        boolean allSame = true;
        int initialValue = grid[row][column];
        for(int i = row; i < row + n; i++){
            for(int j = column; j < column + n; j++){
                if(grid[i][j] != initialValue){
                    allSame = false;
                    break;
                }
            }
            if(allSame == false)
                break;
        }

        if(allSame == true)
            return new Node(((initialValue == 1) ? true : false), true);

        Node topLeft = traverse(grid, row, column, n/2);
        Node topRight = traverse(grid, row, column + n/2, n/2);
        Node bottomLeft = traverse(grid, row + n/2, column, n/2);
        Node bottomRight = traverse(grid, row + n/2, column + n/2, n/2);

        return new Node(false, false, topLeft, topRight, bottomLeft, bottomRight);
    }
    
    public Node construct(int[][] grid) {
        return traverse(grid, 0, 0, grid.length);
    }
}