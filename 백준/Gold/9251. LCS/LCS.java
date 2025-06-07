import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] arr1 = br.readLine().toCharArray();
		char[] arr2 = br.readLine().toCharArray();
		
		int[][] dp = new int[arr1.length+1][arr2.length+1]; // dp[i][j]: arr1의 i번째, arr2의 j번째까지 봤을때 LCS의 길이
		
		for(int i=1; i<arr1.length+1; i++) {
			for(int j=1; j<arr2.length+1; j++) {
				if(arr1[i-1]==arr2[j-1]) dp[i][j] = dp[i-1][j-1]+1;
				else {
					dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
				}
			}
		}
		
		System.out.println(dp[arr1.length][arr2.length]);
 	}
}