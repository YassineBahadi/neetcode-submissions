class Solution {
    public int numIslands(char[][] grid) {
        int rows=grid.length;
        int cols=grid[0].length;

        boolean[][] visited = new boolean[rows][cols];

        int islands=0;

        for(int r=0;r<rows ; r++){
            for(int c=0;c<cols;c++){
                if(grid[r][c]=='1' && !visited[r][c]){
                    bfs(grid,visited,r,c);
                    islands++;
                }
            }
        }
        return islands;
    }
    private void bfs(char[][]grid,boolean[][] visited,int row,int col){
        int [][]dirs={
            {1,0},
            {-1,0},
            {0,1},
            {0,-1}

        };

        Queue<int[]> q = new LinkedList<>();

        q.offer(new int[]{row,col});
        visited[row][col]=true;

        while(!q.isEmpty()){
            int [] cur=q.poll();

            int r=cur[0];
            int c=cur[1];

            for(int[]d:dirs){
                int nr=r+d[0];
                int nc=c+d[1];
                if(nr>=0 && nr<grid.length && nc>=0 && nc<grid[0].length && grid[nr][nc]=='1' && !visited[nr][nc]){
                    visited[nr][nc]=true;
                    q.offer(new int[]{nr, nc});
                }
            }
        }
    }

}
