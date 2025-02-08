class Solution {
    int solution(int[][] land) {
        int answer = 0;
        int n = land.length;

        int[][] dp = new int[n][4];
        for (int i=0; i<4; i++) dp[0][i] = land[0][i]; // 1행

        for (int i=1;i<n; i++) {
            for (int j=0; j<4; j++) {
                int max = 0;
                for (int k=0; k<4; k++) {
                    if (k != j) max = Math.max(max, dp[i-1][k]);
                }
                dp[i][j] = land[i][j] + max;
            }
        }

        answer = Math.max(Math.max(dp[n-1][0], dp[n-1][1]),
                          Math.max(dp[n-1][2], dp[n-1][3]));  // N행
        
        return answer;
    }
}