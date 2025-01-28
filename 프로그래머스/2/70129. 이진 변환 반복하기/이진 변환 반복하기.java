class Solution {
    public int[] solution(String s) {
        int[] answer = new int[2];
        
        int changeCnt = 0; // 변환 횟수
        int zeroCnt = 0; // 제거한 0 개수
        
        while (!s.equals("1")) {
            String remove0 = s.replaceAll("0","");
            zeroCnt += (s.length() - remove0.length());

            s = Integer.toBinaryString(s.replace("0", "").length());
            changeCnt++;
        }
        answer[0] = changeCnt;
        answer[1] = zeroCnt;
        
        return answer;
    }
}