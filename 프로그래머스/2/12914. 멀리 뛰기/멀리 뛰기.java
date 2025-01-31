class Solution {
    public long solution(int n) {
        long answer = 0;
        int num = 1234567;
        
        // 규칙 찾아보면 피보나치 수열임(이전 두 값의 합) => dp 사용해서 풀기
        
        int[] dp = new int[n + 1]; 
        dp[0] = 1;  
        dp[1] = 1;  
        
        for (int i=2; i<=n; i++) {
            dp[i] = ( dp[i-1]+dp[i-2] ) % num;
        }
        
        answer = dp[n];
        
        return answer;
    }
}