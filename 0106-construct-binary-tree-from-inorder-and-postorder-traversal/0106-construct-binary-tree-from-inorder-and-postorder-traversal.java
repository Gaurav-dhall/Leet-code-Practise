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
    
    Map<Integer,Integer> index= new HashMap<>();
    private TreeNode findTree(int [] inorder, int[] postorder, int inStart, int inEnd, int postStart,int postEnd){

        if(inStart>inEnd||postStart>postEnd){
            return null;
        }
        TreeNode root = new TreeNode(postorder[postEnd]);
        if(inStart==inEnd&&postStart==postEnd){
            return root;
        }
        int i=index.get(postorder[postEnd]);
        int leftSize=i-inStart;
        
        root.left=findTree(inorder,postorder,inStart,i-1,postStart,postStart+leftSize-1);

        root.right=findTree(inorder,postorder,i+1,inEnd,postStart+leftSize,postEnd-1);

        return root;


    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
      
        for(int i=0;i<inorder.length;i++){
            index.put(inorder[i],i);
        }
      
       

       return findTree(inorder,postorder,0,inorder.length-1,0,postorder.length-1);
    }
}