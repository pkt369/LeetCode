class Solution {
    public int minSessions(int[] tasks, int sessionTime) {
        int n = tasks.length;
        Pair[] dp = new Pair[1 << n];
        Arrays.fill(dp, new Pair(Integer.MAX_VALUE, Integer.MAX_VALUE));
        dp[0] = new Pair(1, 0);

        for (int mask = 0; mask < (1 << n); mask++) {
            for (int i = 0; i < n; i++) {
                if ((mask & (1 << i)) == 1) {
                    continue;
                }
                int newMask = mask | 1 << i;
                if (tasks[i] + dp[mask].used <= sessionTime) {
                    dp[newMask] = minPair(dp[newMask], new Pair(dp[mask].session, dp[mask].used + tasks[i]));
                } else {
                    dp[newMask] = minPair(dp[newMask], new Pair(dp[mask].session + 1, tasks[i]));
                }
            }
        }
        return dp[(1 << n) - 1].session;
    }

    public Pair minPair(Pair a, Pair b) {
        if (a.session > b.session) return b;
        if (a.session < b.session) return a;
        if (a.used > b.used) return b;
        return a;
    }
}

class Pair {
    int session;
    int used;

    public Pair(int session, int used) {
        this.session = session;
        this.used = used;
    }
}