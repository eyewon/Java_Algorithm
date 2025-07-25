import java.io.*;
import java.util.*;

class Main {

	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input;
		StringBuilder sb = new StringBuilder();
		
		int[][][] dp = new int[21][21][21];

		for(int i=0; i<=20 ; i++) {
			for(int j=0; j<=20; j++) {
				for(int k=0; k<=20; k++) {
					if(i==0 || j==0 || k==0)
						dp[i][j][k]=1;
					else if(i<j && j<k)
						dp[i][j][k] = dp[i][j][k-1] + dp[i][j-1][k-1] - dp[i][j-1][k];
					else
						dp[i][j][k] = dp[i-1][j][k] +dp[i-1][j-1][k]+dp[i-1][j][k-1]-dp[i-1][j-1][k-1];
				}
			}
		}
		
		while(!(input=br.readLine()).equals("-1 -1 -1")){
			StringTokenizer st = new StringTokenizer(input);
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			int w;
			if(a <=0 || b<=0 || c<= 0)
				w=1;
			else if(a > 20 || b >20 || c> 20)
				w=dp[20][20][20];
			else
				w=dp[a][b][c];
			sb.append("w("+a+", "+b+", "+c+") = "+w);
			sb.append("\n");
		}
		System.out.print(sb);
	}
}