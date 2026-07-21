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
    public void dfsTravel(TreeNode root,TreeNode rootNew){
        if(root.left!=null){
            rootNew.right=new TreeNode(root.left.val);
            dfsTravel(root.left,rootNew.right);
        }

        if(root.right!=null){
            rootNew.left=new TreeNode(root.right.val);
            dfsTravel(root.right,rootNew.left);
        }

        return;
    }
    public TreeNode invertTree(TreeNode root) {
        if(root==null){
            return null;
        }
        TreeNode rootNew= new TreeNode(root.val);

        dfsTravel(root,rootNew);
        return rootNew;
    }
}