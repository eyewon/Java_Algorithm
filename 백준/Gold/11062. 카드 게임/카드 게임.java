import java.io.*;
import java.util.*;

class Main {
	
	public static int[][] cardGame(int[] card, int N) {
		int[][] dp = new int[N+1][N+1]; // dp[i][j]: i번부터 j번까지 구간에서 얻을 수 있는 최대 점수
		
		for(int len = 2; len <= N; len++) {
			for(int i=0; i+len-1 <=N; i++) {
				int j=i+len-1;
				for(int k=i; k<=j; k++) {
					dp[i][j] = Math.max(dp[i][j], dp[i][k]+dp[k][j]+Math.max(card[i], card[j]));
				}
			}
		}
		return dp;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		while(T-- > 0) {
			int N = Integer.parseInt(br.readLine());
			int[] card = new int[N+1];
			int[] psum = new int[N+1];
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i=1; i<=N; i++) {
				card[i] = Integer.parseInt(st.nextToken());
				psum[i] += psum[i-1] + card[i];
			}
			
			int[][] dp = new int[N+1][N+1];
			for(int i=1; i<=N; i++) {
				dp[i][i] = card[i];
			}
			
			for(int len = 2; len <= N; len++) {
				for(int i=1; i+len-1 <= N; i++) {
					int j=i+len-1;  
					dp[i][j] = Math.max(card[i] + psum[j]-psum[i] - dp[i+1][j],
							card[j] + psum[j-1]-psum[i-1] -dp[i][j-1]);
				}
			}
			System.out.println(dp[1][N]);
		}
	}
}