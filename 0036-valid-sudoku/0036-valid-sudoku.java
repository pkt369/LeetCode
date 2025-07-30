class Solution {
    public boolean isValidSudoku(char[][] board) {
        List<Set<Character>> rows = new ArrayList<>();
        List<Set<Character>> columns = new ArrayList<>();
        List<Set<Character>> squares = new ArrayList<>();

        for (int i = 0; i < 9; i++) {
            rows.add(new HashSet<>());
            columns.add(new HashSet<>());
            squares.add(new HashSet<>());
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                char num = board[i][j];
                if (num == '.') {
                    continue;
                }
                if (rows.get(i).contains(num) || columns.get(j).contains(num)) {
                    System.out.println(num);
                    return false;
                }
                if (squares.get(((i / 3) * 3) + (j / 3)).contains(num)) {
                    System.out.println("squares: " + num);
                    return false;
                }
                rows.get(i).add(num);
                columns.get(j).add(num);
                squares.get(((i / 3) * 3) + (j / 3)).add(num);
            }
        }
        return true;
    }
}