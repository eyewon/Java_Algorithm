import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] dp = new int[N+1][10];
		
		dp[1][1]= 1;
		dp[1][2]= 1;
		dp[1][3]= 1;
		dp[1][4]= 1;
		dp[1][5]= 1;
		dp[1][6]= 1;
		dp[1][7]= 1;
		dp[1][8]= 1;
		dp[1][9]= 1;
		
		for(int i=2; i<N+1; i++) {
			for(int j=0; j<10; j++) {
				if(j==0)
					dp[i][j] = dp[i-1][j+1];
				else if(j==9)
					dp[i][j] = dp[i-1][j-1];
				else 
					dp[i][j] = ( dp[i-1][j-1] + dp[i-1][j+1] );
				dp[i][j] %= 1000000000;
			}
		}
		int sum = 0;
		for(int n: dp[N])
			sum=(sum+n)%1000000000;

		System.out.println(sum);
 	}
}