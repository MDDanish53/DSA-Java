class WordSearch {
  public boolean exist(char[][] board, String word) {
    int m = board.length;
    int n = board[0].length;
    for (int r = 0; r < m; r++) {
      for (int c = 0; c < n; c++) {
        if (board[r][c] == word.charAt(0)) {
          boolean found = dfs(board, r, c, word, 0);
          if (found)
            return true;
        }
      }
    }
    return false;
  }

  public boolean dfs(char[][] board, int r, int c, String word, int wordIndex) {
    // base case - if we've found the word
    if (wordIndex == word.length()) {
      return true;
    }

    // out of bound check
    if (r < 0 || c < 0 || r >= board.length || c >= board[0].length) {
      return false;
    }

    // not matched or alreasy visited
    if (board[r][c] != word.charAt(wordIndex) || board[r][c] == ' ') {
      return false;
    }

    // we have found matching character of word
    char ch = board[r][c];
    board[r][c] = ' ';

    // visit all the four directions of the board to check for further characters
    if (dfs(board, r - 1, c, word, wordIndex + 1) || // up
        dfs(board, r, c + 1, word, wordIndex + 1) || // right
        dfs(board, r + 1, c, word, wordIndex + 1) || // down
        dfs(board, r, c - 1, word, wordIndex + 1)) { // left
      return true;
    }

    // if not found in any direction, then map current found char back to its org
    // char
    board[r][c] = ch;
    return false;
  }
}