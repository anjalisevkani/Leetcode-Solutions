class Solution {
    
    int[] x={-1,1,0,0};
    int[] y={0,0,-1,1};
    boolean valid(int i,int j,int n,int m){
        if(i<0 || j<0 ||i>=n || j>=m){
            return false;

        }
        return true;
    }
    public int orangesRotting(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        Queue<Pair<Integer,Integer>> q=new LinkedList<>();
        int time=0;
        int fresh=0;
        int i,j;
        for(i=0;i<n;i++){
            for(j=0;j<m;j++){
                if(grid[i][j]==2){
                    q.offer(new Pair<>(i,j));
                    grid[i][j]=-2;
                }
                else if(grid[i][j]==1){
                    fresh++;
                }
            }
        }
        while(!q.isEmpty() && fresh>0){
            time++;
            int s=q.size();
            while(s>0){
                s--;
                Pair<Integer,Integer> p=q.poll();
                int r=p.getKey();
                int c=p.getValue();
                for(int k=0;k<4;k++){
                    int row=r+x[k];
                    int col=c+y[k];
                    if(valid(row,col,n,m) && grid[row][col]==1){
                        q.offer(new Pair<>(row,col));
                        grid[row][col]=-2;
                        fresh--;
                    }
                }
            }
        }
        if(fresh>0){
            return -1;
        }
        return time;

    }
}