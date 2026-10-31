class Solution {
    int mod = 1000000007;
    Integer[][][]dp;
    public int uniquePaths(int[][] grid) {
        dp = new Integer[grid.length][grid[0].length][2];
        return kaam(0,0,grid,-1);
    }

    public int kaam(int i, int j, int[][]grid, int ch){
        if(i>grid.length-1 || j>grid[0].length-1){
            return 0;
        }
        if(i==grid.length-1 && j==grid[0].length-1){
            return 1;
        }
        if(ch!=-1 && dp[i][j][ch]!=null){
            return dp[i][j][ch];
        }
        int ans = 0;
        if(grid[i][j]==1){
            if(ch==1){
                ans = (ans +kaam(i+1,j,grid,0))%mod;
            }else{
                ans = (ans+kaam(i,j+1,grid,1))%mod;;
            }
        }else{
            ans = (ans +kaam(i+1,j,grid,0))%mod;
            ans = (ans+kaam(i,j+1,grid,1))%mod;
        }
        if(ch==-1){
            return ans;
        }
        dp[i][j][ch] = ans;
        return ans;
    }
}