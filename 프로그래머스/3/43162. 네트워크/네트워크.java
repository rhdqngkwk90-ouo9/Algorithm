import java.util.*;

class Solution {
    
    public int solution(int n, int[][] computers) {
        int answer = 0;
        boolean[] check = new boolean[n];
        
        for (int i=0; i<n; i++) {
          if (!check[i]) {
            dfs(computers, i, check); // 연결 모두 탐색
            answer++; // 네트워크 발견
          }
        }
        
        return answer;
    }
    
    boolean[] dfs(int[][] computers, int i, boolean[] check) {
        check[i] = true; // 방문처리

        for (int j=0; j<computers.length; j++) {
          if (i != j && computers[i][j] == 1 && check[j] == false) {
            check = dfs(computers, j, check);
          }
        }
        return check;
  }
    
}