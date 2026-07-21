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
     
        TreeNode ptr=null;
    private void findDfs(TreeNode root){
        
        if(root.left!=null){
            ptr.right=new TreeNode(root.left.val);
            ptr=ptr.right;
            findDfs(root.left);
        }

        if(root.right!=null){
            ptr.right=new TreeNode(root.right.val);
            ptr=ptr.right;
            findDfs(root.right);
        }

        return;
    }
    public void flatten(TreeNode root) {

        if(root==null){
            return ;
        }
        TreeNode rootNew= new TreeNode(root.val);
        ptr=rootNew;
       
        findDfs(root);
        root.left=null;
        root.right=rootNew.right;
        rootNew.right=null;
    }
}