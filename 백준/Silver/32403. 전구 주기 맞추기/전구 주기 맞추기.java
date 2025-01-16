import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 전구 개수
        int T = Integer.parseInt(st.nextToken()); // 목표 시간

        int[] periods = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            periods[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(minOperationsToSyncBulbs(N, T, periods));
    }

    // 각 전구의 주기를 T의 배수로 변경, 최소 횟수
    public static int minOperationsToSyncBulbs(int N, int T, int[] periods) {
        int totalChanges = 0;

        for (int period : periods) {
            int num = 0; 
            while (true) {
                if (T % (period + num) == 0) {
                    break;
                }

                else if (T % (period - num) == 0 && (period - num) > 0) {
                    break;
                }

                else {
                    num++;
                }
            }
            totalChanges += num; 
        }

        return totalChanges;
    }
}
