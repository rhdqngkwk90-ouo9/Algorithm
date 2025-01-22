import java.util.*;

class Solution {
    public int solution(int[] elements) {
        int answer = 0;
        
        // 부분 수열의 합은 Set에 넣어서 중복을 제거한다.
        Set<Integer> sumSet = new HashSet<>();
        
        // 원형 수열 - 크기 늘리기
        int n = elements.length;
        int[] extended = new int[2 * n];
        for (int i = 0; i < n; i++) {
            extended[i] = elements[i];
            extended[i + n] = elements[i];
        }

        // 연속 부분 수열의 합 계산
        for (int length = 1; length <= n; length++) { 
            for (int start = 0; start < n; start++) {  
                int sum = 0;
                for (int i = 0; i < length; i++) {
                    sum += extended[start + i]; 
                }
                sumSet.add(sum);  
            }
        }
        
        answer = sumSet.size();
        return answer;
    }
}