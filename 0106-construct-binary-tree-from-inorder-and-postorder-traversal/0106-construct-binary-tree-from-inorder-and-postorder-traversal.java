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

    public TreeNode build(int[] inorder, int[] postorder, int inLeft, int inRight, int postLeft, int postRight){

        if(inLeft > inRight){return null;}

        TreeNode root = new TreeNode(postorder[postRight]);

        int rootIndex = -1;
        for(int i = inLeft; i <= inRight; i++){
            if(inorder[i] == root.val){
                rootIndex = i;
                break;
            }
        }

        int leftSubTreeSize = rootIndex - inLeft;

        root.left = build(inorder, postorder, 
            inLeft, rootIndex - 1, 
            postLeft, postLeft + leftSubTreeSize - 1);

        root.right = build(inorder, postorder, 
            rootIndex + 1, inRight, 
            postLeft + leftSubTreeSize, postRight - 1);

        return root;
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return build(inorder, postorder, 
            0, inorder.length-1, 
            0, postorder.length-1);
    }
}