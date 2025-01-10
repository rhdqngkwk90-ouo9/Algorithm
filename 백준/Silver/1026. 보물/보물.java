import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = null;
        
        st = new StringTokenizer(br.readLine());
        int[] A = new int[N];
        for (int i=0; i<N; i++) A[i] = Integer.parseInt(st.nextToken());
        
        st = new StringTokenizer(br.readLine());
        int[] B = new int[N];
        for (int i=0; i<N; i++) B[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(A);
        
        Arrays.sort(B);
        for (int j=0; j<(N/2); j++) {
            int temp = B[j];
            B[j] = B[N-1-j];
            B[N-1-j] = temp;
        }

        int S = 0;
        for (int k=0; k<N; k++) S += A[k] * B[k];
        
        System.out.println(S);
    }
}