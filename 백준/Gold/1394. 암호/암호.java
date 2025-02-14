import java.util.*;
import java.io.*;
public class Main {
    
	/*
	static String charset;  
    static String pw;   
    static int mod = 900528;  
    static int cnt;
    */
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String charset = br.readLine();
		 
		int arr[] = new int[400];
 
		for(int i=1; i<charset.length() + 1; i++){
			arr[charset.charAt(i - 1)] = i;
		}
 
		String pw = br.readLine();
 
		int control = 1; // 제어변수 (뒤에서부터 계산)
		int ans = 0; 	
		int cnt = charset.length();
 
		for(int i = pw.length() - 1; i>=0; i--){
			ans = (ans + control * arr[pw.charAt(i)]) % 900528;
			control = control * cnt % 900528;
		}
 
		System.out.println(ans);
        
        /* BFS 사용 - 시간초과
        cnt = 0;
        
        // 큐에 문자 집합 넣기
        Queue<String> queue = new LinkedList<>();
        for (char c : charset.toCharArray()) queue.offer(String.valueOf(c));
        
        while (!queue.isEmpty()) {
            String current = queue.poll();
            cnt++;
            
            if (current.equals(pw)) {
            	//System.out.println("암호 발견: " + current);
                //System.out.println("시도 횟수: " + cnt);
                cnt = cnt % mod;
                break;
            }
            
            if (current.length() < pw.length()) {
                for (char c : charset.toCharArray()) queue.offer(current + c);
            }
        }
        
        System.out.println(cnt);
        */
        
        br.close();
    }
	
}