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
        findLCA(root,p,q);
        return ans;
    }
    private int findLCA(TreeNode node,TreeNode p,TreeNode q){
        if(node==null){
            return 0;
        }
        int left=findLCA(node.left,p,q);
        int right=findLCA(node.right,p,q);
        int self=0;
        if(node==p||node==q){
            self=1;
        }
        int total=left+self+right;
        if(total==2 && ans==null){
            ans=node;
        }
        return total;


    }
}