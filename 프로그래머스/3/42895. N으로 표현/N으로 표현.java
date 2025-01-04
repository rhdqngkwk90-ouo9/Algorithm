import java.util.*;

class Solution {
    public int solution(int N, int number) {
        int answer = 0;
        
        Set<Integer>[] set = new HashSet[9];
       
        // 사칙연산 아닌 수 넣어주기
        int temp = N; 
        for(int i=1; i<9; i++) {
            set[i] = new HashSet<>();
            set[i].add(temp); //5,55,555,5555,...
            temp = temp * 10 + N; 
        }
        
        // set에 가능한 계산 결과 전부 넣어주기
        for(int i=1; i<9; i++) {
            for (int j=1; j<i; j++) {
                
                for(Integer x : set[j]) {
                    for(Integer y : set[i-j]) {
                        
                        set[i].add(x+y);
                        set[i].add(x-y);
                        set[i].add(y-x);
                        set[i].add(x*y);
                        
                        if(x!=0) set[i].add(y/x);
                        if(y!=0) set[i].add(x/y);
                        
                    }
                }
                
            }
            // 같은 값이 있으면 반환
            if(set[i].contains(number)) {
                answer = i;
                break;
            }else {
                answer = -1;
            }
        }

        return answer;
    }
}