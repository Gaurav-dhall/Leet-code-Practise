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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        Queue<TreeNode> q1 = new ArrayDeque<>();
        Queue<TreeNode> q2 = new ArrayDeque<>();

        if (p == null || q == null) {
            if (q == null && p == null) {
                return true;
            }
            return false;
        }

        q1.offer(p);
        q2.offer(q);

        while (!q1.isEmpty() || !q2.isEmpty()) {
            int size1 = q1.size();
            int size2 = q2.size();

            if (size1 != size2) {
                return false;
            }
            for (int i = 0; i < size1; i++) {
                TreeNode curr1 = q1.poll();
                TreeNode curr2 = q2.poll();

                if (curr1.val != curr2.val) {
                    return false;
                }

                if ((curr1.left == null) != (curr2.left == null))
                    return false;
                if ((curr1.right == null) != (curr2.right == null))
                    return false;

                if (curr1.left != null) {
                    q1.offer(curr1.left);
                }
                if (curr1.right != null) {
                    q1.offer(curr1.right);
                }

                if (curr2.left != null) {
                    q2.offer(curr2.left);
                }
                if (curr2.right != null) {
                    q2.offer(curr2.right);
                }
            }
        }

        return true;
    }
}