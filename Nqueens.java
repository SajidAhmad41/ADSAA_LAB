class NQueens {
    private int N; // Board size

    public NQueens(int N) {
        this.N = N;
    }

    public void solve() {
        int[][] board = new int[N][N];
        if (solveNQueens(board, 0)) {
            printBoard(board);
        } else {
            System.out.println("No solution exists.");
        }
    }

    private boolean solveNQueens(int[][] board, int row) {
        if (row == N) {
            return true; // All queens are placed
        }

        for (int col = 0; col < N; col++) {
            if (isSafe(board, row, col)) {
                board[row][col] = 1; // Place queen
                if (solveNQueens(board, row + 1)) {
                    return true;
                }
                board[row][col] = 0; // Backtrack
            }
        }
        return false;
    }

    private boolean isSafe(int[][] board, int row, int col) {
        for (int i = 0; i < row; i++) {
            if (board[i][col] == 1) {
                return false; // Check column
            }
        }

        for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 1) {
                return false; // Check upper-left diagonal
            }
        }

        for (int i = row, j = col; i >= 0 && j < N; i--, j++) {
            if (board[i][j] == 1) {
                return false; // Check upper-right diagonal
            }
        }

        return true;
    }

    private void printBoard(int[][] board) {
        for (int[] row : board) {
            for (int cell : row) {
                System.out.print(cell == 1 ? "Q " : ". ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int N = 8; // Change N for different board sizes
        NQueens queens = new NQueens(N);
        queens.solve();
    }
}
