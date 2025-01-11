import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 퇴사 N일전
        
        int[] Ti = new int[N + 6]; // 상담기간
        int[] Pi = new int[N + 6]; // 금액
        int[] dp = new int[N + 6]; // dp[i]는 i일차까지 최대 이익

        StringTokenizer st = null;
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            Ti[i] = Integer.parseInt(st.nextToken()); 
            Pi[i] = Integer.parseInt(st.nextToken()); 
        }

        int max = Integer.MIN_VALUE;
        
        for (int j = 1; j <= N+1; j++) {
            // 상담 X: 현재까지 얻을 수 있는 최대 이익을 dp[j]에 반영
            dp[j] = Math.max(dp[j], max);

            // 상담 O: 상담 진행 후 상담이 끝나는 날에 대한 최대 이익 갱신
            dp[j + Ti[j]] = Math.max(dp[j + Ti[j]], dp[j] + Pi[j]);

            // 현재까지 얻을 수 있는 최대 이익을 max에 갱신
            max = Math.max(max, dp[j]);
        }

        // 마지막 날까지의 최대 이익
        System.out.println(dp[N + 1]);
    }
}
