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
    int sum=0;
    
    public int findSum(TreeNode root){
        
        if(root==null){
            return 0;
        }
        
        int left=0;
        int right=0;
        
        if(root.left!=null){
           left= findSum(root.left);
        }
        
        if(root.right!=null){
            right=findSum(root.right);
        }
        
        int diff=left>right?left-right: right-left;
        
        sum+=diff;
        return left+right+root.val;
        
        
    }
    public int findTilt(TreeNode root) {
        if(root==null){
            return 0;
        }
        
        findSum(root);
         
        return sum;
    }
}