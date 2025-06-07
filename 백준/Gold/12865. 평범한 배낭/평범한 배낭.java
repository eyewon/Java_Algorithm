import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int[] weight = new int[N+1]; // weight[i]: i번째 물건의 무게(W)
		int[] value = new int[N+1];   // value[i]: i번째 물건의 가치(V)
		for(int i=1; i<=N; i++) {
			st = new StringTokenizer(br.readLine());
			weight[i] = Integer.parseInt(st.nextToken());
			value[i] = Integer.parseInt(st.nextToken());
		}
		
		int[][] dp = new int[N+1][K+1]; 
		// dp[i][w]: 최대 무게가 w일 때, i번째 물건까지 고려해서 얻을 수 있는 최대 가치 
		
		
		for(int i=1; i<=N; i++) {
			for(int w=0; w<=K; w++) {
				if(w < weight[i]) { // 무게가 최대무게를 초과하는 경우 (물건을 안넣음)
					dp[i][w] = dp[i-1][w];
				}else { // 물건을 넣을지 말지 선택
					dp[i][w] = Math.max(dp[i-1][w-weight[i]] + value[i], dp[i-1][w]);
				}
			}
		}
		System.out.println(dp[N][K]);
 	}
}