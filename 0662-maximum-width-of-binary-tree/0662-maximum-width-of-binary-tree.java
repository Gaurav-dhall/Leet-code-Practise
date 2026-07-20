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

 class Pair{
    TreeNode Node;
    int index;
    Pair(TreeNode r, int i){
        this.Node=r;
        this.index=i;
    }
 }
class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        Queue<Pair> q = new ArrayDeque<>();

        q.offer(new Pair(root,0));
        int ans=Integer.MIN_VALUE;

        while(!q.isEmpty()){
            int size=q.size();
            int left=0;
            int right=0;
            int minI=q.peek().index;

            for(int i=0;i<size;i++){
                if(i==0){
                    left=q.peek().index;
                }

                if(i==size-1){
                    right=q.peek().index;
                }

                Pair curr= q.poll();

                curr.index=curr.index-minI;

                if(curr.Node.left!=null){
                    q.offer(new Pair(curr.Node.left,2*curr.index+1));
                }

                if(curr.Node.right!=null){
                    q.offer(new Pair(curr.Node.right,2*curr.index+2));
                }

                
            }

            ans=Integer.max(ans,right-left+1);
        }

        return ans;
    }
}