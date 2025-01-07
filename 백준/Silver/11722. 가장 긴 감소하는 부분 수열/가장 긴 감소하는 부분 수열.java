import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt();  // 수열 크기
        int[] arr = new int[N];  
        for (int i=0; i<N; i++) arr[i] = sc.nextInt();
        
        int[] dp = new int[N];
        
        // 각 원소가 최소 1, 감소하는 부분 수열, dp[i]는 1로 시작
        for (int i=0; i<N; i++) dp[i] = 1;
        
        for (int i=1; i<N; i++) {
            for (int j=0; j<i; j++) {
                if (arr[i] < arr[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        
        // 가장 큰 값
        int result = 0;
        for (int i = 0; i < N; i++) {
            result = Math.max(result, dp[i]);
        }
        
        System.out.println(result);
    }
}