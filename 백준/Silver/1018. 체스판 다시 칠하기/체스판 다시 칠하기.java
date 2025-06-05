import java.io.*;
import java.util.*;

class Main{
	
	public static int count(char[][] board, int n, int m, char first) {
		int cnt=0;

		for(int i = n; i < n+8; i++) {
			for(int j = m; j < m+8; j++) {
				
				char expected;
				if((i+j)%2 == (n+m)%2) {
					expected=first;
				}else {
					expected = (first == 'W')? 'B': 'W';
				}
				
				if(board[i][j] != expected) {
					cnt++;
				}
			}
		}
		return cnt;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		char[][] board = new char[N][M];
		for(int i=0; i<N; i++) {
			board[i]=br.readLine().toCharArray();
		}
		int min= Integer.MAX_VALUE;
		for(int i=0; i <= N-8; i++) {
			for(int j=0; j <= M-8; j++) {
				int cntW = count(board, i, j, 'W');
				int cntB = count(board, i, j, 'B');
				int cnt = Math.min(cntW, cntB);
				if(cnt < min) min=cnt;
			}
		}
		System.out.println(min);
	}
}