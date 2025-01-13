import java.io.*;
import java.util.*;

public class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken()); // 전깃줄 개수
        
        int[][] lines = new int[N][2];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            lines[i][0] = Integer.parseInt(st.nextToken());  // A 전봇대 위치
            lines[i][1] = Integer.parseInt(st.nextToken());  // B 전봇대 위치
        }
        
        // A 전봇대 위치 기준 정렬
        Arrays.sort(lines, (a, b) -> Integer.compare(a[0], b[0]));
        
        // B 전봇대 위치 따로 배열 저장
        int[] bPositions = new int[N];
        for (int i = 0; i < N; i++) {
            bPositions[i] = lines[i][1];
        }
        
        // DP - LIS 계산
        int[] dp = new int[N];
        Arrays.fill(dp, 1);  // 각 전깃줄은 최소 1개 LIS 형성
        
        for (int i = 1; i < N; i++) {
            for (int j = 0; j < i; j++) {
                if (bPositions[i] > bPositions[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        
        // LIS 최대 길이
        int lisMaxLength = 0;
        for (int i = 0; i < N; i++) {
            lisMaxLength = Math.max(lisMaxLength, dp[i]);
        }
        
        // 최소 제거 전깃줄 개수 = 전체 전깃줄 수 - LIS 길이
        System.out.println(N - lisMaxLength);
        
        br.close();
    }
}
