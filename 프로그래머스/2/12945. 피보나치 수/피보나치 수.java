class Solution {
    public int solution(int n) {
        int answer = 0;
        int num = 1234567;
        
        // 피보나치 수 기본 공식 (외우기)
        int[] dp = new int[n + 1]; 
        dp[0] = 0;  
        dp[1] = 1;  

        for (int i=2; i<=n; i++) {
            dp[i] = ( dp[i-1] + dp[i-2] ) % num;
        }

        answer = dp[n];

        return answer;
    }
}