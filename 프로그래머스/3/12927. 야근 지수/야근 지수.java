import java.util.*;

class Solution {
    public long solution(int n, int[] works) {
        long answer = 0;

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);

        for (int work : works) maxHeap.offer(work);

        while (n > 0) {
            int maxWork = maxHeap.poll();
            
            if(maxWork == 0) break;
            
            maxWork--; // 1시간 일함
            n--; 
            maxHeap.offer(maxWork); // 변경된 작업량 힙에 넣기
        }
        
        // 피로도 계산: 제곱 합산
        while (!maxHeap.isEmpty()) {
            int work = maxHeap.poll();
            answer += work * work;
        }
        return answer;
    }
}