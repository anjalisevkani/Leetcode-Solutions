class Solution {
    public int maxProfit(int k, int[] prices) {
        int n=prices.length;
        int[][][] dp =new int[n+1][2][k+1];
        for(int i=n-1;i>=0;i--){
            for(int cap=1;cap<=k;cap++){
                dp[i][1][cap]=Math.max(-prices[i]+dp[i+1][0][cap],dp[i+1][1][cap]);
                dp[i][0][cap]=Math.max(prices[i]+dp[i+1][1][cap-1],dp[i+1][0][cap]);
            }
        }
        return dp[0][1][k];
    }
}