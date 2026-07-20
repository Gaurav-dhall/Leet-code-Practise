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

    public TreeNode findDFS(TreeNode root,int p,int q){
        if(root==null){
            return null;
        }

        if(root.val==p||root.val==q){
            return root;
        }

        TreeNode left=findDFS(root.left,p,q);
        TreeNode right=findDFS(root.right,p,q);

        if(left==null&&right==null){
            return null;
        }

        if(left==null||right==null){
            return left==null?right:left;
        }

        return root;
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
       return findDFS(root,p.val,q.val);
    }
}