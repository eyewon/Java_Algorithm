import java.io.*;
import java.util.*;

class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken()); // 활성화된 앱의 수
		int M = Integer.parseInt(st.nextToken()); // 추가 앱(B)의 메모리
		int total = 0; // 총 메모리
		
		int[] memory = new int[N+1]; // memory[i]: i번째 앱의 메모리
		int[] cost = new int[N+1];	 // cost[i]: i번째 앱의 비활성화 비용
				
		StringTokenizer mem = new StringTokenizer(br.readLine());
		StringTokenizer co = new StringTokenizer(br.readLine());
		for(int i=1; i<=N; i++) {
			memory[i] = Integer.parseInt(mem.nextToken());
			cost[i] = Integer.parseInt(co.nextToken());
			total += memory[i];
		}
		
		int[][] dp = new int[N+1][10001]; // dp[i][c]: 최대 비용이 c일 때 i번째 앱까지 고려했을 때 확보 가능한 최대 메모리
		
		for(int i=1; i<=N; i++) {
			for(int c=0; c<=10000; c++) {
				if(c >= cost[i]) {
					dp[i][c] = Math.max(dp[i-1][c], dp[i-1][c-cost[i]] + memory[i]);
				}else
					dp[i][c] = dp[i-1][c];
			}
		}
		for(int c=0; c<=10000; c++) {
			if(dp[N][c] >= M) {
				System.out.println(c);
				return;
			}
		}
	}
}