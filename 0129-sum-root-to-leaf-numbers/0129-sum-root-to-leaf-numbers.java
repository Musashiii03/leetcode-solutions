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

    int totalSum;

    public void traversing(TreeNode root, int sum){
        if(root == null)
            return;
        sum = (sum * 10) + root.val;
        if(root.left == null && root.right == null)
            totalSum += sum; 
        traversing(root.left, sum);
        traversing(root.right, sum);
    }

    public int sumNumbers(TreeNode root) {
        if(root == null)
            return 0;
        int sum = 0;
        traversing(root, sum);
        return totalSum;
    }
}