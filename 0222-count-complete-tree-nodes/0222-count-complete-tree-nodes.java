/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {

    public int countNodes(TreeNode root) {
        if(root == null){return 0;}
        TreeNode leftSubTree = root;
        TreeNode rightSubTree = root;
        int lenLeft = 0;
        int lenRight = 0;
        while(leftSubTree != null){
            lenLeft++;
            leftSubTree = leftSubTree.left;
        }
        while(rightSubTree != null){
            lenRight++;
            rightSubTree = rightSubTree.right;
        }

        if(lenLeft == lenRight)
            return Math.powExact(2, lenLeft) - 1;
        return 1 + countNodes(root.left) + countNodes(root.right);
    }
}