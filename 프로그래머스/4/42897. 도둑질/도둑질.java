import java.util.*;

class Solution {
    
    
    public int solution(int[] money) {
        int answer = 0; 
        int n = money.length;
        
        // 집이 3개인 경우, 각 집의 돈을 직접 비교
        if (n == 3) return Math.max(money[0], Math.max(money[1], money[2]));
        
        // 첫 번째 집을 포함하는 경우 (마지막 집 제외)
        int[] dp1 = new int[n];
        dp1[0] = money[0];
        dp1[1] = Math.max(money[0], money[1]);
        for (int i=2; i<n-1; i++) {
            dp1[i] = Math.max(dp1[i-1], dp1[i-2] + money[i]);
        }
        
        // 첫 번째 집을 제외하는 경우 (마지막 집 포함)
        int[] dp2 = new int[n];
        dp2[1] = money[1];
        dp2[2] = Math.max(money[1], money[2]);
        for (int i=3; i<n; i++) {
            dp2[i] = Math.max(dp2[i-1], dp2[i-2] + money[i]);
        }
        
        // 두 경우 중 최대값 반환
        return Math.max(dp1[n-2], dp2[n-1]);
        
    }
}