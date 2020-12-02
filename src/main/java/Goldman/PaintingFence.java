package Goldman;

import java.util.Arrays;

public class PaintingFence {

    public static void main(String[] args) {
        int n = 4;
        int k = 2;
        System.out.println(countWays(n, k));
    }


    static long countWays(int n, int k) {
        // To store results for subproblems
        long dp[] = new long[n + 1];
        Arrays.fill(dp, 0);

        // There are k ways to color first post
        dp[1] = k;

        // There are 0 ways for single post to
        // violate (same color_ and k ways to
        // not violate (different color)
        int same = 0, diff = k;

        // Fill for 2 posts onwards
        for (int i = 2; i <= n; i++) {
            // Current same is same as previous diff
            same = diff;

            // We always have k-1 choices for next post
            diff = (int) (dp[i - 1] * (k - 1));

            // Total choices till i.
            dp[i] = (same + diff);
        }

        System.out.println(Arrays.toString(dp));
        return dp[n];
    }
}
