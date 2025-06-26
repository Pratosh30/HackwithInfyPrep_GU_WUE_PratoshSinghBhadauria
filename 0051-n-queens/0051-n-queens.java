class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> solutions = new ArrayList<>();
        char[][] board = new char[n][n]; // Create an empty board
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.'; // Initialize all positions as empty
            }
        }
        // Arrays to track column and diagonal usage
        boolean[] cols = new boolean[n];          // tracks which columns are used
        boolean[] d1 = new boolean[2 * n];        // tracks major diagonal (row - col)
        boolean[] d2 = new boolean[2 * n];        // tracks minor diagonal (row + col)
        
        backtrack(0, board, solutions, cols, d1, d2, n);
        return solutions;
    }

    private void backtrack(int row, char[][] board, List<List<String>> solutions,
                           boolean[] cols, boolean[] d1, boolean[] d2, int n) {
        if (row == n) { 
            // A valid solution is found, add it to the result list
            solutions.add(construct(board));
            return;
        }

        // Try placing a queen in each column of the current row
        for (int col = 0; col < n; col++) {
            int id1 = row - col + n;  // Major diagonal index
            int id2 = row + col;      // Minor diagonal index
            // Check if placing the queen is safe
            if (!cols[col] && !d1[id1] && !d2[id2]) {
                // Place the queen
                board[row][col] = 'Q';
                cols[col] = d1[id1] = d2[id2] = true; // Mark column and diagonals as occupied
                // Recur to the next row
                backtrack(row + 1, board, solutions, cols, d1, d2, n);
                // Backtrack: remove the queen and mark the column and diagonals as free
                board[row][col] = '.';
                cols[col] = d1[id1] = d2[id2] = false;
            }
        }
    }

    // Helper method to construct the current board configuration as a list of strings
    private List<String> construct(char[][] board) {
        List<String> res = new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            res.add(new String(board[i]));
        }
        return res;
        
    }
}