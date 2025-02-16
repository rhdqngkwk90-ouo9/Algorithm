import java.util.*;
import java.io.*;
public class Main {
    
    static int[][] paper;
    static int N;
    static int cntMinusOne = 0;
    static int cntZero = 0;
    static int cntOne = 0;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
        
        N = Integer.parseInt(br.readLine());
        paper = new int[N][N];
        
        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<N; j++) {
                paper[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        divide(0, 0, N);
        
        System.out.println(cntMinusOne);
        System.out.println(cntZero);
        System.out.println(cntOne);
        
        br.close();
    }
	
    public static void divide(int x, int y, int size) {
        if (isSame(x, y, size)) {
            if (paper[x][y] == -1) cntMinusOne++;
            else if (paper[x][y] == 0) cntZero++;
            else cntOne++;
            return;
        }
        
        int newSize = size / 3;
        
        for (int i=0; i<3; i++) {
            for (int j=0; j<3; j++) {
                divide(x + i * newSize, y + j * newSize, newSize);
            }
        }
        
    }
    
    public static boolean isSame(int x, int y, int size) {
        int first = paper[x][y];
        
        for (int i=x; i<x+size; i++) {
            for (int j=y; j<y+size; j++) {
                if (paper[i][j] != first) {
                    return false;
                }
            }
        }
        
        return true;
    }
	
}