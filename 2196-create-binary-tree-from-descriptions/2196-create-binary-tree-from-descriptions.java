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
    private static final TreeNode[] nodes = new TreeNode[100001];
    public TreeNode createBinaryTree(int[][] descriptions) {
       for (int[] x : descriptions) {
            nodes[x[0]] = null;
        }
        for (int[] x : descriptions) {
            nodes[x[1]] = new TreeNode(x[1]);
        }
        TreeNode root = null;
        for (int[] x : descriptions) {
            if (nodes[x[0]] == null) {
                root = nodes[x[0]] = new TreeNode(x[0]);
            }
            if (x[2] == 1) {
                nodes[x[0]].left = nodes[x[1]];
            } else {
                nodes[x[0]].right = nodes[x[1]];
            }
        }
        return root;
    }
}