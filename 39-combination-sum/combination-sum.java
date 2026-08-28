class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans=new ArrayList<>();
        findCandidates(candidates,0,target,new ArrayList<>(),ans);
        return ans;
    }
    void findCandidates(int[] candidates,int index,int target,List<Integer> temp,List<List<Integer>> ans){
        if(target==0){
            ans.add(new ArrayList<>(temp));
            return;

        }
        if(index==candidates.length || target<0){
            return;
        }
        temp.add(candidates[index]);
        findCandidates(candidates,index,target-candidates[index],temp,ans);
        temp.remove(temp.size()-1);
        findCandidates(candidates,index+1,target,temp,ans);
    }
}