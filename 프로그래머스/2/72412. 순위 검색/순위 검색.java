import java.util.*;

class Solution {
    
    static Map<String, List<Integer>> map;
        
    public int[] solution(String[] info, String[] query) {
        int[] answer = new int[query.length];
        map = new HashMap<String, List<Integer>>();
 
        for (int i=0; i<info.length; i++) {
            String[] p = info[i].split(" ");
            makeSentence(p, "", 0); // 가능한 조건 조합
        }
 
        for (String key : map.keySet()) Collections.sort(map.get(key)); // 정렬
 
        for (int i=0; i<query.length; i++) {
            query[i] = query[i].replaceAll(" and ", "");
            String[] q = query[i].split(" ");
            
            // 조건에 맞는 지원자 수 계산
            answer[i] = map.containsKey(q[0]) ? binarySearch(q[0], Integer.parseInt(q[1])) : 0;
        }
 
        return answer;
    }
    
    // 가능한 조건 조합 map에 저장
    private static void makeSentence(String[] p, String str, int cnt) {
        if (cnt == 4) {
            // putIfAbsent : Key 값이 존재하는 경우 Map의 Value 반환
            //               Key 값이 존재하지 않는 경우 Key와 Value를 Map에 저장, Null 반환
            map.putIfAbsent(str, new ArrayList<Integer>());
            
            map.get(str).add(Integer.parseInt(p[4])); // 조건 만족
            return;
        }
        // 재귀
        makeSentence(p, str + "-", cnt + 1);
        makeSentence(p, str + p[cnt], cnt + 1);
    }
 
    // 주어진 점수 이상 지원자 수 반환
    private static int binarySearch(String key, int score) {
        List<Integer> list = map.get(key);
        int start = 0;
        int end = list.size() - 1;
 
        while (start <= end) {
            int mid = (start + end) / 2;
            if (list.get(mid) < score){
                start = mid + 1;
            }else {
                end = mid - 1;   
            }
        }
 
        return list.size() - start;
    }
 
}