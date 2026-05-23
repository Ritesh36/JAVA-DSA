public class DP {

    // Memoization technique
    public static int fib(int n, int f[]) {
        if (n == 0 || n == 1) {
            return n;
        }

        if (f[n] != 0) { // means already filled
            return f[n];
        }

        f[n] = fib(n - 1, f) + fib(n - 2, f);
        return f[n];
    }

    public static int fibTabulization(int n) {
        int dp[] = new int[n+1];
        if (n == 0 || n == 1) {
            return n;
        }

        dp[0] = 0;
        dp[1] = 1;

        for (int i=2; i<=n; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }
        
        return dp[n];
    }

    public static int countWays(int n, int ways[]) {
        if (n == 0) {
            return 1;
        }

        if (n < 0) {
            return 0;
        }

        if (ways[n] != 0) {
            return ways[n];
        }

        ways[n] = countWays(n - 1, ways) + countWays(n - 2, ways);
        return ways[n];
    }

    public static int countWaysTab(int n) {
        int dp[] = new int[n+1];
        dp[0] = 1;

        for (int i=1; i<=n; i++) {
            if (i == 1) {
                dp[i] = dp[i-1] + 0;
            } else {
                dp[i] = dp[i-1] + dp[i-2];
            }
        }

        return dp[n];
    }
    public static void main(String[] args) {
        // int n = 6;
        // int f[] = new int[n+1];
        // System.out.println(fib(n, f));
        // System.out.println(fibTabulization(n));

        int n = 5;
        int ways[] = new int[n+1];
        System.out.println(countWays(n, ways));
        System.out.println(countWaysTab(n));
    }
}