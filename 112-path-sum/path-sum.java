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
    boolean res=false;
    private void pathSum(TreeNode root,int sum,int targetSum){
        if(root==null){
            return;
        }
        
        sum+=root.val;
        if(root.left==null && root.right==null){
            if(sum==targetSum){
                res=true;
            }
            return;
        }
        pathSum(root.left,sum,targetSum);
        pathSum(root.right,sum,targetSum);

    }
    public boolean hasPathSum(TreeNode root, int targetSum) {
        pathSum(root,0,targetSum);
        return res;

    }
}