import java.io.*;
import java.util.*;

public class Main {

	static int N;
	static int[][] cost;

    public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		cost = new int[N][3];
		StringTokenizer st;
		for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            cost[i][0] = Integer.parseInt(st.nextToken());
            cost[i][1] = Integer.parseInt(st.nextToken());
            cost[i][2] = Integer.parseInt(st.nextToken());
        }
		
	    System.out.println(dp(cost));
		
        br.close();
    }
	
	static int dp(int[][] cost) {

		// DP 배열 초기화
        int[][] dp = new int[N][3];
        
        // 첫 번째 집의 비용은 그대로 설정
        dp[0][0] = cost[0][0];
        dp[0][1] = cost[0][1];
        dp[0][2] = cost[0][2];
        
        // 두 번째 집부터 N번째 집까지 최소 비용을 구한다
        for (int i = 1; i < N; i++) {
            dp[i][0] = Math.min(dp[i-1][1], dp[i-1][2]) + cost[i][0];
            dp[i][1] = Math.min(dp[i-1][0], dp[i-1][2]) + cost[i][1];
            dp[i][2] = Math.min(dp[i-1][0], dp[i-1][1]) + cost[i][2];
        }

		// 마지막 집 - 최소 비용 출력
		return Math.min(Math.min(dp[N-1][0], dp[N-1][1]), dp[N-1][2]);
	}


}
