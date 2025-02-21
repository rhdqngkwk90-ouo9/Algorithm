class Solution {
    public int[] solution(int n) {

        int[] answer = new int[n * (n + 1) / 2]; // 크기: 1-n 까지 합 공식
        int[][] tri = new int[n][n]; // 삼각형
        
        int x = -1; // 아래 이동: x 좌표 감소
        int y = 0; // 오른쪽 이동: y 좌표 증가
        int num = 1; // 채우기
        
        for(int i=0; i<n; i++) {
            for(int j=i; j<n; j++) {
                if(i%3 == 0) { // 아래
                    x++;
                }else if(i%3 == 1) { // 오른쪽
                    y++;
                }else if(i%3 == 2) { // 대각선
                    x--;
                    y--;
                }
                tri[x][y] = num++;
            }
        }

        // 결과 담기
        int index = 0;
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(tri[i][j] == 0) break;
				answer[index++] = tri[i][j];
			}
		}
        
        return answer;
    }
}