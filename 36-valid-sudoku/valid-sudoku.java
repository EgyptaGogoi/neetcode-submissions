class Solution {
    private char[][] board;
    private Set<Character> set;

    private boolean rowValidator() {
        for (int i = 0; i < 9; i++) {
            this.set = new HashSet<>();

            for (int j = 0; j < 9; j++) {
                char ch = board[i][j];

                if (ch == '.')
                    continue;

                if (set.contains(ch))
                    return false;

                set.add(ch);
            }
        }

        return true;
    }

    private boolean colValidator() {
        for (int j = 0; j < 9; j++) {
            this.set = new HashSet<>();

            for (int i = 0; i < 9; i++) {
                char ch = board[i][j];

                if (ch == '.')
                    continue;

                if (set.contains(ch))
                    return false;

                set.add(ch);
            }
        }

        return true;
    }

    private boolean boxValidator() {
        for (int row = 0; row < 9; row += 3) {
            for (int col = 0; col < 9; col += 3) {

                this.set = new HashSet<>();

                for (int i = row; i < row + 3; i++) {
                    for (int j = col; j < col + 3; j++) {
                        char ch = board[i][j];

                        if (ch == '.')
                            continue;

                        if (set.contains(ch))
                            return false;

                        set.add(ch);
                    }
                }
            }
        }

        return true;
    }

    public boolean isValidSudoku(char[][] board) {
        this.board = board;

        return rowValidator()
            && colValidator()
            && boxValidator();
    }
}