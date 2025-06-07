import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		int[] volume = new int[N+1];
		for(int i=1; i<N+1; i++) {
			volume[i] = Integer.parseInt(st.nextToken());
		}
		
		boolean[][] dp = new boolean[N+1][M+1]; // i번째 곡을 j볼륨으로 연주할 수 있는지
		
		dp[0][S] = true;
		for(int i=1; i<=N; i++) {
			for(int j=0; j<=M; j++) {
				if(dp[i-1][j]) {
					if(j-volume[i] >= 0)
						dp[i][j-volume[i]] = true;
					if(j+volume[i] <=M)
						dp[i][j+volume[i]] = true;
				}
			}
		}
		int max = -1;
		for(int i=0; i<=M; i++) {
			if(dp[N][i])
				max = Math.max(max, i);
		}
		System.out.println(max);
 	}
}