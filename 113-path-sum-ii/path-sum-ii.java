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
    List<List<Integer>> ans=new ArrayList<>();
    private void pathSum(TreeNode root, int currentSum,int targetSum,List<Integer> path){
        if(root==null){
            return;
        }
        path.add(root.val);
        currentSum+=root.val;
        if(root.left==null && root.right==null){
            if(currentSum==targetSum){
                ans.add(new ArrayList<>(path));

            }
            path.remove(path.size()-1);
            return;

        }
        pathSum(root.left,currentSum,targetSum,path);
        pathSum(root.right,currentSum,targetSum,path);
        path.remove(path.size() - 1);

    }
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        pathSum(root,0,targetSum,new ArrayList<>());
        return ans;
    }
}