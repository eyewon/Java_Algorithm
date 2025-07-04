import java.io.*;
import java.util.*;

class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int test_case = 0; test_case<T; test_case++) {
			int K = Integer.parseInt(br.readLine());
			int[] chapter = new int[K+1];
			int[] psum = new int[K+1];
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i=1; i<=K; i++) {
				chapter[i] = Integer.parseInt(st.nextToken());
				psum[i] = psum[i-1]+ chapter[i]; 
			}
			
			int[][] dp = new int[K+1][K+1];
			for(int len=2; len<=K; len++) {
				for(int i=1; i+len-1 <=K; i++) {
					int j= i+len-1;
					dp[i][j] = Integer.MAX_VALUE;
					for(int k=i; k<j; k++) {
						dp[i][j] = Math.min(dp[i][j], dp[i][k]+dp[k+1][j]+psum[j]-psum[i-1]);
					}
				}
			}
			System.out.println(dp[1][K]);
		}
	}
}