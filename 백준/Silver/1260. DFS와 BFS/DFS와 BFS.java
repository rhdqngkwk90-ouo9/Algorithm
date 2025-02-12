import java.io.*;
import java.util.*;

public class Main {

	static int N, M, V;
	static int[][] arr;
	static boolean[] v;
	static StringBuilder sb = new StringBuilder();
	static ArrayDeque<Integer> q = new ArrayDeque<>();

    public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		V = Integer.parseInt(st.nextToken());
		
		arr= new int[N+1][N+1];
		v = new boolean[N+1];
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int x = Integer.parseInt(st.nextToken());
			int y =  Integer.parseInt(st.nextToken());
			
	        arr[x][y] = arr[y][x] = 1;
		}
		
		dfs(V);
	    Arrays.fill(v, false);
	    bfs(V);
	    System.out.println(sb);
		
        br.close();
    }
    
	static void dfs(int i) {
		v[i] = true;
	    sb.append(i).append(" ");	
		for(int j=1; j<= N; j++) {
			if(arr[i][j] != 0 && !v[j]) {
				dfs(j);
			}
		}
	}
	
	static void bfs(int i) {
		q.offer(i);
		v[i] = true;
	    sb.append('\n').append(i).append(" ");		
		while(!q.isEmpty()) {
			int n = q.poll();
			for(int j=1; j<=N; j++) {
				if(arr[n][j] != 0 && !v[j]) {
					q.offer(j);
					v[j] = true;
		            sb.append(j).append(" ");
				}
			}
		}
	}


}
