/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    private TreeNode findDfs(TreeNode root,TreeNode p,TreeNode q){
        if(root.val>Math.min(p.val,q.val)&&root.val<Math.max(p.val,q.val)){
            return root;
        }

        
            
        

        if(root.val>Math.max(p.val,q.val)){
           return findDfs(root.left,p,q);
        }

        if(root.val<Math.min(p.val,q.val)){
           return findDfs(root.right,p,q);
        }

        return root;

    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
      return  findDfs(root,p,q);
    }
}