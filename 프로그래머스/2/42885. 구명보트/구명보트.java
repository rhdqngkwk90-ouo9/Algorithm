import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        
         // 사람들의 몸무게를 오름차순으로 정렬
         Arrays.sort(people);
         int min = 0; // 가장 가벼운 사람 인덱스
         int max = people.length - 1; // 가장 무거운 사람 인덱스
        
         while (min <= max) {
             // 가장 무거운 사람과 가장 가벼운 사람이 구명보트에 함께 탈 수 있는지 확인
             if (people[min] + people[max] <= limit) {
                 min++; // 가벼운 사람을 태움
                 max--; // 무거운 사람을 태움
                 answer++; // 구명보트 사용 개수 증가
             }else{
                 max--; // 무거운 사람을 태움
                 answer++; // 구명보트 사용 개수 증가
             }
         }
        
        return answer;
    }
}