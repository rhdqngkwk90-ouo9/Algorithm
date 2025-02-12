import java.util.*;
import java.io.*;
public class Main {
    
    static int N;
    static int[] input;
    /*
    static int[] a;
    static int[] b;
    static boolean[] v;
    static List<int[]> allPerm = new ArrayList<>(); // 가능한 모든 순열
    */
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
        N = Integer.parseInt(br.readLine()); // 순열의 크기
        
        input = new int[N]; // 입력받은 순열
        st = new StringTokenizer(br.readLine());
        for (int i=0; i<N; i++) input[i] = Integer.parseInt(st.nextToken());
        
        // 다음 순열(next permutation) 알고리즘 사용
        int i = N-2;
        
        // 내림차순이 시작되는 부분 찾기 (arr[i]<arr[i+1]인 i)
        while (i >= 0 && input[i+1] <= input[i]) i--;
        
        if (i == -1) {
            System.out.println(-1); // 마지막에 오는 순열
        }else {
            int j = N-1;
            // i보다 큰 값 중 가장 작은 값 찾기
            while (input[j] <= input[i]) j--; 
            
            swap(input, i, j);
            
            // 순열 뒷부분 정렬 : arr[i+1]부터 arr[N]까지 정렬
            Arrays.sort(input, i+1, N);
            
            for (int num : input) System.out.print(num + " ");
        }
        
        /*
        // 1. 가능한 모든 순열 생성
        a = new int[N]; 
        for (int i=0; i<N; i++) a[i] = i + 1;
        b = new int[N];
        v = new boolean[N];
        perm(0);
        
        // 2. 입력받은 순열의 인덱스 찾기
        int index = -1;
        for (int i=0; i<allPerm.size(); i++){
            if (Arrays.equals(allPerm.get(i), input)){
            	index = i;
                break;
            }
        }
        
        // 3. 다음 순열 출력
        if (index == allPerm.size()-1) {
            System.out.println(-1); // 마지막에 오는 순열
        } else {
            int[] nextPerm = allPerm.get(index + 1);
            for (int num : nextPerm) {
                System.out.print(num + " ");
            }
        }
        */
        
        br.close();
    }
	
    // 원소 교환
	public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
	
	/* 순열 - 메모리 초과
	static void perm(int cnt) {
        if (cnt == N) {
            allPerm.add(b.clone()); // 생성된 순열 저장
            return;
        }
        for (int i=0; i<N; i++) {
            if (v[i]) continue;
            v[i] = true;
            b[cnt] = a[i];
            perm(cnt+1);
            v[i] = false;
        }
    }
    */
	 
}
