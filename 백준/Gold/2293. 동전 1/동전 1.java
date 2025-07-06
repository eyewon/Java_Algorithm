import java.io.*;
import java.util.*;

class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int[] coins = new int[N];
		for(int i=0; i<N; i++) {
			coins[i] = Integer.parseInt(br.readLine());
		}
		
		int[] dp = new int[K+1]; //금액 i를 만드는 경우의 수
		dp[0] = 1;
		
		for(int coin: coins) {
			for(int i=coin; i <= K; i++) {
				dp[i] += dp[i-coin];
			}
		}
		
		System.out.println(dp[K]);
	}
}