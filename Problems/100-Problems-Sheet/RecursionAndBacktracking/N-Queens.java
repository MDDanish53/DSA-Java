import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {

  static boolean isSafeToPlace(int rowIndex, int colIndex, int n, char[][] board) {
    // check horizontal left
    int row = rowIndex;
    int col = colIndex;

    while (col >= 0) {
      if (board[row][col] == 'Q') {
        return false;
      }
      col--;
    }

    // check upper left diagonal
    row = rowIndex;
    col = colIndex;

    while (row >= 0 && col >= 0) {
      if (board[row][col] == 'Q') {
        return false;
      }
      row--;
      col--;
    }

    // check lower left diagonal
    row = rowIndex;
    col = colIndex;

    while (row < n && col >= 0) {
      if (board[row][col] == 'Q') {
        return false;
      }
      row++;
      col--;
    }

    return true;

  }

  static void solve(char[][] board, int n, int colIndex, List<List<String>> ans) {
    // base case
    // we've got a valid arrangement, store it in ans
    if (colIndex >= n) {
      List<String> temp = new ArrayList<>();
      for (int i = 0; i < n; i++) {
        temp.add(new String(board[i]));
      }
      ans.add(temp);
      return;
    }

    // go to each cell of current column and place queen
    for (int rowIndex = 0; rowIndex < n; rowIndex++) {
      if (isSafeToPlace(rowIndex, colIndex, n, board)) {
        // place queen
        board[rowIndex][colIndex] = 'Q';
        // go recursively for the rest
        solve(board, n, colIndex + 1, ans);
        // remove the placed queen to check for other possible placements
        board[rowIndex][colIndex] = '.';
      }
    }
  }

  public List<List<String>> solveNQueens(int n) {

    char[][] board = new char[n][n];
    for (int i = 0; i < n; i++) {
      Arrays.fill(board[i], '.');
    }

    int colIndex = 0;
    List<List<String>> ans = new ArrayList<>();

    solve(board, n, colIndex, ans);

    return ans;
  }
}