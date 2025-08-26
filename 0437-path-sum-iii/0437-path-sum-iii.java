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
    int pathCounter = 0;
    void checkEntireTree(TreeNode root, long value, int target){
        if (root==null) return;
        value = value + root.val;
        if(value==target) pathCounter++;
        if(root.right!=null) checkEntireTree(root.right, value, target);
        if(root.left!=null) checkEntireTree(root.left, value, target);
        return;
    }

    void checkEntireTreeForEachNode(TreeNode root, int target){
        if (root==null) return;
        if(root.right!=null) pathSum(root.right, target);
        if(root.left!=null) pathSum(root.left, target);
        return;
    }

    public int pathSum(TreeNode root, int targetSum) {
        checkEntireTree(root, 0L, targetSum);
        checkEntireTreeForEachNode(root, targetSum);
        return pathCounter;
    }
}