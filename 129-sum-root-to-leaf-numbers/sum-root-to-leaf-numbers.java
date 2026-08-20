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
    int totalSum=0;
    public int sumNumbers(TreeNode root) {
        pathSum(root,0);
        return totalSum;
    }
    private void pathSum(TreeNode root,int currentSum){
        if(root==null){
            return;
        }
        currentSum=(currentSum*10)+root.val;
        if(root.left==null && root.right==null){
            totalSum+=currentSum;
            return;
        }
        pathSum(root.left,currentSum);
        pathSum(root.right,currentSum);
    }
}