import java.util.*;

class Solution {
    
    int answer = 0;
    
    public int solution(int[] numbers, int target) {
        
        dfs(numbers, target, 0, 0);
        
        return answer;
    }
    
    // 이진트리 형식으로 생각하면 된다 = DFS
    public void dfs(int[] numbers, int target, int idx, int sum) {
        if(idx == numbers.length) {
            if(target == sum) answer++;
            return;
        }
        
        // numbers[idx]를 더한 경우
        dfs(numbers, target, idx+1, sum+numbers[idx]); 
        // numbers[idx]를 뺀 경우
        dfs(numbers, target, idx+1, sum-numbers[idx]);
        
   }
    
}