import java.io.*;
import java.util.*;

public class Main {
    
	static int N;
    static String pw;
    //static int C;
    //static boolean[] v = new boolean[26]; 
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        N = Integer.parseInt(br.readLine()); 
        pw = br.readLine(); 
        
        long[] cnt = new long[N+1];
        cnt[0] = 1;
        // i번째 자리에서 가능한 문자열의 개수
        for (int i=1; i<=N; i++) cnt[i] = cnt[i-1] * 26 + 1;

        long result = 0;
        for (int i=0; i<pw.length(); i++) {
        	result += (pw.charAt(i) - 'a') * cnt[N-i-1] + 1;
        }

        System.out.println(result);
        
        /*
        C = 0;
        StringBuilder sb = new StringBuilder();
        perm(0, sb);
        System.out.println(C);
        */
        
        br.close();
    }
	
    /* 순열 - 시간초과
	static void perm(int cnt, StringBuilder sb) {
		if (cnt == N) { 
            String current = sb.toString();
            if (pw.equals(current)) {
                System.out.println(C+1);  
                System.exit(0);  
            }
            C++; 
            return;
        }
		for (int i=0; i<26; i++) {
            if (v[i]) continue;
            v[i] = true;
            sb.append((char) ('a' + i)); 
            perm(cnt+1, sb);  // 재귀 호출
            sb.deleteCharAt(sb.length() - 1);  
            v[i] = false;
        }
    }
    */
    
}