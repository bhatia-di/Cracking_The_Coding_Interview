package bfsdfs;

public class NumberOfIslands {
        int R;
        int C;
        int rowOffset[] = {1, 0, 0, -1};
        int colOffset[] = {0, 1, -1, 0};



        public int numIslands(char[][] grid) {
            int count = 0;
            this.R = grid.length;
            this.C = grid[0].length;
            boolean[][] visited = new boolean[R][C];

            for(int i = 0; i < R; i++) {

                for(int j = 0; j < C; j++) {

                    if(!visited[i][j] && grid[i][j] == '1') {
                        dfs(grid, visited, i, j);
                        count++;
                    }
                }

            }

            return count;
        }

        private void dfs(char[][] grid, boolean[][] visited, int row, int col) {

            visited[row][col] = true;

            for(int i = 0; i < 4; i++) {

                int newRow = rowOffset[i] + row;
                int newCol = colOffset[i] + col;

                if(isSafe(grid, visited, newRow, newCol)) {
                    dfs(grid, visited, newRow, newCol);
                }
            }

        }

        private boolean isSafe(char[][] grid, boolean[][] visited, int row, int col) {
            return (row < R) && (row >= 0) && (col < C) && (col >= 0) && !visited[row][col] && grid[row][col] == '1';
        }
}
