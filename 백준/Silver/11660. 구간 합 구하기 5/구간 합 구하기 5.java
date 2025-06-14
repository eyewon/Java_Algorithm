import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[][] table = new int[N+1][N+1];
		int[][] psum = new int[N+1][N+1];
		
		for(int i=1; i<=N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=1; j<=N; j++) {
				table[i][j] = Integer.parseInt(st.nextToken());
				psum[i][j] = psum[i-1][j]+ psum[i][j-1] - psum[i-1][j-1]+ table[i][j];
			}
		}
		
		StringBuilder sb = new StringBuilder();
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			sb.append(psum[x2][y2]-psum[x2][y1-1]-psum[x1-1][y2]+psum[x1-1][y1-1]).append("\n");
		}
		System.out.print(sb);
 	}
}