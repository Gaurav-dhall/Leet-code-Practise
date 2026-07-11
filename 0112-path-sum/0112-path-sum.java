class Solution {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;  // no path exists in an empty tree
        }

        // subtract current node's value
        targetSum -= root.val;

        // if leaf, check if remaining sum is 0
        if (root.left == null && root.right == null) {
            return targetSum == 0;
        }

        // recurse on children
        return hasPathSum(root.left, targetSum) ||
               hasPathSum(root.right, targetSum);
    }
}