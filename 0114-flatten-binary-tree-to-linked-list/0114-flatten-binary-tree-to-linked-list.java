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

    public TreeNode flattenTree(TreeNode root){

        if(root == null){return null;}
        if(root.left == null && root.right == null){return root;}

        TreeNode originalRight = root.right;
        TreeNode lastNodeLeft = null;
        
        if(root.left != null){
            lastNodeLeft = flattenTree(root.left);
            root.right = root.left;
            root.left = null;
            lastNodeLeft.right = originalRight;
        }

        if(originalRight != null)
            return flattenTree(originalRight);

        return lastNodeLeft;
    }

    public void flatten(TreeNode root) {
        flattenTree(root);
    }
}