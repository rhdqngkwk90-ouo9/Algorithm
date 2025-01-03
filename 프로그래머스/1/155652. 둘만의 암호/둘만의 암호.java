class Solution {
    public String solution(String s, String skip, int index) {
        String answer = "";
        
        int length = s.length();
        
        for(int i=0; i<length; i++){
            char ch = s.charAt(i);
        
            int cnt = 1;
            while(cnt <= index) {
                ch = (char) (((ch - 'a' + 1) % 26) + 'a'); // 1씩 뒤로 이동
                
                if(!skip.contains(Character.toString(ch))) { // skip에 포함 X
                    cnt++; 
                }
                
            }
            answer += ch;
        }
        return answer;
    }
}