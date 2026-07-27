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
    Map<Integer,Integer> ind= new HashMap<>();
    public TreeNode findTree(int[] preorder,int[] inorder,int prestart,int preend,int instart,int inend){

           if (prestart>preend&&instart>inend) {
            return null;
        }
        
         if(prestart==preend&&instart==inend){
            return new TreeNode(preorder[prestart]);
        }
        TreeNode root=new TreeNode(preorder[prestart]);
       
        int index=ind.get(preorder[prestart]);
        int sizeLeft=index-instart;
       

        root.left=findTree(preorder,inorder,prestart+1,prestart+sizeLeft,instart,instart+sizeLeft-1);
        root.right=findTree(preorder,inorder,prestart+sizeLeft+1,preend,instart+sizeLeft+1,inend);

        return root;
    }
    public TreeNode bstFromPreorder(int[] preorder) {
        int[] pre= new int[preorder.length];
        for(int i=0;i<pre.length;i++){
            pre[i]=preorder[i];
        }

        Arrays.sort(preorder);
        for(int i=0;i<preorder.length;i++){
            ind.put(preorder[i],i);
        }
        

       return findTree(pre,preorder,0,pre.length-1,0,preorder.length-1);
    }
}