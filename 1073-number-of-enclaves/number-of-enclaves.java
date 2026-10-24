class Solution {
    int[] x={-1,1,0,0};
    int[] y={0,0,-1,1};
    void dfs(int[][] grid,int r,int c){
        int n=grid.length;
        int m=grid[0].length;
        if(r<0||c<0||r>=n||c>=m||grid[r][c]==0){
            return;
        }
        grid[r][c]=0;
        for(int d=0;d<4;d++){
            dfs(grid,r+x[d],c+y[d]);
        }
    }
    public int numEnclaves(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        for(int j=0;j<m;j++){
            if(grid[0][j]==1){
                dfs(grid,0,j);
            }
            if(grid[n-1][j]==1){
                dfs(grid,n-1,j);
            }
        }
        for(int i=0;i<n;i++){
            if(grid[i][0]==1){
                dfs(grid,i,0);
            }
            if(grid[i][m-1]==1){
                dfs(grid,i,m-1);
            }
        }
        int count=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==1){
                    count++;
                }
            }
        }
        return count;
        
    }
}