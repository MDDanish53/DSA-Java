class UniquePaths {
  public int uniquePaths(int m, int n) {
    int[][] grid = new int[m][n];

    // iterate over the grid
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        // if we are at first row or first column then there is only one way to reach
        // that cell
        if (i == 0 || j == 0) {
          grid[i][j] = 1;
        } else {
          // memoize the number of ways to reach that cell
          grid[i][j] = grid[i][j - 1] + grid[i - 1][j];
        }
      }
    }
    // return the number of ways to reach the last cell
    return grid[m - 1][n - 1];
  }
}