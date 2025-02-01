class Solution {
    public int solution(int n) {
        int answer = 0;
        
        // 이진수 변환했을 때, 1의 개수를 구하고(bitCount) -> 개수 같은 다음 큰 수 구하면 됨
        int nCount = Integer.bitCount(n);
        
        int nextN = n + 1;
        while (Integer.bitCount(nextN) != nCount) nextN++;
        
        answer = nextN;
        
        return answer;
    }
}