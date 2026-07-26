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
    long prev=Long.MIN_VALUE;
    Boolean ans=true;
    public void findinorder(TreeNode root){
        if(root.left!=null){
           findinorder(root.left);
        }
        
        if(root.val<=prev){
            ans=false;
            return;
        }
        
        prev=root.val;

        if(root.right!=null){
            findinorder(root.right);
        }

    }
    public boolean isValidBST(TreeNode root) {
        if(root.left==null&&root.right==null){
            return true;
        }
        findinorder(root);
        return ans;
    }
}