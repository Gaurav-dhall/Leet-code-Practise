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
    public TreeNode deleteNode(TreeNode root, int key) {
        TreeNode ptr= root;
        TreeNode prev = null;
        if(root==null){
            return null;
        }

        if(ptr.val==key){
            if(ptr.left==null&&ptr.right==null) return null;
            if(ptr.left==null) return ptr.right;
            if(ptr.right==null) return ptr.left;
            prev=ptr;
           ptr=ptr.left;
           if(ptr.right==null){
            ptr.right=root.right;
            return ptr;
           }

           while(ptr.right!=null){
            prev=ptr;
            ptr=ptr.right;
           }
           prev.right=ptr.left;
           ptr.left=root.left;
           ptr.right=root.right;
           return ptr;


        }

        while(ptr!=null&&ptr.val!=key){
            if(key<ptr.val){
                prev=ptr;
                ptr=ptr.left;
            }
            else if(key>ptr.val){
                prev=ptr;
                ptr=ptr.right;
            }
        }

        if(ptr==null){
            return root;
        }

        if(ptr.left==null||ptr.right==null){
            if(ptr.left==null){
                if(prev.left!=null&&prev.left.val==key){
                    prev.left=ptr.right;
                }
                else{
                    prev.right=ptr.right;
                }
            }
            else{
                if(prev.left!=null&&prev.left.val==key){
                    prev.left=ptr.left;
                }
                else{
                    prev.right=ptr.left;
                }
            }
        }

        if(ptr.left!=null&&ptr.right!=null){
            if(prev.left!=null&&prev.left.val==key){
                prev.left=ptr.left;
                prev=prev.left;

                while(prev.right!=null){
                    prev=prev.right;
                }

                prev.right=ptr.right;
            }
            else{
                prev.right=ptr.right;
                prev=prev.right;

                while(prev.left!=null){
                    prev=prev.left;
                }

                prev.left=ptr.left;
            }
        }

        return root;
    }
}