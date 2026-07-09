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

    public List<Integer> findpostorder(TreeNode root,List<Integer> ans){
        if(root.left==null){
            if(root.right!=null){
                findpostorder(root.right,ans);
                ans.add(root.val);
                return ans;
            }
            ans.add(root.val);
            return ans;
        }
        findpostorder(root.left,ans);
        if(root.right!=null){

        findpostorder(root.right,ans);
        }
        ans.add(root.val);

        return ans;

    }
    public List<Integer> postorderTraversal(TreeNode root) {
        if(root==null) return new ArrayList<>();
        List<Integer> ans = findpostorder(root,new ArrayList<>());

        return ans;
    }
}