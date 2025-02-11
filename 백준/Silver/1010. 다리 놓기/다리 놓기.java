import java.io.*;
import java.util.*;

public class Main {
    
    static int N, M, C;
    static int[][] dp;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int T = Integer.parseInt(st.nextToken()); // 테스트 케이스 개수
        
        // 조합으로 하니까 시간초과 -> dp로 풀기
        dp = new int[30][30];
        
        for (int i=0; i<30; i++) {
            dp[i][0] = 1; 
            dp[i][i] = 1; 
        }
        for (int i=1; i<30; i++) {
            for (int j=1; j<i; j++) {
                dp[i][j] = dp[i-1][j-1] + dp[i-1][j];
            }
        }
        
        for (int i=0; i<T; i++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken()); // 강의 서쪽
            M = Integer.parseInt(st.nextToken()); // 강의 동쪽
            C = 0;
            
            System.out.println(dp[M][N]);
        }
        
        /*
        for (int i=0; i<T; i++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken()); // 강의 서쪽
            M = Integer.parseInt(st.nextToken()); // 강의 동쪽
            C = 0;
            
            // N < M, M개 중에 N개 뽑아서 조합 구하기
            comb(0, 0);
            System.out.println(C);
        }
        */
        
        br.close();
    }
    
    /*
    static void comb(int cnt, int start){
        if(cnt == N){
            C++;
            return;
        }
        
        for(int i=start; i<M; i++){
            comb(cnt+1, i+1);
        }
    }
    */
    
}