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
    public TreeNode findTree(int[] preorder,int[] inorder){

           if (preorder == null || inorder == null || preorder.length == 0 || inorder.length == 0) {
            return null;
        }
        
         if(inorder.length==1&&preorder.length==1){
            return new TreeNode(preorder[0]);
        }
        TreeNode root=new TreeNode(preorder[0]);
       
        int index=0;
        for(int i=0;i<inorder.length;i++){
            if(inorder[i]==root.val){
                index=i;
            }
        }

        root.left=findTree(Arrays.copyOfRange(preorder,1,index+1),Arrays.copyOfRange(inorder,0,index));
        root.right=findTree(Arrays.copyOfRange(preorder,index+1,preorder.length),Arrays.copyOfRange(inorder,index+1,inorder.length));

        return root;
    }
    public TreeNode bstFromPreorder(int[] preorder) {
        int[] pre= new int[preorder.length];
        for(int i=0;i<pre.length;i++){
            pre[i]=preorder[i];
        }

        Arrays.sort(preorder);
        

       return findTree(pre,preorder);
    }
}