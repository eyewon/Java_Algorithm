import java.io.*;
import java.util.*;

class Main{
	static boolean[] visited;
	static int[] result; 
	static int N, M;
	static StringBuilder sb = new StringBuilder();
	
	public static void backtracking(int start, int depth) {
		if(depth==M) {
			for(int i=0; i<M; i++) {
				sb.append(result[i]+" ");
			}
			sb.append("\n");
			return;
		}
		
		for(int i=start; i<=N; i++) {
			if(!visited[i]) {
				visited[i] = true;
				result[depth] = i;
				backtracking(i+1, depth+1);
				visited[i] = false;
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		visited = new boolean[N+1];
		result = new int[M];
		
		backtracking(1, 0);
		
		System.out.println(sb);
	}
}