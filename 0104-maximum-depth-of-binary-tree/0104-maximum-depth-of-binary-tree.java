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
    public int maxDepth(TreeNode root) {
        if (root==null) return 0;

        // DFS
        //return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));

        // BFS
        Queue<TreeNode> q = new LinkedList<>();
        int depth = 0;

        q.add(root);

        while(!q.isEmpty()){
            depth++;

            // This is important as we have to set this before the loop starts otherwise it will go on if there is more
            int levelSize = q.size();

            for(int i = 0; i<levelSize; i++){
                TreeNode node = q.poll();
                if(node.left!=null) q.add(node.left);
                if(node.right!=null) q.add(node.right);
            }
            
        }
        return depth;
    }
}