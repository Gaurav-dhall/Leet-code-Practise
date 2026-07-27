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
    public TreeNode findTree(int[] preorder,int preStart,int preEnd){
        if(preStart>preEnd){
            return null;
        }
        if(preStart==preEnd){
            return new TreeNode(preorder[preStart]);
        }
        TreeNode root= new TreeNode(preorder[preStart]);
        int index=preEnd;
        for(int i=preStart;i<=preEnd;i++){
            if(preorder[i]>root.val){
                index=i-1;
                break;
            }
        }

        int leftSize=index-preStart;
        root.left=findTree(preorder,preStart+1,preStart+leftSize);
        root.right=findTree(preorder,preStart+leftSize+1,preEnd);

        return root;
    }
    public TreeNode bstFromPreorder(int[] preorder) {
       return findTree(preorder,0,preorder.length-1);
    }
}