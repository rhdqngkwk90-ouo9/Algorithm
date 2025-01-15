import java.util.*;

public class Solution {
    public int solution(int distance, int[] rocks, int n) {
        Arrays.sort(rocks); // 바위 정렬
        
        int low = 1;  // 최소 거리 1
        int high = distance;  // 최대 거리 distance
        
        while (low <= high) {
            int mid = (low + high) / 2;  // 중간값

            if (removeRocks(rocks, distance, mid, n)) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return high;
    }
    
    // 중간값으로 바위 n개 이하 제거 가능 확인
    private boolean removeRocks(int[] rocks, int distance, int mid, int n) {
        int count = 0; 
        int lastPosition = 0;  
        
        for (int rock : rocks) {
            if (rock - lastPosition < mid) {
                count++;  // 바위 제거
            } else {
                lastPosition = rock;  // 바위가 mid 이상 떨어져 있으면 통과
            }
        }
        
        if (distance - lastPosition < mid) {
            count++;  
        }
        
        return count <= n;
    }
}