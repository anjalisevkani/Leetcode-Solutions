/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    TreeNode ans=null;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(p.val<q.val){
            findLCA(root,p,q);
        }else{
            findLCA(root,q,p);
        }
        return ans;
        
    }
    private int findLCA(TreeNode root, TreeNode p, TreeNode q){
        if(root==null){
            return 0;
        }
        else if(root.val<p.val){
            findLCA(root.right,p,q);
        }
        else if(root.val>q.val){
            findLCA(root.left,p,q);
        }
        else{
            ans=root;
        }
        return root.val;
    }
}