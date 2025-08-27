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
    int maxLength = 0;

    void goThroughNode(TreeNode root, int length, int direction){
        if (root==null) return;
        maxLength = Math.max(length, maxLength);
        if (direction==0){
            goThroughNode(root.left, length+1, 1);
            goThroughNode(root.right, 1, 0);
        } else {
            goThroughNode(root.right, length+1, 0);
            goThroughNode(root.left, 1, 1);
        }
        return;
    }

    public int longestZigZag(TreeNode root) {
        // Direction - right(0), left(1)
        int currentLength = 0, length = 0;
        goThroughNode(root, length, 0);
        goThroughNode(root, length, 1);
        return maxLength;
    }
}