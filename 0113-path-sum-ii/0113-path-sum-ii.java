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

    public void findPath(TreeNode root,int targetSum, List<Integer> ds,List<List<Integer>> ans){
        if(root==null){
            return ;
        }
        

        targetSum-=root.val;
        ds.add(root.val);


        if(root.left==null&&root.right==null){
            if(targetSum==0){
                ans.add(new ArrayList<>(ds));

                
            }

            ds.remove(ds.size()-1);
            return;
        }

        findPath(root.left,targetSum,ds,ans);
        findPath(root.right,targetSum,ds,ans);
        ds.remove(ds.size()-1);
        return;
        


    }
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> ans= new ArrayList<>();
        findPath(root,targetSum,new ArrayList<>(),ans);
        return ans;
    }
}