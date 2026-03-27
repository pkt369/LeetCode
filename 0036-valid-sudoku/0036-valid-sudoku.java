class Solution {
    public boolean isValidSudoku(char[][] board) {
        List<Set<Integer>> columns = new ArrayList<>();
        List<Set<Integer>> boxes = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            columns.add(new HashSet<>());
            boxes.add(new HashSet<>());
        }

        for (int i = 0; i < 9; i++) {
            int[] rows = new int[9];
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    continue;
                }
                int cell = board[i][j] - '0' - 1;
                // System.out.println(cell);
                rows[cell]++;
                if (rows[cell] > 1) {
                    return false;
                }

                Set<Integer> column = columns.get(j);
                // System.out.print("몇번째: " + i + ", ");
                // System.out.println(column.toString());
                if (column.contains(cell)) {
                    return false;
                }
                column.add(cell);

                Set<Integer> box = boxes.get((i / 3) * 3 + (j / 3));
                if (box.contains(cell)) {
                    return false;
                }
                box.add(cell);
            }
        }
        return true;
    }
}

// [".",".","4",".",".",".","6","3","."]
// [".",".",".",".",".",".",".",".","."]
// ["5",".",".",".",".",".",".","9","."]
// [".",".",".","5","6",".",".",".","."]
// ["4",".","3",".",".",".",".",".","1"]
// [".",".",".","7",".",".",".",".","."]
// [".",".",".","5",".",".",".",".","."]
// [".",".",".",".",".",".",".",".","."]
// [".",".",".",".",".",".",".",".","."]