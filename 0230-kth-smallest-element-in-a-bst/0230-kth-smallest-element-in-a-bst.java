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

    int count = 0;

    public int traversal(TreeNode root, int k){
        if(root == null){return 0;}
        int left = traversal(root.left, k);
        if(left != 0)
            return left;
        count++;
        if(count == k)
            return root.val;
        int right = traversal(root.right, k);
        if(right != 0)
            return right;
        return 0;
    }

    public int kthSmallest(TreeNode root, int k) {
        return traversal(root, k);
    }
}