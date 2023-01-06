import java.util.*;

public class LCS2 {

    private static int lcs2(int[] a, int[] b) {
        int n = a.length; //row
        int m = b.length; //col
        // include an empty string before a and b
        // all initialized to 0
        int dp[][] = new int[n + 1][m + 1];
        // start from 1
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                // when nor matched
                dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                // when matched, update
                if (a[i - 1] == b[j - 1]) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - 1] + 1);
                }
            }
        }
        return dp[n][m];

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }

        int m = scanner.nextInt();
        int[] b = new int[m];
        for (int i = 0; i < m; i++) {
            b[i] = scanner.nextInt();
        }

        System.out.println(lcs2(a, b));
    }
}

