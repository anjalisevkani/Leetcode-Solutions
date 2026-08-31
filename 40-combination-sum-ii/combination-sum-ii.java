class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> ans=new ArrayList<>();
        find(candidates,0,target,new ArrayList<>(),ans);
        return ans;
    }
    void find(int[] candidates,int index,int target,List<Integer> temp,List<List<Integer>> ans){
        if(target==0){
            ans.add(new ArrayList<>(temp));
            return;
        }
        
        for(int i=index;i<candidates.length;i++){
            if(i>index && candidates[i]==candidates[i-1]){
                continue;
            }
            if(candidates[i]>target){
                break;
            }
            temp.add(candidates[i]);
            find(candidates, i + 1,target - candidates[i], temp, ans);
            temp.remove(temp.size()-1);
        }
    }
}