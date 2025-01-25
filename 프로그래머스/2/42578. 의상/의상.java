import java.util.*;

class Solution {
   
    static Map<String, Integer> map = new HashMap<>();

    public int solution(String[][] clothes) {
        int answer = 1; 
        for(String[] arr : clothes){
            map.put(arr[1], map.getOrDefault(arr[1], 1) + 1);
        }
        for(String str : map.keySet()){
            int num = map.get(str);

            answer *= num;
        }
        
        return answer-1;
    }

    
}
