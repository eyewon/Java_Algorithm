import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		int apart[][] = new int[15][15];
		
		for(int i=1; i<15; i++) {
			apart[0][i]=i;
		}
		
		
		for(int i=1; i<15; i++) {
			int sum=0;
			for(int j=1; j<15; j++) {
				sum+=apart[i-1][j];
				apart[i][j]=sum;
			}
		}

		StringBuilder sb = new StringBuilder();
		for(int i=0; i<T; i++) {
			int k = Integer.parseInt(br.readLine());
			int n = Integer.parseInt(br.readLine());
			sb.append(apart[k][n]).append("\n");
		}
		System.out.println(sb);
 	}
}