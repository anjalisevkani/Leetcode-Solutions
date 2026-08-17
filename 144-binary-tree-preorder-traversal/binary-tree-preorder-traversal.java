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
class TreeNode{
    int data;
    TreeNode left;
    TreeNode right;
    TreeNode(int val){
        data=val;
        left=null;
        right=null;
    }
}

class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> arr=new ArrayList<>();
        preorder(root,arr);
        return arr;
    }
    public void preorder(TreeNode root,List<Integer> arr){
        if(root==null){
            return;
        }
        arr.add(root.data);
        preorder(root.left,arr);
        preorder(root.right,arr);
    }
}