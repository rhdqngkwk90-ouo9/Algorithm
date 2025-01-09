class Solution {
    
    public int solution(int m, int n, int[][] puddles) {
        int answer = 0;
        
        int[] dp = new int[m + 1];
        dp[1] = 1;  

        boolean[][] board = new boolean[n + 1][m + 1];
        for (int[] puddle : puddles) {
            board[puddle[1]][puddle[0]] = true;  // 물에 잠긴 곳 표시
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (board[i][j]) {
                    dp[j] = 0; 
                } else {
                    if (j > 1) dp[j] = (dp[j] + dp[j - 1]) % 1000000007;
                }
            }
        }

        return dp[m];
        
        /* 이전 방식 - 이차원 배열 사용
        //1. 물에 잠긴 지역에 -1 값을 준다.
        int[][] board = new int[n+1][m+1];
        for(int i=0; i<puddles.length; i++) {
            board[puddles[i][1]][puddles[i][0]] = -1; 
        }
        
        //시작을 1로 설정
        board[1][1] = 1;
        
        //2. 오른쪽, 아래쪽으로 이동하면서 최단거리 구하기
        for (int i=1; i<=n; i++) {
            for (int j=1; j<=m; j++) {
                if(board[i][j] == -1) continue;
                //        상 우 하 좌
	            // i = { -1, 0, 1, 0 }
	            // j = {  0, 1, 0, -1 }
                //위에서 오는 경우, 왼쪽에서 오는 경우를 합하면 경우의 수가 된다.
                if(board[i-1][j] > 0) {
                    board[i][j] = (board[i][j] + board[i-1][j]) % 1000000007; //효율성 테스트 때문에 매번 나눠준다.
                }
                if(board[i][j-1] > 0) {
                    board[i][j] = (board[i][j] + board[i][j-1]) % 1000000007;
                }
            }
        }
                
        answer = board[n][m] % 1000000007;
        
        return answer;
        */
    }
    

}