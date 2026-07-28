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

    public boolean search(TreeNode root,TreeNode skip,int x){
        if(root==null){
            return false;
        }
        if(root.val==x&&root!=skip){
            return true;
        }
        


        if(x>root.val&&root.right!=null){
          return  search(root.right,skip,x);
        }
        if(x<root.val&&root.left!=null){
          return  search(root.left,skip,x);
        }
        return false;
    }
    
    public boolean traverse(TreeNode root,TreeNode actualRoot,int k){
        int n=root.val;
        int find=k-n;

      boolean result=  search(actualRoot,root,find);
      if(result){
        return true;
      }
      boolean left=false;
      boolean right=false;

      if(root.left!=null){
        left=traverse(root.left,actualRoot,k);
      }

      if(root.right!=null){
        right=traverse(root.right,actualRoot,k);
      }
      return left||right;


    }
    public boolean findTarget(TreeNode root, int k) {
       return traverse(root,root,k);
    }
}