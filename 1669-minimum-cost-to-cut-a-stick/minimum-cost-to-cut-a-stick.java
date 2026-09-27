class Solution {
    public int minCost(int n, int[] cuts) {
        int m=cuts.length;
        int[] c=new int[m+2];
        c[0]=0;
        c[m+1]=n;
        for(int i=0;i<m;i++){
            c[i+1]=cuts[i];
        }
        Arrays.sort(c);
        int[][] dp = new int[m + 2][m + 2];

        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return solve(c,1,m,dp);


    }
    static int solve(int[] cuts, int i, int j, int[][] dp) {

        if (i > j) {
            return 0;
        }

        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        int res = Integer.MAX_VALUE;

        for (int k = i; k <= j; k++) {

            int cost = cuts[j + 1] - cuts[i - 1];

            int r = cost
                    + solve(cuts, i, k - 1, dp)
                    + solve(cuts, k + 1, j, dp);

            res = Math.min(res, r);
        }

        return dp[i][j] = res;
    }
}