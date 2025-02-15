import java.util.*;
import java.io.*;
public class Main {
    
	static int n, a, b, m;  
	static int[][] graph;
	static int[] v;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine()); // 사람 수
		
		StringTokenizer st = new StringTokenizer(br.readLine());
        a = Integer.parseInt(st.nextToken()); // 사람 a
        b = Integer.parseInt(st.nextToken()); // 사람 b
        
        m = Integer.parseInt(br.readLine()); // 관계 개수
        
        graph = new int[n+1][n+1];
        
        // 관계 입력 - 인접행렬
        for (int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            graph[x][y] = 1; 
            graph[y][x] = 1; // 양방향
        }
        
        int result = bfs(a, b);
        
        System.out.println(result);
        
        br.close();
    }
	
	public static int bfs(int start, int target) {
        v = new int[n+1]; // 방 여부 + 거리
        Arrays.fill(v,-1); // 방문X : -1
       
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        v[start] = 0;  
        
        while (!queue.isEmpty()) {
            int current = queue.poll(); // 현재 사람
            
            for (int i=1; i<=n; i++) {
                if (graph[current][i] == 1 && v[i] == -1) { // 관계 O 방문 X
                    v[i] = v[current] + 1;
                    queue.add(i);
                    
                    if (i == target) return v[i];
                }
            }
        }
        
        return -1;  
    }
	
}