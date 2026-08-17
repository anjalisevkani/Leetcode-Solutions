/**
 * Definition for a binary tree node.
public class TreeNode {
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
        left=right=null;
    }
}

class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> arr=new ArrayList<>();
        in(root,arr);
        return arr;
    }
    public void in(TreeNode root,List<Integer> arr){
        if(root==null){
            return;
        }
        in(root.left,arr);
        arr.add(root.data);
        in(root.right,arr);
    }
}