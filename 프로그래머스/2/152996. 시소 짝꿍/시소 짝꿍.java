import java.util.*;

class Solution {
    public long solution(int[] weights) {
        long answer = 0;
        
        Map<Double,Integer> map = new HashMap<>();
        
        int[] distances = {2, 3, 4}; // 시소 중심에서 좌석까지 거리
        Arrays.sort(weights);

        for(int w : weights){
            double torque2 = (double) w; // 2m (무게 * 1)
    		double torque3 = ((double) w * distances[0]) / distances[1]; // 3m (무게 * 2/3)
    		double torque41 = (double) w / distances[0]; // 4m (무게 / 2)
    		double torque42 = ((double) w * distances[1]) / distances[2]; // 4m 다른 방식 (무게 * 3/4)
            
            if(map.containsKey(torque2)) answer += map.get(torque2);
            if(map.containsKey(torque3)) answer += map.get(torque3);
            if(map.containsKey(torque41)) answer += map.get(torque41);
            if(map.containsKey(torque42)) answer += map.get(torque42);
            map.put(torque2, map.getOrDefault(torque2, 0) + 1);
        }
        return answer;

    }
}