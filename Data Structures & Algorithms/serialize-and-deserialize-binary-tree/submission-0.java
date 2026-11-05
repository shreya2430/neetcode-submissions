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

public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        preOrder(root,sb);
        sb.deleteCharAt(sb.length()-1);
        return sb.toString();
    }

    void preOrder(TreeNode root, StringBuilder sb){
        if(root == null){
            sb.append("null,");
            return;
        }
        sb.append(root.val + ",");
        preOrder(root.left, sb);
        preOrder(root.right, sb);
    }

    // Decodes your encoded data to tree.

    public TreeNode deserialize(String data) {
        String[] tokens = data.split(",");
        return preOrderDesearlize(tokens);
    }
    int preIdx = 0;
    TreeNode preOrderDesearlize(String[] tokens){
        if(tokens == null || tokens.length == 0 || preIdx >= tokens.length ||       tokens[preIdx].equals("null")){
            return null;
        }

        TreeNode root = new TreeNode(Integer.parseInt(tokens[preIdx]));
        preIdx++;
        root.left = preOrderDesearlize(tokens);
        preIdx++;
        root.right = preOrderDesearlize(tokens);
        return root;
    }
}
