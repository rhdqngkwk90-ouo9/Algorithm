class Solution {
    public int solution(int[] diffs, int[] times, long limit) {
        int answer = 0;
        
        int left = 1; // 최소 숙련도
        int right = 100000; // 최대 숙련도
        answer = right;
        
        while (left <= right) {
            int mid = (left + right) / 2; // 중간값
            long total = calculate(mid, diffs, times);
            
            if (total <= limit) {
                answer = mid;  
                right = mid - 1; 
            }else {
                left = mid + 1; 
            }
            
        }
        
        return answer;
    }
    
    public static long calculate(int level, int[] diffs, int[] times) {
        long total = 0;  
        int previous = 0;  
        
        for (int i=0; i<diffs.length; i++) {
            int diff = diffs[i];  // 난이도
            int time = times[i];  // 소요 시간
            
            if (diff <= level) {
                total += time;
            }else {
                int mistakes = diff - level;  // 난이도 - 숙련도
                long spent = (long) (time + previous) * mistakes + time;
                total += spent;
            }
            
            previous = time;  
        }
        
        return total; 
    }
}