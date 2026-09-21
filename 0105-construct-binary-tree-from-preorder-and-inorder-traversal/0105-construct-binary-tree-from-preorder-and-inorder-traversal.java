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

    public TreeNode build(int[] preorder, int[] inorder, int preLeft, int preRight, int inLeft, int inRight){

        if(inLeft > inRight){return null;}

        TreeNode root = new TreeNode(preorder[preLeft]);

        int rootIndex = -1;
        for(int i = inLeft; i <= inRight; i++){
            if(inorder[i] == root.val){
                rootIndex = i;
                break;
            }
        }

        int leftSubTreeSize = rootIndex - inLeft;

        root.left = build(preorder, inorder,  
            preLeft + 1, preLeft + leftSubTreeSize,
            inLeft, rootIndex - 1);

        root.right = build(preorder, inorder,  
            preLeft + leftSubTreeSize + 1, preRight,
            rootIndex + 1, inRight);

        return root;
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return build(preorder, inorder,
            0, preorder.length-1,
            0, inorder.length-1);
    }
}