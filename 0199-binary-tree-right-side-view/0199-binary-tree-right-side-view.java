import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
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
    public List<Integer> rightSideView(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<Integer> result = new ArrayList<>();
        if(root == null){return result;}
        queue.add(root);
        while(!queue.isEmpty()){
            TreeNode currentNode = null;
            int levelSize = queue.size();
            for(int i = 0; i < levelSize; i++){
                TreeNode node = queue.poll();
                currentNode = node;
                if(node.left != null)
                    queue.add(node.left);
                if(node.right != null){
                    queue.add(node.right);
                }
            }
            result.add(currentNode.val);
        }
        return result;
    }
}