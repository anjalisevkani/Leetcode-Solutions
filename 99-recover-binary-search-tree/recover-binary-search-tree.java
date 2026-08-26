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
    int count=0;
    TreeNode prev=null;
    TreeNode a,b,c,d=null;
    public void inorder(TreeNode root){
        if(root==null){
            return;

        }
        inorder(root.left);
        if(prev==null){
            prev=root;
        }else{
            if(root.val<prev.val){
                if(count==0){
                    a=prev;
                    b=root;
                    count++;
                }else{
                    c=prev;
                    d=root;
                    count++;
                }
            }
            prev=root;
        }
        inorder(root.right);
    }
    public void recoverTree(TreeNode root) {
        inorder(root);
        if(count==1){
            swap(a,b);
        }else{
            swap(a,d);
        }
    }
    public void swap(TreeNode a,TreeNode b){
        int temp=a.val;
        a.val=b.val;
        b.val=temp;
    }
}