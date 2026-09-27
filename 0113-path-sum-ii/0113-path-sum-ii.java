import java.util.ArrayList;
import java.util.List;

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

    List<List<Integer>> result;

    public void helper(TreeNode root, int targetSum, List<Integer> path){
        if(root == null){return;}
        path.add(root.val);
        targetSum -= root.val;
        if(root.left == null && root.right == null){
            if(targetSum == 0)
                result.add(new ArrayList<>(path));
        } else {
            helper(root.left, targetSum, path);
            helper(root.right, targetSum, path);
        }
        path.remove(path.size() - 1);
    } 

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        result = new ArrayList<>();
        helper(root, targetSum, new ArrayList<>());
        return result;
    }
}