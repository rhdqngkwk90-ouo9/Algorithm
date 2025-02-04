import java.util.*;

class Solution {
    public int solution(int[] topping) {
        int answer = 0;
        
        // 3. 둘 다 초기화 X (미리 넣어두고 삭제) - Map 사용해야 가능
        Map<Integer,Integer> leftMap = new HashMap<>();
        Map<Integer,Integer> rightMap = new HashMap<>(); 
        
        // 미리 추가
        for (int i=0; i<topping.length; i++) {
            rightMap.put(topping[i], rightMap.getOrDefault(topping[i], 0) + 1);
        }
        
        for(int i=0; i<topping.length-1; i++) { 
            leftMap.put(topping[i], leftMap.getOrDefault(topping[i], 0) + 1);
            rightMap.put(topping[i], rightMap.get(topping[i]) - 1);
            
            if (rightMap.get(topping[i]) == 0) rightMap.remove(topping[i]);
         
            if(leftMap.size() == rightMap.size()) answer++;
        }
        
        /* 2. Set 1개만 초기화 - 시간초과
        Set<Integer> leftSet = new HashSet<>();
        
        for(int i=0; i<topping.length-1; i++) {
            Set<Integer> rightSet = new HashSet<>(); 
            
            leftSet.add(topping[i]);
            
            for(int b=i+1; b<topping.length; b++) {
                rightSet.add(topping[b]);
            }
         
            if(leftSet.size() == rightSet.size()) answer++;
        }
        */
        
        /* 1. Set 2개 다 초기화 - 시간초과
        for(int i=0; i<topping.length-1; i++) {
            Set<Integer> leftSet = new HashSet<>();
            Set<Integer> rightSet = new HashSet<>(); 
            
            for(int a=0; a<i+1; a++) {
                leftSet.add(topping[a]);
            }
            for(int b=i+1; b<topping.length; b++) {
                rightSet.add(topping[b]);
            }
         
            if(leftSet.size() == rightSet.size()) answer++;
        }
        */

        return answer;
    }
    
}