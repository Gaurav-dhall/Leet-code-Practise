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

    public List<Integer> findinorder(TreeNode root,List<Integer> ans){
        if(root.left==null){
            ans.add(root.val);
            if(root.right!=null){
                findinorder(root.right,ans);
            }
            return ans;
        }
        findinorder(root.left,ans);
        ans.add(root.val);
        if(root.right!=null){

        findinorder(root.right,ans);
        }
        return ans;
    }
    public List<Integer> inorderTraversal(TreeNode root) {
        if(root==null) return new ArrayList<>();

       List<Integer> ans = findinorder(root,new ArrayList<>());

       return ans;
    }
}