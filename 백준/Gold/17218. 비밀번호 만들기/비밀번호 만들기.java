import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		char[] str1 = br.readLine().toCharArray();
		char[] str2 = br.readLine().toCharArray();
		
		int[][] dp = new int[str1.length+1][str2.length+1];
		
		// DP 테이블 채우기
		for(int i = 1; i <= str1.length; i++) {
			for(int j = 1; j <= str2.length; j++) {
				if(str1[i-1] == str2[j-1]) {
					dp[i][j] = dp[i-1][j-1] + 1;
				} else {
					dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
				}
			}
		}
		
		
		// 문자열 복원
		StringBuilder sb = new StringBuilder();
		
		int i = str1.length;
		int j = str2.length;
		
		while(i > 0 && j > 0) {
			
			if(str1[i-1] == str2[j-1]) {
				sb.append(str1[i-1]);
				i--;
				j--;
			}
			else if(dp[i-1][j] > dp[i][j-1]) {
				i--;
			}
			else {
				j--;
			}
		}
		
		// 뒤집기
		System.out.println(sb.reverse().toString());
	}
}