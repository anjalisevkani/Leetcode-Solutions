class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int n=nums.length;
        int totalSum=0;
        for(int i=0;i<n;i++){
            totalSum+=nums[i];
        }
        int sum=(totalSum+target)/2;
        if((totalSum+target)%2==1){
            return 0;
        }
        if(Math.abs(target)>totalSum){
            return 0;
        }
        return countSubsets(nums,sum);
    }
    static int countSubsets(int[] nums,int sum){
        int n=nums.length;
        int[][] dp=new int[n+1][sum+1];
        dp[n][0]=1;
        for(int i=n-1;i>=0;i--){
            for(int j=0;j<=sum;j++){
                if(nums[i]>j){
                    dp[i][j]=dp[i+1][j];
                }else{
                    dp[i][j]=dp[i+1][j-nums[i]] + dp[i+1][j];
                }
            }
        }
        return dp[0][sum];
    }
}