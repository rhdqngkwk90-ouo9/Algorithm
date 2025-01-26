import java.util.*;

class Solution {
    public String solution(String s) {
        String answer = "";
                
        for(int i = 0; i < s.length(); i++){
            
            if(i==0 || s.charAt(i-1) == ' ') {
                answer += Character.toString(s.charAt(i)).toUpperCase(); // 첫 글자(대문자)
            } else{
                answer += Character.toString(s.charAt(i)).toLowerCase(); // 나머지 글자(소문자)
            }
        }
            
        return answer;
    }
}
