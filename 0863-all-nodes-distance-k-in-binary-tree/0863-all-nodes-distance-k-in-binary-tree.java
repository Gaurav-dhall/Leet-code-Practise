/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        List<Integer> ans= new ArrayList<>();
        Queue<TreeNode> q= new ArrayDeque<>();
        Map<TreeNode,TreeNode> pp= new HashMap<>();
        pp.put(root,null);

        q.offer(root);

        while(!q.isEmpty()){
            TreeNode curr=q.poll();
            if(curr.left!=null){
                q.offer(curr.left);
                pp.put(curr.left,curr);
            }

            if(curr.right!=null){
                q.offer(curr.right);
                pp.put(curr.right,curr);
            }
        }

        int dist=0;
        q.offer(target);
        Set<TreeNode> vis=new HashSet<>();
        vis.add(target);

        while(dist!=k){
            int size=q.size();
            for(int i=0;i<size;i++){
                TreeNode curr=q.poll();
                if(curr.left!=null&&!vis.contains(curr.left)){
                    q.offer(curr.left);
                    vis.add(curr.left);
                }
                if(curr.right!=null&&!vis.contains(curr.right)){
                    q.offer(curr.right);
                    vis.add(curr.right);
                }
                if(pp.containsKey(curr)&&pp.get(curr)!=null&&!vis.contains(pp.get(curr))){
                    q.offer(pp.get(curr));
                    vis.add(pp.get(curr));
                }

            }

            dist++;
        }

        while(!q.isEmpty()){
            ans.add(q.poll().val);
        }

        return ans;

    }
}