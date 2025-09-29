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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> ans = new ArrayList<>();
        find(root, ans, "");
        return ans;
    }

    public void find(TreeNode node, List<String> list, String s) {
        String combine = "->";
        if (s == "") {
            combine = "";
        }
        if (node.left == null && node.right == null) {
            list.add(s + combine + node.val);
            return;
        }
        if (node.left != null) {
            find(node.left, list, s + combine + node.val);
        }
        if (node.right != null) {
            find(node.right, list, s + combine + node.val);
        }
        
    }
}