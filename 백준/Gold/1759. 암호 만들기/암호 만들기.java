import java.io.*;
import java.util.*;
public class Main {
    
    static int L, C;
    static char[] charArr;
    static char[] resultArr;
   
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        L = Integer.parseInt(st.nextToken()); // 암호 길이
        C = Integer.parseInt(st.nextToken()); // 문자 개수
        
        charArr = new char[C];
        
        st = new StringTokenizer(br.readLine());
        for (int i=0; i<C; i++) charArr[i] = st.nextToken().charAt(0);
        
        Arrays.sort(charArr);
        
        resultArr = new char[L];
        comb(0, 0);
        
        br.close();
    }
    
    static boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
    
    static void comb(int cnt, int start) {
        if (cnt == L) {
            int vowelCnt = 0; // 모음
            int consonantCnt = 0; // 자음
            
            for (char c : resultArr) {
                if (isVowel(c)) vowelCnt++;
                else consonantCnt++;
            }
            
            if (vowelCnt >= 1 && consonantCnt >= 2) {
                System.out.println(new String(resultArr));
            }
            return;
        }
        
        for (int i=start; i<C; i++) {
            resultArr[cnt] = charArr[i];
            comb(cnt+1, i+1); 
        }
    }
    
}