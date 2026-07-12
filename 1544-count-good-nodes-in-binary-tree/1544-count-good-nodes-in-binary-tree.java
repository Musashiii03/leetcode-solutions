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

    public int traversal(TreeNode root, int max){
        if(root == null){return 0;}
        int count = 0;
        if(root.val >= max)
            count++;
        max = Math.max(max, root.val);
        count += traversal(root.left, max);
        count += traversal(root.right, max);
        return count;
    }

    public int goodNodes(TreeNode root) {
        if(root == null){return 0;}
        return traversal(root, Integer.MIN_VALUE);
    }
}