class SetZeroes {

  public void setZeroes(int matrix[][]) {
    boolean zeroIdx[] = new boolean[matrix.length];
    boolean idx[] = new boolean[matrix[0].length];

    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix[i].length; j++) {
        if (matrix[i][j] == 0) {
          zeroIdx[i] = true; // to make current sub array as zero array
          idx[j] = true; // to make idx of every sub array as zero
        }
      }
    }

    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix[i].length; j++) {
        if (zeroIdx[i] == true) {
          matrix[i] = new int[matrix[i].length];
        } else if (idx[j] == true) {
          matrix[i][j] = 0;
        }
      }
    }
  }

  public void setZeroes2(int matrix[][]) {
    boolean rowZero[] = new boolean[matrix.length];
    boolean colZero[] = new boolean[matrix[0].length];

    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix[i].length; j++) {
        if (matrix[i][j] == 0) {
          rowZero[i] = true;
          colZero[j] = true;
        } else {
          if (colZero[j] == true) {
            matrix[i][j] = 0;
          }
        }
      }
    }

    for(int i = 0; i < matrix.length; i++) {
      for(int j = 0; j < matrix[i].length; j++) {
        if(rowZero[i] == true) {
          matrix[i] = new int[matrix[i].length];
        } else if(colZero[j] == true) {
          matrix[i][j] = 0;
        }
      }
    }
  }

  // optimized one
  public void setZeroes3(int matrix[][]) {
    boolean firstRow = false, firstCol = false;

    // set markers in first row and first column
    for(int i = 0; i < matrix.length; i++) {
      for(int j = 0; j < matrix[i].length; j++) {
        if(matrix[i][j] == 0) {
          if(i == 0) firstRow = true;
          if(j == 0) firstCol = true;
          matrix[0][j] = 0;
          matrix[i][0] = 0;
        }
      }
    }

    // Replace inner matrix
    for(int i = 1; i < matrix.length; i++) {
      for(int j = 1; j < matrix[i].length; j++) {
        if(matrix[i][0] == 0 || matrix[0][j] == 0) {
          matrix[i][j] = 0;
        }
      } 
    }

    // Last remaining checks
    if(firstRow) {
      for(int i = 0; i < matrix[0].length; i++) {
        matrix[0][i] = 0;
      }
    }

    if(firstCol) {
      for(int i = 0; i < matrix.length; i++) {
        matrix[i][0] = 0;
      }
    }
  }

  void main() {
    int matrix[][] = {
      {0, 1, 2, 0},
      {3, 4, 0, 2},
      {1, 3, 1, 5}
    };

    setZeroes3(matrix);

    for (int[] nums : matrix) {
      for (int num : nums) {
        System.out.print(num + " ");
      }
      System.out.println();
    }
  }
}