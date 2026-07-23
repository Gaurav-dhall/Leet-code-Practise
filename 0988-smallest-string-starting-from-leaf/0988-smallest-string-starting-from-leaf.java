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
            str.add(temp.reverse().toString());
           
           
        }
         sb.deleteCharAt(sb.length()-1);
         return;
    }
    public String smallestFromLeaf(TreeNode root) {
        findDfs(root,new StringBuilder());
        String min="zzzzzzzzzzzzzzzzzzzzzzzzzz";

        for(int i=0;i<str.size();i++){
            if(str.get(i).compareTo(min)<0){
                min=str.get(i);
            }
        }

        return min;
    }
}