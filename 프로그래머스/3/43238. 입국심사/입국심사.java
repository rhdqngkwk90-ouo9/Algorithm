import java.util.*;

class Solution {
    public long solution(int n, int[] times) {
        long answer = 0;

        Arrays.sort(times); //정렬

        //범위 설정
        long start = 1;
        long end = (long) times[times.length - 1] * n; //모든 사람이 가장 오래 걸리는 심사대에서 심사를 받는 경우

        answer = end;

        //start가 end보다 작거나 같을 때 까지 반복.
        while (start <= end) {

            long sum = 0;
            long mid = start + (end - start) / 2;

            //심사 완료 인원을 카운트
            for (int time : times) {
                sum += mid / time;
            }

            //시작, 종료 위치 변경
            if (sum >= n) { //arr[mid] > key
                answer = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }

        }
        return answer;
        
        
    }
}