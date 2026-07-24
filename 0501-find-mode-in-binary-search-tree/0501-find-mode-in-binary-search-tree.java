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
    public int[] findMode(TreeNode root) {
        Queue<TreeNode> q= new ArrayDeque<>();
        q.offer(root);
        Map<Integer,Integer> hash= new HashMap<>();

        while(!q.isEmpty()){
            TreeNode curr=q.poll();
            hash.put(curr.val,hash.getOrDefault(curr.val,0)+1);
            if(curr.left!=null){
                q.offer(curr.left);
            }
            if(curr.right!=null){
                q.offer(curr.right);
            }

        }
        int max=Integer.MIN_VALUE;
        int count=1;

        for(Integer value:hash.values()){
            if(value>max){
                count=1;
                max=value;
            }
            else if(value==max){
                count++;
            }
        }

        int[] ans= new int[count];

        int j=0;
        for(Integer key:hash.keySet()){
            if(hash.get(key)==max){
                ans[j]=key;
                j++;
            }
        }

        return ans;

        
    }
}