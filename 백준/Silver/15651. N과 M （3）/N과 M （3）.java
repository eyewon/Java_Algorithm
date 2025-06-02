import java.io.*;
import java.util.*;

class Main{
	static int N,M;
	static int[] result;
	static StringBuilder sb = new StringBuilder();
	
	public static void backtracking(int depth) {
		if(depth==M) {
			for(int i=0; i<M; i++) {
				sb.append(result[i] + " ");
			}
			sb.append("\n");
			return;
		}
		
		for(int i=1; i<=N; i++) {
			result[depth]=i;
			backtracking(depth+1);
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		result = new int[M];
		
		backtracking(0);
		System.out.print(sb);
		
	}
}