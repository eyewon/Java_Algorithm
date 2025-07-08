import java.io.*;
import java.util.*;

class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		char[] arr1 = br.readLine().toCharArray();
		char[] arr2 = br.readLine().toCharArray();
		
		int[][] dp = new int[arr1.length+1][arr2.length+1];
		
		for(int i=1; i<=arr1.length; i++) {
			for(int j=1; j<=arr2.length; j++) {
				if(arr1[i-1]==arr2[j-1]) {
					dp[i][j] = dp[i-1][j-1] + 1;
				}else {
					dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);
				}
			}
		}
		
		StringBuilder lcs = new StringBuilder();
		int i=arr1.length, j=arr2.length;
		while(i > 0 && j > 0) {
			if(arr1[i-1] == arr2[j-1]) {
				lcs.append(arr1[i-1]);
				i--; j--;
			}else if(dp[i][j-1] < dp[i-1][j]) {
				i--;
			}else {
				j--;
			}
		}
		System.out.println(dp[arr1.length][arr2.length]);
		System.out.println(lcs.reverse());
	}
}