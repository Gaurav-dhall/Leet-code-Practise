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
    String min="zzzzzzzzzzzzzzzzzzzzzzzzzz";
    List<String> str= new ArrayList<>();
    public void findDfs(TreeNode root,StringBuilder sb){
        sb.append((char)('a'+root.val));
        if(root.left!=null){
            findDfs(root.left,sb);
        }

        if(root.right!=null){
            findDfs(root.right,sb);
        }

        if(root.left==null&&root.right==null){
            StringBuilder temp = new StringBuilder(sb);
            if(temp.reverse().toString().compareTo(min)<0){
                min=temp.toString();
            }
           
           
        }
         sb.deleteCharAt(sb.length()-1);
         return;
    }
    public String smallestFromLeaf(TreeNode root) {
        findDfs(root,new StringBuilder());
        

       

        return min;
    }
}