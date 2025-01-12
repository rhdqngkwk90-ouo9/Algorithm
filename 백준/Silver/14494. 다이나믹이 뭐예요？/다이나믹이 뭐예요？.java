import java.io.*;
import java.util.*;

public class Main {
    
    static final int MOD = 1000000007;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        // 경우의 수가 커질 수 있기 때문에 long 배열로 생성한다.
        long[][] dp = new long[n + 1][m + 1];
        dp[1][1] = 1;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                // 위쪽에서 오는 경우
                if (i > 1) dp[i][j] = (dp[i][j] + dp[i-1][j]) % MOD;
                // 왼쪽에서 오는 경우
                if (j > 1) dp[i][j] = (dp[i][j] + dp[i][j-1]) % MOD;
                // 대각선에서 오는 경우
                if (i > 1 && j > 1) dp[i][j] = (dp[i][j] + dp[i-1][j-1]) % MOD;
            }
        }

        System.out.println(dp[n][m]);
    }
}