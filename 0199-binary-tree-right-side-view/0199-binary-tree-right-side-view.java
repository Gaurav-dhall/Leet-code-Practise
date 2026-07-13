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
    List<Integer> ans= new ArrayList<>();
    int maxDepth=Integer.MIN_VALUE;
        public void findRightView(TreeNode root,int currDepth){
        if(currDepth>maxDepth){
        maxDepth=currDepth;
        ans.add(root.val);
        }

        if(root.right!=null){
           findRightView(root.right,currDepth+1);
        }

        if(root.left!=null){
            findRightView(root.left,currDepth+1);
        }

        return;
    }
    public List<Integer> rightSideView(TreeNode root) {
        if(root==null){
            return ans;
        }
        findRightView(root,0);
        return ans;
    }
}