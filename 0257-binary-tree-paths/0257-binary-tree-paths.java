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
    List<String> ans=new ArrayList<>();
    
    public void findDFS(TreeNode root, StringBuilder sb){
        
        sb.append(root.val);
        sb.append("->");
        
        if(root.left==null&&root.right==null){
            if(sb.length()>0){
              sb.deleteCharAt(sb.length()-1);
            sb.deleteCharAt(sb.length()-1);
              
                
            }
            
            ans.add(sb.toString());
            while(sb.length()>0&&sb.charAt(sb.length()-1)!='>'){
                sb.deleteCharAt(sb.length()-1);
            }
            
            return;
        }
        
        
        
        
        if(root.left!=null){
            findDFS(root.left,sb);
        }
        if(root.right!=null){
            findDFS(root.right,sb);
        }
        
        sb.deleteCharAt(sb.length()-1);
        sb.deleteCharAt(sb.length()-1);
        
        while(sb.length()>0&&sb.charAt(sb.length()-1)!='>'){
                sb.deleteCharAt(sb.length()-1);
            }
        
        
    }
    public List<String> binaryTreePaths(TreeNode root) {
        
        if(root==null){
            return ans;
        }
        findDFS(root, new StringBuilder(""));
        return ans;
    }
}