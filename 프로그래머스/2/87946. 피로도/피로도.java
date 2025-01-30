import java.util.*;

class Solution {
    
    static int kNum, N, C = 0; 
    static int[] a, b;
    static boolean[] v;
    static List<Integer> list = new ArrayList<>();
    static Map<Integer, Integer> map = new HashMap<>();

    public int solution(int k, int[][] dungeons) {
        int answer = -1;
        int length = dungeons.length;
        a = new int[length];
        int i=0;
        for(int[] d : dungeons){
            map.put(d[0], d[1]);
            a[i] = d[0];
            i++;
        }
        
        N = length;
        b = new int[N];
        v = new boolean[N];
        C = 0;
	    perm(k, 0);
        Collections.sort(list, Collections.reverseOrder());
        answer = list.get(0);
        
        return answer;
    }
    
    static void perm(int k, int cnt) {
        //탈출구문
        if(cnt==N) {
            kNum = k;
            int result = calc(b);
            list.add(result);
            C++;
            return;
        }
        //반복구문
        for(int i=0; i<N; i++) {
            if(v[i]) continue;
            v[i] = true;
            b[cnt] = a[i];
            perm(k, cnt+1);
            v[i] = false;
        }
    }
    
    static int calc(int[] b) {
        int result = 0;
        for(int key : b){
            if(kNum<key) break;
            kNum -= map.get(key);
            result++;   
        }
        return result;
    }

}