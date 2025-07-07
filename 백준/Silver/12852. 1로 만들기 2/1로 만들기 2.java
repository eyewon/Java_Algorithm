import java.io.*;
import java.util.*;

class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int[] dp = new int[N+1]; // dp[i]: 정수 i를 1로 만들기 위한 최소 연산 수
		int[] prev = new int[N+1];
		
		dp[1] = 0;
		
		for(int i=2; i<=N; i++) {
			dp[i] = dp[i-1] + 1;
			prev[i] = i - 1;
			
			if(i%3 == 0 && dp[i/3]+1 < dp[i]) {
				dp[i] = dp[i/3] + 1;
				prev[i] = i/3;
			}
			if(i%2 == 0 && dp[i/2]+1 < dp[i]) {
				dp[i] = dp[i/2] + 1;
				prev[i] = i/2;
			}
		}
		
		StringBuilder sb = new StringBuilder();
		sb.append(dp[N]).append("\n");

		for(int cur = N; cur > 0; cur=prev[cur]) {
			sb.append(cur).append(" ");
		}
		
		System.out.println(sb);
	}
}