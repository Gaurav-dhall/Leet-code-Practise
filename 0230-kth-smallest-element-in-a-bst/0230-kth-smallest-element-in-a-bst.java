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
    int count=0;
    public int findinorder(TreeNode root,int k){
        if(root.left!=null){
          int ans=  findinorder(root.left,k);
          if(ans>=0){
            return ans;
          }
        }
        count++;
        if(count==k){
            return root.val;
        }
        if(root.right!=null){
            int ans= findinorder(root.right,k);
            if(ans>=0){
                return ans;
            }
        }

        return -1;
    }
    public int kthSmallest(TreeNode root, int k) {
      return  findinorder(root,k);
    }
}