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
    public int goodNodes(TreeNode root) {
        dfs(root, Integer.MIN_VALUE);
        return goodNodes;
    }
    private void dfs(TreeNode root, int prevMax){
        if(root == null){
            return;
        }
        if(root.val >= prevMax){
            goodNodes++;
            prevMax = root.val;
        }
        dfs(root.left, prevMax);
        dfs(root.right, prevMax);
    }
}
