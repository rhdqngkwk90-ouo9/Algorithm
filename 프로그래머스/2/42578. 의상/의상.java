import java.util.*;

class Solution {
   
    static Map<String, Integer> map = new HashMap<>();

    public int solution(String[][] clothes) {
        
        int answer = 1; 
        
        for(String[] arr : clothes){
            // getOrDefault
            //map.put(arr[1], map.getOrDefault(arr[1], 1) + 1);
            
            String category = arr[1];
            if (map.containsKey(category)) {
                map.put(category, map.get(category) + 1); 
            } else {
                map.put(category, 1);  
            }
            
        }
        
        // getOrDefault
        //for(String str : map.keySet()){
        //    answer *= map.get(str);
        //}
        
        for (int str : map.values()) {
           answer *= (str + 1); 
        }
        
        return answer-1;
    }

    
}
