class Solution {
    public int solution(int[] stones, int k) {
        int answer = 0;
        
        int left = 1;
        int right = 200000000;
        
        while (left <= right) {
            int mid = (left + right) / 2;
            
            if (check(stones, k, mid)) {
                left = mid + 1;
                answer = Math.max(answer, mid);
            }else {
                right = mid - 1;
            }
            
        }
        
        return answer;
    }
    
    // mid명 징검다리 건널 수 있는지 확인
    public boolean check(int[] stones, int k, int mid) {
        int cnt = 0;
        
        for (int s : stones) {
            if (s < mid) {
                cnt++; // 못건넘
            }else {
                cnt = 0; // 건넘
            }
            if (cnt >= k) {
                return false;
            }
        }
        
        return true;
    }
    
}