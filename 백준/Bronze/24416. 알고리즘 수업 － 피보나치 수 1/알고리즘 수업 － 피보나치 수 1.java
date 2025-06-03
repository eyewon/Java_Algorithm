import java.io.*;
import java.util.*;

class Main {
	static int cnt1=0;
	static int cnt2=0;
	
	public static int fib(int n) {
		if(n==1 || n==2) {
			cnt1++;
			return 1;
		}
		else return fib(n-1) + fib(n-2);
	}
	
	public static int fibonacci(int n) {
		int[] dp = new int[n];
		dp[0] = dp[1] = 1;
		for(int i=2; i<n; i++) {
			dp[i] = dp[i-1]+dp[i-2];
			cnt2++;
		}
		return dp[n-1];
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		fib(n);
		fibonacci(n);
		System.out.println(cnt1 + " "+ cnt2);
	}
}