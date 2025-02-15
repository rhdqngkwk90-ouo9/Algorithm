import java.util.*;
import java.io.*;
public class Main {
    
	// 위,아래,왼쪽,오른쪽,앞,뒤
	static int[] dx = {-1, 1, 0, 0, 0, 0};
    static int[] dy = {0, 0, -1, 1, 0, 0};
    static int[] dz = {0, 0, 0, 0, -1, 1};
    
    static int M, N, H; 
	static int[][][] graph;
	 static ArrayDeque<int[]> queue;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken()); // 가로
        N = Integer.parseInt(st.nextToken()); // 세로
        H = Integer.parseInt(st.nextToken()); // 높이
        
        graph = new int[H][N][M];
        queue = new ArrayDeque<>();
        
        // 상태 입력
        for (int h=0; h<H; h++) {  // 높이부터 입력
            for (int n=0; n<N; n++) {
                st = new StringTokenizer(br.readLine());
                for (int m=0; m<M; m++) {
                    graph[h][n][m] = Integer.parseInt(st.nextToken());

                    if (graph[h][n][m] == 1) { // 익은 토마토
                        queue.offer(new int[]{h, n, m});
                    }
                }
            }
        }
        
        int result = bfs();
        System.out.println(result);
        
        br.close();
    }
	
	public static int bfs() {
	    while (!queue.isEmpty()) {
	        int[] current = queue.poll();
	        int h = current[0]; // 높이
	        int n = current[1]; // 세로
	        int m = current[2]; // 가로
	        
	        for (int i=0; i<6; i++) {
	            int newH = h + dz[i]; 
	            int newN = n + dy[i];  
	            int newM = m + dx[i];  
	            
	            if (newM>=0 && newM<M && newN>=0 && newN<N && newH>=0 && newH<H) { // 유효 범위 확인
	                if (graph[newH][newN][newM] == 0) { // 안 익음
	                    graph[newH][newN][newM] = graph[h][n][m] + 1; // 익은 토마토로 바꿈
	                    queue.offer(new int[]{newH, newN, newM});  
	                }
	            }
	            
	        }
	        
	    }

	    return calculate();
	}
	
	public static int calculate() {
	    int maxDay = 0;
	    
	    // 모든 토마토 확인
	    for (int h=0; h<H; h++) {
	        for (int n=0; n<N; n++) {
	            for (int m=0; m<M; m++) {
	                if (graph[h][n][m] == 0) { // 안 익음
	                    return -1; 
	                }
	                maxDay = Math.max(maxDay, graph[h][n][m]);
	            }
	        }
	    }
	    
	    return maxDay - 1;  // 1일부터 시작
	}
	
}