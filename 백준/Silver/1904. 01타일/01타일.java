import java.io.*;
import java.util.*;

class Main {

	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] dp = new int[1000001];
		dp[1] = 1;
		dp[2] = 2;
		
		for(int i=3; i<dp.length; i++) {
			dp[i] = ( dp[i-1] + dp[i-2] ) %15746;
		}
		
		int N = Integer.parseInt(br.readLine());
		System.out.print(dp[N]);
 	}
}