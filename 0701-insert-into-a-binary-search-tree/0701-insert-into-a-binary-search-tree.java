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
    public TreeNode insertIntoBST(TreeNode root, int val) {
        TreeNode ptr=root;
        if(root==null){
            return new TreeNode(val);
        }

        while(ptr!=null){
            if(val>ptr.val&&ptr.right!=null){
                ptr=ptr.right;
            }
            else if(val<ptr.val&&ptr.left!=null){
                ptr=ptr.left;
            }
            else{
                if(val>ptr.val){
                    ptr.right=new TreeNode(val);
                }
                else{
                    ptr.left= new TreeNode(val);
                }
                ptr=null;
            }
        }

        return root;
    }
}