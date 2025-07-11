import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N+1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=1; i<=N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int dp[] = new int[N+1]; //dp[i]: i번째 요소를 마지막으로 하는 LIS의 길이
		
		int max=0;
		for(int i=1; i<=N; i++) {
			dp[i] = 1;
			for(int j=1; j<i; j++) {
				if(arr[j] < arr[i])
					dp[i] = Math.max(dp[i], dp[j]+1);
			}
			max = max<dp[i]? dp[i]:max;	
		}
		System.out.println(max);
 	}
}