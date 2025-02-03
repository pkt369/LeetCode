class Solution {
    public boolean divisorGame(int n) {
        return isAliceWinUsingMemo(n, new int[n + 1]);
    }

    // tabulation
    // time complexity: O(n^2)
    // space complexity: O(n)
    public boolean isAliceWin(int n) {
        boolean[] win = new boolean[n + 1];
        win[1] = false;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                if (i % j == 0 && win[i - j] == false) {
                    win[i] = true;
                    break;
                }
            }
        }
        return win[n];
    }

    // dfs
    // time complexity : O(n!)
    // space complexity : O(n) - stack memory
    public boolean isAliceWinUsingDfs(int n) {
        if (n == 1) {
            return false;
        }
        if (n == 2) {
            return true;
        }
        for (int i = 1; i < n; i++) {
            if (n % i == 0 && isAliceWinUsingDfs(n - i) == false) {
                return true;
            }
        }
        return false;
    }

    // memoization
    // time complexity : O(n^2)
    // space complexity : O(n)
    public boolean isAliceWinUsingMemo(int n, int[] memo) {
        if (n == 1) {
            return false;
        }
        if (memo[n] != 0) {
            return memo[n] == 1;
        }
        for (int i = 1; i < n; i++) {
            if (n % i == 0 && isAliceWinUsingMemo(n - i, memo) == false) {
                memo[n] = 1;
                return true;
            }
        }
        memo[n] = -1;
        return false;
    }
}