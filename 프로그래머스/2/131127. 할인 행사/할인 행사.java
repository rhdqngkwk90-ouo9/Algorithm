import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        
        //제품-수량 넣기
        Map<String, Integer> map = new HashMap<>();
        for(int i=0; i<want.length; i++){
            map.put(want[i], number[i]);
        }
        //System.out.println("map: "+map);
        
        for(int i=0; i<discount.length-9; i++){
            
            // 현재 기준 10일간의 할인 제품
            Map<String, Integer> dMap = new HashMap<>();
            
            for(int j=i; j<i+10; j++){
                //getOrDefault : key 있으면 값, 없으면 기본값(0)
                dMap.put(discount[j], dMap.getOrDefault(discount[j], 0) +1);
            }
            //System.out.println("i: "+i+" "+dMap);
            
            boolean isValid = true;
            
            for(String key : map.keySet()){
            if (!dMap.containsKey(key) || map.get(key) != dMap.get(key)) {
                    isValid = false;
                    break;
                }
            }
            
            if (isValid) answer++;
        }
        
        return answer;
    }
}