/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        Queue<TreeNode> q= new LinkedList<>();
        q.offer(root);
        StringBuilder sb= new StringBuilder();

        while(!q.isEmpty()){
            TreeNode curr=q.poll();

            if(curr==null){
                sb.append("n ");
                continue;
            }
            sb.append(curr.val+" ");

            

            q.offer(curr.left);
            q.offer(curr.right);
        }

        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {

        if(data==null||data.length()==0){
            return null;
        }
        String[] arr=data.split(" ");
        Queue<TreeNode> q= new ArrayDeque<>();
        if(arr[0].equals("n")) return null;
        TreeNode root= new TreeNode(Integer.parseInt(arr[0]));
        q.offer(root);

        for(int i=1;i<arr.length;i++){
            TreeNode curr = q.poll();
            if(!arr[i].equals("n")){
                curr.left=new TreeNode(Integer.parseInt(arr[i]));
                q.offer(curr.left);
            }
            if(!arr[++i].equals("n")){
                curr.right= new TreeNode(Integer.parseInt(arr[i]));
                q.offer(curr.right);
            }
        }
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));