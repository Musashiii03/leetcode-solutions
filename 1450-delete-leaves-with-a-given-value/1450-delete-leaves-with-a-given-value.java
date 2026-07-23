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

    public TreeNode deleteTarget(TreeNode root, int target){
        if(root == null){return null;}
        root.left = deleteTarget(root.left, target); 
        root.right = deleteTarget(root.right, target); 
        if(root.right == null && root.left == null && root.val == target)
            return null;
        else
            return root;
    }

    public TreeNode removeLeafNodes(TreeNode root, int target) {
        if(root == null){return root;}
        return deleteTarget(root, target);
    }
}