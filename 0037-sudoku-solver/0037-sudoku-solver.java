class Solution {
    public void solveSudoku(char[][] board) {
         backtrack(board);
    }
    
    // Backtracking function to solve the Sudoku puzzle
    private boolean backtrack(char[][] board) {
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                // Look for an empty cell
                if (board[row][col] == '.') {
                    // Try placing digits 1-9
                    for (char num = '1'; num <= '9'; num++) {
                        if (isValid(board, row, col, num)) {
                            board[row][col] = num; // Place the number
                            // Recur to solve the next cell
                            if (backtrack(board)) {
                                return true; // Puzzle solved
                            }
                            // Backtrack: remove the number if it leads to a dead end
                            board[row][col] = '.';
                        }
                    }
                    return false; // No valid number found, trigger backtracking
                }
            }
        }
        return true; // All cells are filled
    }
    
    // Check if it's valid to place 'num' in the position (row, col)
    private boolean isValid(char[][] board, int row, int col, char num) {
        for (int i = 0; i < 9; i++) {
            // Check the row, column, and the 3x3 sub-box
            if (board[row][i] == num || board[i][col] == num || 
                board[(row / 3) * 3 + i / 3][(col / 3) * 3 + i % 3] == num) {
                return false;
            }
        }
        return true; // It's safe to place the number
        
    }
}