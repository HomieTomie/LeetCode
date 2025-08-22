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
    //DFS 1
    public int dfs(Stack<TreeNode> s){
        while(true){
            TreeNode node = s.pop();
            System.out.println(node.val);
            if(node.right!=null) s.push(node.right);
            if(node.left!=null) s.push(node.left);
            if(node.left == null && node.right == null) return node.val;
        }
    }
    //DFS 2
    public void collectLeafValues(TreeNode root, List<Integer> leafValues){
        if (root == null) return;
        if(root.left == null && root.right == null) leafValues.add(root.val);
        if(root.right!=null) collectLeafValues(root.right, leafValues);
        if(root.left!=null) collectLeafValues(root.left, leafValues);
    }

    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        //DFS 1
        // if(root1==null || root2==null) return false;
        // Stack<TreeNode> s1 = new Stack<>(), s2 = new Stack<>();
        // s1.push(root1); s2.push(root2);
        // while(!s1.empty() && !s2.empty())
        //     if (dfs(s1) != dfs(s2)) return false;
        // return s1.empty() && s2.empty();

        //DFS 2
        List<Integer> leafValues1 = new ArrayList<>();
        List<Integer> leafValues2 = new ArrayList<>();

        collectLeafValues(root1, leafValues1);
        collectLeafValues(root2, leafValues2);

        return leafValues1.equals(leafValues2);



        //BFS (does not maintain the proper order)
    //     Queue<TreeNode> root1Leaves = new LinkedList<>();
    //     Queue<TreeNode> root2Leaves = new LinkedList<>();
    //     Queue<TreeNode> temporary = new LinkedList<>();

    //     temporary.add(root1);
    //     while(!temporary.isEmpty()){
    //         int levelLength = temporary.size();
    //         for(int i = 0; i<levelLength; i++){
    //             TreeNode node = temporary.poll();
    //             if(node.left!= null) temporary.add(node.left);
    //             if(node.right!= null) temporary.add(node.right);
    //             if(node.left==null && node.right==null){
    //                 System.out.println(node.val);
    //                 root1Leaves.add(node);
    //             }
    //         }
    //     }
    //     System.out.println("-------------------");
    //     temporary.add(root2);
    //     while(!temporary.isEmpty()){
    //         int levelLength = temporary.size();
    //         for(int i = 0; i<levelLength; i++){
    //             TreeNode node = temporary.poll();
    //             if(node.left!= null) temporary.add(node.left);
    //             if(node.right!= null) temporary.add(node.right);
    //             if(node.left==null && node.right==null){
    //                 System.out.println(node.val);
    //                 root2Leaves.add(node);
    //             }
    //         }
    //     }

    //     return (root1Leaves == root2Leaves);
    }
}