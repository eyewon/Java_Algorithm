import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		char[][] board = new char[N+1][M+1];
		int[][] diffW = new int[N+1][M+1]; //(1,1)부터 (i,j)까지의 "W로 시작하는 체스판 기준에서 잘못된 칸 개수"
		int[][] diffB = new int[N+1][M+1]; //(1,1)부터 (i,j)까지의 "B로 시작하는 체스판 기준에서 잘못된 칸 개수"
		
		for(int i=1; i<=N; i++) {
			String input = br.readLine();
			for(int j=1; j<=M; j++) {
				board[i][j] = input.charAt(j-1);
			}
		}
		
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=M; j++) {
				// 체스판 패턴 비교
				char expectedW = ((i+j)%2==0)? 'W':'B';
				char expectedB = ((i+j)%2==0)? 'B':'W';
				
				diffW[i][j] = diffW[i-1][j] + diffW[i][j-1] - diffW[i-1][j-1] + (board[i][j]==expectedW ? 0: 1);
				diffB[i][j] = diffB[i-1][j] + diffB[i][j-1] - diffB[i-1][j-1] + (board[i][j]==expectedB ? 0: 1);
			}
		}
		int min = Integer.MAX_VALUE;
		for(int i=K; i<=N; i++) {
			for(int j=K; j<=M; j++) {
				int cntW = diffW[i][j] - diffW[i-K][j] - diffW[i][j-K] + diffW[i-K][j-K];
				int cntB = diffB[i][j] - diffB[i-K][j] - diffB[i][j-K] + diffB[i-K][j-K];
				min = Math.min(Math.min(cntW, cntB), min);
			}
		}
		System.out.println(min);
 	}
}