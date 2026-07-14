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

 class Member{
    TreeNode node;
    int row;
    int col;

    Member(TreeNode n,int r,int c){
        this.node=n;
        this.row=r;
        this.col=c;
    }
 }
class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        Queue<Member> q= new ArrayDeque<>();
        TreeMap<Integer,TreeMap<Integer,PriorityQueue<Integer>>> map = new TreeMap<>();
        q.offer(new Member(root,0,0));

        while(!q.isEmpty()){
            Member curr= q.poll();
            TreeNode currNode=curr.node;
            int currRow=curr.row;
            int currCol=curr.col;

            if(!map.containsKey(currCol)){
                map.put(currCol,new TreeMap<>());
            }

            if(!map.get(currCol).containsKey(currRow)){
                map.get(currCol).put(currRow,new PriorityQueue<>());
            }

            map.get(currCol).get(currRow).offer(currNode.val);

            if(currNode.left!=null){
                q.offer(new Member(currNode.left,currRow+1,currCol-1));
            }

            if(currNode.right!=null){
                q.offer(new Member(currNode.right,currRow+1,currCol+1));
            }

        }

        List<List<Integer>> ans= new ArrayList<>();

        for(TreeMap<Integer,PriorityQueue<Integer>> ys:map.values()){
            ans.add(new ArrayList<>());
            for(PriorityQueue<Integer> node:ys.values()){
                while(!node.isEmpty()){
                    ans.get(ans.size()-1).add(node.poll());
                }
            }
        }

        return ans;
    }
}