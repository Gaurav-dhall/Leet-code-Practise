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

    public List<Integer> findPreOrder(TreeNode root,List<Integer> ans){
        
        ans.add(root.val);
        if(root.left==null){
          if(root.right!=null){
             findPreOrder(root.right,ans);
          }
          return ans;
        }
        findPreOrder(root.left,ans);
        if(root.right!=null){
            findPreOrder(root.right,ans);
        }
        return ans;
    }
    public List<Integer> preorderTraversal(TreeNode root) {
        if(root==null) return new ArrayList<>();
        List<Integer> ans=findPreOrder(root,new ArrayList<>());
        return ans;
    }
}