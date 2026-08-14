import java.util.LinkedList;
import java.util.Queue;

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
    public int maxLevelSum(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        if(root == null){return 0;}
        int currentLevel = 0;
        queue.add(root);
        int maxSum = Integer.MIN_VALUE;
        int levelOfMaxSum = 0;
        while(!queue.isEmpty()) {
            currentLevel++;
            int levelSize = queue.size();
            int levelSum = 0;
            for(int i = 0; i < levelSize; i++){
                TreeNode current = queue.poll();
                levelSum += current.val;
                if(current.left != null)
                    queue.add(current.left);
                if(current.right != null)
                    queue.add(current.right);
            }
            if(levelSum > maxSum){
                levelOfMaxSum = currentLevel;
                maxSum = levelSum;
            }
        }
        return levelOfMaxSum;
    }
}