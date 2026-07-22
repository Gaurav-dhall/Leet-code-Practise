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
    

    private TreeNode findTree(int [] inorder,int[] postorder){

        if(inorder.length==0||postorder.length==0){
            return null;
        }
        TreeNode root = new TreeNode(postorder[postorder.length-1]);
        if(inorder.length==1&&postorder.length==1){
            return root;
        }
        int i=0;
        for(int k=0;k<inorder.length;k++){
            if(inorder[k]==postorder[postorder.length-1]){
                i=k;
                break;
            }
        }
        
        root.left=findTree(Arrays.copyOfRange(inorder,0,i),Arrays.copyOfRange(postorder,0,i));

        root.right=findTree(Arrays.copyOfRange(inorder,i+1,inorder.length),Arrays.copyOfRange(postorder,i,postorder.length-1));

        return root;


    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
      

      
       

       return findTree(inorder,postorder);
    }
}