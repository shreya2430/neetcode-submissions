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
     Map<Integer, Integer> inorderMap;
     int preIdx;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        inorderMap = new HashMap<>();
        preIdx = 0;
        for(int i=0;i<inorder.length;i++){
            inorderMap.put(inorder[i], i);
        }
        return helper(preorder, 0, preorder.length-1);
    }

    private TreeNode helper(int[] preorder, int left, int right){
        if(left > right){
            return null;
        }
        TreeNode node = new TreeNode(preorder[preIdx++]);
        int idx = inorderMap.get(node.val);
        node.left = helper(preorder, left, idx-1);
        node.right = helper(preorder, idx+1, right);
        return node;
    }
}
