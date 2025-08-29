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
    // public List<Integer> rightSideView(TreeNode root) {
    //     Queue<TreeNode> q = new LinkedList<>();
    //     List<Integer> result = new ArrayList<>();
    //     if(root==null) return result;
    //     q.add(root);

    //     while(!q.isEmpty()){
    //         int levelLength = q.size();
    //         for(int i = 0; i<levelLength-1; i++){
    //             TreeNode node = q.poll();
    //             if(node.left!=null) q.add(node.left);
    //             if(node.right!=null) q.add(node.right);
    //         }
    //         TreeNode n = q.poll();
    //         result.add(n.val);
    //         if(n.left!=null) q.add(n.left);
    //         if(n.right!=null) q.add(n.right);
    //     }

    //     return result;
    // }

    public List<Integer> rightSideView(TreeNode root){
        List<Integer> result = new ArrayList<>();
        helperFunction(root, result, 0);
        return result;
    }

    List<Integer> helperFunction(TreeNode root, List<Integer> list, int level){
        if(root==null) return list;

        if(level == list.size()) list.add(root.val); level++;

        if(root.right!=null) helperFunction(root.right, list, level);
        if(root.left!=null) helperFunction(root.left, list, level);
        return list;
    }
}