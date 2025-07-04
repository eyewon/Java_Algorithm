import java.io.*;
import java.util.*;

class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int[][] matrix = new int[N+1][2];
		for(int i=1; i<=N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			matrix[i][0] = r;
			matrix[i][1] = c;
		}
		
		int[][] dp = new int[N+1][N+1]; // dp[i][j]: 행렬 i부터 j까지 계산한 최소 곱셈수
		
		for(int len=2; len<=N; len++) {
			for(int i=1; i+len-1<=N; i++) {
				int j = i+len-1;
				dp[i][j] = Integer.MAX_VALUE;
				for(int k=i; k<j; k++) {
					dp[i][j] = Math.min(dp[i][j], dp[i][k]+dp[k+1][j] + matrix[i][0]*matrix[k][1]*matrix[j][1]);
				}
			}
		}
		System.out.println(dp[1][N]);
	}
}