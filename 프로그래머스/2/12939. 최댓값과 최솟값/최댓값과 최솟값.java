import java.util.*;

class Solution {
    public String solution(String s) {
        String answer = "";
        
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
	    
        String[] arr = s.split(" ");
        
        for(String str : arr) pq.offer(Integer.valueOf(str));
                
        int min = pq.peek();
        int max = 0;
        
        while(!pq.isEmpty()) max = pq.poll();
        
        answer = min + " " + max;
        
        
        return answer;
    }
}