import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] cups = new int[N+1];
		int[] dp = new int[N+1]; //dp[i]: i번째 잔을 선택할 경우 최대 양
		
		for(int i=1; i<N+1; i++) {
			cups[i] = Integer.parseInt(br.readLine());
		}
		
		dp[1] = cups[1];
		if(N>1)
			dp[2] = cups[1]+cups[2];
		if(N>2)
			dp[3] = Math.max(Math.max(cups[1]+cups[2], cups[2]+cups[3]),cups[1]+cups[3]);
		
		for(int i=4; i<N+1; i++) {
			dp[i] = Math.max(Math.max(dp[i-2]+cups[i],dp[i-3]+cups[i-1]+cups[i]),
					dp[i-1]);
		}
		System.out.println(dp[N]);
 	}
}