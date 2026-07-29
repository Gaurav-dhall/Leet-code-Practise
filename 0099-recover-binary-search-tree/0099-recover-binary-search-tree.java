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
    TreeNode prev=null;
    TreeNode curr=null;
    TreeNode first=null;
    TreeNode last=null;
    boolean flag=false;
    TreeNode middle=null;
    public void inorder(TreeNode root){
        if(root.left!=null){
            inorder(root.left);
        }
        prev=curr;
        curr=root;
        if(prev!=null&&curr.val<prev.val){
            if(!flag){
            first=prev;
            middle=curr;
            flag=!flag;
            }
            else{
                last=curr;
                int k=last.val;
                last.val=first.val;
                first.val=k;
                flag=!flag;
            }
            
        }

        if(root.right!=null){
            inorder(root.right);
        }
        

    }
    public void recoverTree(TreeNode root) {
        inorder(root);
        if(flag){
            int k=first.val;
            first.val=middle.val;
            middle.val=k;
        }

    }
}