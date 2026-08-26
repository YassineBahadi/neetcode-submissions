class Solution {

    private int ROWS;
    private int COLS;

    private final int[][] directions = {
            {1, 0},
            {-1, 0},
            {0, 1},
            {0, -1}
    };

    public List<List<Integer>> pacificAtlantic(int[][] heights) {

        ROWS = heights.length;
        COLS = heights[0].length;

        boolean[][] pacific = new boolean[ROWS][COLS];
        boolean[][] atlantic = new boolean[ROWS][COLS];

        // Première et dernière colonne
        for (int r = 0; r < ROWS; r++) {
            dfs(heights, r, 0, pacific);
            dfs(heights, r, COLS - 1, atlantic);
        }

        // Première et dernière ligne
        for (int c = 0; c < COLS; c++) {
            dfs(heights, 0, c, pacific);
            dfs(heights, ROWS - 1, c, atlantic);
        }

        List<List<Integer>> result = new ArrayList<>();

        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {

                if (pacific[r][c] && atlantic[r][c]) {
                    result.add(Arrays.asList(r, c));
                }

            }
        }

        return result;
    }

    private void dfs(int[][] heights, int row, int col, boolean[][] visited) {

        visited[row][col] = true;

        for (int[] dir : directions) {

            int newRow = row + dir[0];
            int newCol = col + dir[1];

            if (newRow < 0 || newRow >= ROWS ||
                newCol < 0 || newCol >= COLS) {
                continue;
            }

            if (visited[newRow][newCol]) {
                continue;
            }

            // On ne peut aller que vers une hauteur >=
            if (heights[newRow][newCol] < heights[row][col]) {
                continue;
            }

            dfs(heights, newRow, newCol, visited);
        }
    }
}