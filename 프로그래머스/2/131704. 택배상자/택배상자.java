import java.util.*;
    
class Solution {
    public int solution(int[] order) {
        int answer = 0;
   
        Stack<Integer> st = new Stack<>();
        
        int n = order.length; // 박스 개수
        int box = 1; // 1번 ~ n번 박스
        int index = 0; // 순서
        
        while(index < n){

            //System.out.println("현재 박스 : "+box+" 순서박스 : "+order[index]);
            
            // 보조 벨트 먼저 확인
            if(!st.isEmpty() && st.peek() == order[index]){
                st.pop();
                answer++;
                index++;
                //System.out.println("보조에서 꺼내! 다음 순서 : "+index);
            }else if(box == order[index]){
                answer++;
                index++;
                box++;
                //System.out.println("실어! 다음 순서 : "+index);
            }else{
                if(box > n) break;
                st.push(box);
                box++;
                //System.out.println("보조에 넣어! : "+st);
            }
            
        }

        return answer;
    }
}