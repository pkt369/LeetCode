class Solution {
    int[] memo;
    public int climbStairs(int n) {
        memo = new int[n]; 
        return climbingUsingTabulation(n);
    }

    // dfs
    // time complexity : O (2^n)
    // space complexity : O (n) - stack memory
    public int climbingUsingDfs(int n, int current) {
        if (n < current) {
            return 0;
        }
        if (n == current) {
            return 1;
        }

        return climbingUsingDfs(n, current + 1) + climbingUsingDfs(n, current + 2);
    }

    // memoization
    // time complexity: O(n)
    // space complexity: O(n)
    public int climbingUsingMemo(int n, int current) {
        if (n < current) {
            return 0;
        }
        if (n == current) {
            return 1;
        }
        if (memo[current] != 0) {
            return memo[current];
        }

        memo[current] = climbingUsingMemo(n, current + 1) + climbingUsingMemo(n, current + 2);
        return memo[current];
    }

    // tabulation
    // time complexity: O(n)
    // space complexity: O(n)
    public int climbingUsingTabulation(int n) {
        if (n <= 2) {
            return n;
        }

        memo[0] = 1;
        memo[1] = 2;
        for (int i = 2; i < n; i++) {
            memo[i] = memo[i - 2] + memo[i - 1];
        }
        return memo[n - 1];
    }
}