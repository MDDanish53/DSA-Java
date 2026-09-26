class SudokuSolver {

  static boolean findEmptyCell(char[][] board, int[] emptyCell) {
    for (int i = 0; i < 9; i++) {
      for (int j = 0; j < 9; j++) {
        if (board[i][j] == '.') {
          // store empty cell's row
          emptyCell[0] = i;
          // store empty cell's column
          emptyCell[1] = j;
          return true;
        }
      }
    }
    // no empty cell found
    return false;
  }

  static boolean isSafeToPlace(char[][] board, char charValue, int rowIndex, int colIndex) {

    // check if charValue exists in the same row
    for (int col = 0; col < 9; col++) {
      if (board[rowIndex][col] == charValue) {
        return false;
      }
    }

    // check if charValue exists in the same column
    for (int row = 0; row < 9; row++) {
      if (board[row][colIndex] == charValue) {
        return false;
      }
    }

    // check if charValue exists in current 3x3 grid
    int startRow = rowIndex - rowIndex % 3;
    int startCol = colIndex - colIndex % 3;

    // travel over the 3x3 grid
    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 3; j++) {
        int actualRow = i + startRow;
        int actualCol = j + startCol;
        if (board[actualRow][actualCol] == charValue) {
          return false;
        }
      }
    }

    return true;
  }

  static boolean solveSudokuHelper(char[][] board) {
    // base case - if all cells are filled then the problem is solved
    int[] emptyCell = new int[2];
    if (!findEmptyCell(board, emptyCell)) {
      return true;
    }

    // if we found an empty cell
    int rowIndex = emptyCell[0];
    int colIndex = emptyCell[1];

    for (int val = 1; val <= 9; val++) {
      char charValue = (char) (val + '0');
      if (isSafeToPlace(board, charValue, rowIndex, colIndex)) {
        // place it
        board[rowIndex][colIndex] = charValue;
        // recursive call for further placements, if all the cells are filled then the
        // problem is solved so return true
        if (solveSudokuHelper(board) == true) {
          return true;
        }

        // if control came back so remove the current placed value and try with other
        // values
        board[rowIndex][colIndex] = '.';
      }
    }

    // not able to place value
    return false;
  }

  public void solveSudoku(char[][] board) {
    solveSudokuHelper(board);
  }
}