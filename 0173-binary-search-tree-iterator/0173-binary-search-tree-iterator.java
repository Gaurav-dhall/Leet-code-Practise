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
class BSTIterator {

    List<Integer> ans= new ArrayList<>();
    int index=-1;
    public void helper(TreeNode root){
        if(root.left!=null){
            helper(root.left);
        }
        ans.add(root.val);
        if(root.right!=null){
            helper(root.right);
        }

    }

    public BSTIterator(TreeNode root) {
        this.helper(root);
    }
    
    public int next() {
        
        index++;
        return ans.get(index);
    }
    
    public boolean hasNext() {
        if(index<ans.size()-1){
            return true;
        }
        else{
            return false;
        }
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */