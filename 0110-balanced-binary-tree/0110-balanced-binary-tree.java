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
    boolean balanced=true;
   
    public int findHeight(TreeNode root){

        if(root==null){
            return 0;
        }
       int lh= findHeight(root.left);
       int rh=findHeight(root.right);
       int diff=lh-rh;
      diff= diff>0?diff:-diff;

      if(diff>1){
        balanced=false;
      }
     
     



       return 1+Math.max(lh,rh);

    }
    public boolean isBalanced(TreeNode root) {
        findHeight(root);
        return balanced;
    }
}