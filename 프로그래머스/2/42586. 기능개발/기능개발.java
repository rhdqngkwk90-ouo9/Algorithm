import java.util.*;

class Solution {
    
    static int time, day;
    
    public int[] solution(int[] progresses, int[] speeds) {

        Queue<Integer> q = new LinkedList<>();
        for(int i=0; i<progresses.length; i++) {
            time = 0; day = 0;
            time = 100 - progresses[i];
            day = (time/speeds[i]);
            if(time%speeds[i] > 0) day += 1;
            q.add(day);
        }
        System.out.println(q);

        List<Integer> list = new LinkedList<>();

        while(!q.isEmpty()){
            int value = q.poll();
            int cnt = 1;
            
            while(!q.isEmpty() && value >= q.peek()) { 
                cnt++;
                q.poll();
            }
            list.add(cnt);
        }
        
        int[] answer = list.stream().mapToInt(i -> i).toArray();

        return answer;
    }
}