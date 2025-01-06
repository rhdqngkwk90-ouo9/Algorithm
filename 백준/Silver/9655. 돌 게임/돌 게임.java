import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();  // 돌의 개수
        sc.close();
        
        // DP 배열 선언
        boolean[] dp = new boolean[N + 1];
        
        // 초기 상태: 돌이 0개 - 게임을 끝내고 이길 수 X
        dp[0] = false;
        
        // 돌 1개 - 상근이가 이김 (현재 턴이 상근이)
        if (N >= 1) dp[1] = true;
        
        // 돌 3개 - 상근이가 이김 (현재 턴이 상근이)
        if (N >= 3) dp[3] = true;
        
        // DP 테이블 채우기
        for (int i = 2; i <= N; i++) {
            // i개의 돌에서 현재 턴의 사람이 이길 수 있다면
            if (i - 1 >= 0 && !dp[i - 1]) {
                dp[i] = true;  // 1개를 가져가서 상대를 지게 만든다
            } 
            if (i - 3 >= 0 && !dp[i - 3]) {
                dp[i] = true;  // 3개를 가져가서 상대를 지게 만든다
            }
        }
        
        // dp[N]이 true이면 상근이가 이기고, false이면 창영이가 이김
        if (dp[N]) {
            System.out.println("SK");  
        } else {
            System.out.println("CY");  
        }
    }
}