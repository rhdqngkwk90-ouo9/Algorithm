import java.util.*;

class Solution {
    public int solution(int x, int y, int n) {
        int answer = -1;
        
        int[] dp = new int[y+1];
        for (int i=0; i<=y; i++) dp[i] = -1;
        dp[x] = 0;
        
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(x);
        
         while (!queue.isEmpty()) {
            int num = queue.poll();
            
            // n을 더하기
            if (num+n <= y && dp[num+n] == -1) {
                dp[num+n] = dp[num] + 1;
                queue.offer(num+n);
            }
            
            // 2를 곱하기
            if (num*2 <= y && dp[num*2] == -1) {
                dp[num*2] = dp[num] + 1;
                queue.offer(num*2);
            }
            
            // 3을 곱하기
            if (num*3 <= y && dp[num*3] == -1) {
                dp[num*3] = dp[num] + 1;
                queue.offer(num*3);
            }
            
        }
        
        answer = dp[y];
        
        return answer;
    }
}