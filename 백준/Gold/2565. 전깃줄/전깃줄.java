import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int input[][] = new int[N+1][2]; // input[i][0]:i번째 전깃줄의 A위치, 
										 // input[i][1]:i번째 전깃줄의 B위치
		for(int i=1; i<=N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			input[i][0] = Integer.parseInt(st.nextToken());
			input[i][1] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(input, (int[] a, int[] b)->{
			return Integer.compare(a[0], b[0]);
		}); //A 기준으로 정렬
		
		int[] dp = new int[N+1]; // i번째 요소를 포함하는 LIS의 최장 길이
		
		for(int i=1; i<=N; i++) {
			dp[i] = 1;
			for(int j=1; j<i; j++) {
				if(input[i][1] > input[j][1])
					dp[i] = Math.max(dp[i], dp[j]+1);
			}
		}
		
		int max = 0;
		for(int i=1; i<=N; i++) {
			max = Math.max(dp[i], max);
		}
		System.out.println(N-max);
 	}
}