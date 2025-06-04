import java.io.*;
import java.util.*;

class Main {

	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		long[] dp = new long[101];
		dp[1] = dp[2] = dp[3] = 1;
		for(int i=4; i<101; i++) {
			dp[i] = dp[i-3] + dp[i-2];
		}
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0; i<T; i++) {
			int N = Integer.parseInt(br.readLine());
			sb.append(dp[N]).append("\n");
		}
		System.out.print(sb);
 	}
}