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
    int maxi=Integer.MIN_VALUE;

    public int findSum(TreeNode root){
        if(root==null){
            return 0;
        }

        int leftSum=findSum(root.left);
        int rightSum=findSum(root.right);

        leftSum=leftSum<0?0:leftSum;
        rightSum=rightSum<0?0:rightSum;

        maxi=Math.max(maxi,root.val+leftSum+rightSum);

        return root.val+Math.max(leftSum,rightSum);
    }

    public int maxPathSum(TreeNode root) {
        findSum(root);
        return maxi;
    }
}