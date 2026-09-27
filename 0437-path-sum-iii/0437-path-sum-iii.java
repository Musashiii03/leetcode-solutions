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

    int paths = 0;

    public void helper(TreeNode root, int targetSum, long currentSum){
        if(root == null){return;}
        currentSum += root.val;
        if(targetSum == currentSum)
            paths++;
        helper(root.left, targetSum, currentSum);
        helper(root.right, targetSum, currentSum);
        currentSum -= root.val;
    }

    public void preorder(TreeNode root, int targetSum){
        if(root == null){return;}
        helper(root, targetSum, 0);
        preorder(root.left, targetSum);
        preorder(root.right, targetSum);
    }

    public int pathSum(TreeNode root, int targetSum) {
        preorder(root, targetSum);
        return paths;
    }
}