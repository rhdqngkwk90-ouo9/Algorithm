import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];
          
        // 스택 사용
        Stack<Integer> st = new Stack<>();
        
        for(int i=0; i<numbers.length; i++) {
            
            while (!st.isEmpty() && numbers[st.peek()] < numbers[i]) {
                int index = st.pop(); 
                answer[index] = numbers[i]; // max
            }
            
            st.push(i);
        }
        
         while (!st.isEmpty()) answer[st.pop()] = -1;
        
        
        /* 완전탐색 - 시간 초과
        for(int i=0; i<numbers.length; i++) {
            int max = -1;
            
            for(int j=i+1; j<numbers.length; j++) {
                if (numbers[j] == numbers[i]) continue;
                    
                if (numbers[j] > numbers[i]) { 
                    max = numbers[j]; 
                    break; 
                } 
            }
            
            answer[i] = max;
        }
        */
        
        return answer;
    }
}