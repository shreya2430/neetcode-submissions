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
    int maxSum;
    public int maxPathSum(TreeNode root) {
        maxSum = Integer.MIN_VALUE;
        maxPathSumHelper(root);
        return maxSum;
    }

    private int maxPathSumHelper(TreeNode root){
        if(root == null){
            return 0;
        }
        int left = Math.max(0, maxPathSumHelper(root.left)); //10
        int right = Math.max(0, maxPathSumHelper(root.right)); // 20

        maxSum = Math.max(maxSum, left+right+root.val); //40
        return root.val + Math.max(left, right); // 20 + 15 -> 
    }
}
