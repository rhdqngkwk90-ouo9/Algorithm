import java.util.*;

class Solution {
    boolean[] v;  // 방문 여부
    List<String> r;  // 경로 저장

    public String[] solution(String[][] tickets) {
        r = new ArrayList<>();
        v = new boolean[tickets.length]; 
        
        // DFS 시작
        dfs("ICN", "ICN", tickets, 0);
        
        // 알파벳순 정렬
        Collections.sort(r);
        
        return r.get(0).split(" ");
    }

    public void dfs(String start, String route, String[][] tickets, int cnt) {
        if (cnt == tickets.length) {
            r.add(route);
            return;
        }

        // 모든 항공권 순회
        for (int i = 0; i < tickets.length; i++) {
            // 출발지 일치 , 아직 방문 X
            if (start.equals(tickets[i][0]) && !v[i]) {
                v[i] = true;  
                // 재귀 호출
                dfs(tickets[i][1], route + " " + tickets[i][1], tickets, cnt + 1);
                v[i] = false;  
            }
        }
    }
}