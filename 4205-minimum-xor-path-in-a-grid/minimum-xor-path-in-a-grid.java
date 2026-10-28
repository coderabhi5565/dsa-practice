class Solution {
    public int minCost(int[][] grid) {
       PriorityQueue<Pair> pq = new PriorityQueue<>((a,b) -> {
           return a.c-b.c;
       });
         int n = grid.length, m = grid[0].length;
        boolean[][][] vis = new boolean[n][m][1024];
        pq.add(new Pair(0,0,grid[0][0]));
        vis[0][0][grid[0][0]] = true;
        int ans = Integer.MAX_VALUE;
        while(!pq.isEmpty()){
            Pair p = pq.poll();
            int row = p.a,col = p.b,xor = p.c;
            if(row==grid.length-1 && col==grid[0].length-1){
               ans = Math.min(ans, xor);
                continue;
            }
            if(col+1<grid[0].length){
               int newx = xor ^ grid[row][col + 1];
                if (!vis[row][col + 1][newx]) {
                    vis[row][col + 1][newx] = true;
                    pq.add(new Pair(row, col + 1, newx));
                }
            }

             if (row+1<n) {
                int newxor = xor ^ grid[row + 1][col];
                if (!vis[row + 1][col][newxor]) {
                    vis[row + 1][col][newxor] = true;
                    pq.add(new Pair(row + 1, col, newxor));
                }
            }
        }
        return ans;
    }
    class Pair{
        int a,b,c;
        public Pair(int a, int b, int c){
            this.a = a;
            this.b = b;
            this.c = c;
        }
    }
}