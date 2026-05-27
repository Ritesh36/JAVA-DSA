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

    //Recursion
    public static int knapSack(int val[], int wt[], int capacity, int idx) {
        if (capacity == 0 || idx == 0) {
            return 0;
        }

        if (wt[idx-1] <= capacity) { // valid
            //include
            int pick = val[idx-1] + knapSack(val, wt, capacity - wt[idx-1], idx-1);
            //exclude
            int notPick = 0 + knapSack(val, wt, capacity, idx-1);
            return Math.max(pick, notPick);
        } else { // not valid
            return knapSack(val, wt, capacity, idx-1);
        }
    }

    //Memoization
    public static int knapSackMemo(int val[], int wt[], int capacity, int idx, int dp[][]) {
        if (capacity == 0 || idx == 0) {
            return 0;
        }

        if (dp[idx][capacity] != -1) {
            return dp[idx][capacity];
        }

        if (wt[idx-1] <= capacity) {
            int pick = val[idx-1] + knapSackMemo(val, wt, capacity - wt[idx-1], idx-1, dp);
            int notPick = 0 + knapSackMemo(val, wt, capacity, idx-1, dp);
            dp[idx][capacity] = Math.max(pick, notPick);
            return dp[idx][capacity];
        } else {
            dp[idx][capacity] = knapSackMemo(val, wt, capacity, idx-1, dp);
            return dp[idx][capacity];
        }
    }

    public static int climbStairs(int cost[], int idx, int dp[]) {
        if (idx == 0 || idx == 1) {
            return cost[idx];
        }

        if (idx < 0) {
            return 0;
        }

        if (dp[idx] != 0) {
            return dp[idx];
        }

        int cost1 = climbStairs(cost, idx - 1, dp);
        int cost2 = climbStairs(cost, idx - 2, dp);
        dp[idx] = cost[idx] + Math.min(cost1, cost2);
        return dp[idx];
    }

    public static int houseRobber(int nums[], int idx, int dp[]) {
        if (idx == 0) {
            return nums[idx];
        }

        if (idx < 0) {
            return 0;
        }

        if (dp[idx] != 0) {
            return dp[idx];
        }

        int pick = nums[idx] + houseRobber(nums, idx - 2, dp);
        int notPick = 0 + houseRobber(nums, idx - 1, dp);
        dp[idx] = Math.max(pick, notPick);
        return dp[idx];
    }
    public static void main(String[] args) {
        // int n = 6;
        // int f[] = new int[n+1];
        // System.out.println(fib(n, f));
        // System.out.println(fibTabulization(n));

        // int n = 5;
        // int ways[] = new int[n+1];
        // System.out.println(countWays(n, ways));
        // System.out.println(countWaysTab(n));

        // int val[] = {15, 14, 10, 45, 30};
        // int wt[] = {2, 5, 1, 3, 4};
        // int capacity = 7;
        // int idx = val.length;
        // int dp[][] = new int[idx+1][capacity+1];
        // for (int i=0; i<dp.length; i++) {
        //     for (int j=0; j<dp[0].length; j++) {
        //         dp[i][j] = -1;
        //     }
        // }
        // System.out.println(knapSackMemo(val, wt, capacity, idx, dp));

        // int cost[] = {10, 15, 20};
        // int idx = cost.length - 1;
        // int dp[] = new int[cost.length];
        // System.out.println(climbStairs(cost, idx, dp));

        int nums[] = {5, 15, 6, 20, 22};
        int idx = nums.length - 1;
        int dp[] = new int[nums.length];
        System.out.println(houseRobber(nums, idx, dp));

    }
}