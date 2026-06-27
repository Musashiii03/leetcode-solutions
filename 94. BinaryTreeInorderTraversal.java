import java.util.ArrayList;

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

    ArrayList<Integer> result;

        public void traversal(TreeNode root) {
            if(root == null) {return;}
            traversal(root.left);
            result.add(root.val);
            traversal(root.right);
        }

    public List<Integer> inorderTraversal(TreeNode root) {
        result = new ArrayList<>();
        if(root == null) {return result;}
        traversal(root);
        return result;
    }
}