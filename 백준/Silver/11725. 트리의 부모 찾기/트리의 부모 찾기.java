import java.util.*;
import java.io.*;
public class Main {
    
    static ArrayList<Integer>[] graph;
    static int[] parent;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
        int N = Integer.parseInt(br.readLine());
		
        graph = new ArrayList[N + 1];
        parent = new int[N + 1];
        
        for (int i=1; i<=N; i++) graph[i] = new ArrayList<>();
        
        for (int i=0; i<N-1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            graph[u].add(v);
            graph[v].add(u);
        }
        
        bfs(1);
        
        StringBuilder sb = new StringBuilder();
        for (int i=2; i<=N; i++) sb.append(parent[i]).append("\n");
        System.out.print(sb);
        
        br.close();
    }
	
    public static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        parent[start] = -1; 
        
        while (!queue.isEmpty()) {
            int node = queue.poll();
            
            for (int next : graph[node]) {
                if (parent[next] == 0) { // 방문X
                    parent[next] = node;
                    queue.offer(next);
                }
            }
        }
    }
	
}