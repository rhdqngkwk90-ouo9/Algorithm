import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken()); 
        
        int[] arr = new int[N+1]; 
        st = new StringTokenizer(br.readLine());
        for(int i=1; i<=N; i++) arr[i] = Integer.parseInt(st.nextToken());
        
        long result = 0; // (i, j) 개수
        int length = 1; // 구간 길이

        for (int i=2; i<=N; i++) {
            if (arr[i] >= arr[i-1]) {
                length++;
            } else {
            	// 길이 length인 오름차순 구간에서 만들 수 있는 (i, j) 개수 구하기 : 등차수열 합 공식
                result += (long) length * (length+1) / 2;
                length = 1;  
            }
        }
        
        result += (long) length * (length+1) / 2;
        System.out.println(result);
        br.close();
    }
    
}