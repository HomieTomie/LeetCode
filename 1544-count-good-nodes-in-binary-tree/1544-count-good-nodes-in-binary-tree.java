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
    int goodNodes = 0;
    public void recursiveCheck(TreeNode node, int maxValue){
        if (node==null) return;
        if (node.val>=maxValue){
            maxValue=node.val;
            goodNodes++;
        }
        if (node.left!=null) recursiveCheck(node.left, maxValue);
        if (node.right!=null) recursiveCheck(node.right, maxValue);
        return;
    }

    public int goodNodes(TreeNode root) {
        recursiveCheck(root, root.val);
        return goodNodes;
    }
}