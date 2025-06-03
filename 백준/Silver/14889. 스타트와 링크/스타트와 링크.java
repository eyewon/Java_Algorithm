import java.io.*;
import java.util.*;

class Main {
	static int N;
	static int[][] S;
	static boolean[] visited;
	
	static int min = Integer.MAX_VALUE;
	
	public static void backtracking(int idx, int depth) {
		if(depth == N/2) {
			min = diff();
			return;
		}
		
		for(int i=idx; i<N; i++) {
			if(!visited[i]) {
				visited[i] = true;
				backtracking(i+1, depth+1);
				visited[i] = false;
			}
		}
	}
	
	public static int diff() {
		int start = 0;
		int link = 0;
		
		for(int i=0; i<N-1; i++) {
			for(int j=i+1; j<N; j++) {
				if(visited[i] && visited[j]) {
					start += S[i][j];
					start += S[j][i];
				}
				
				else if(!visited[i] && !visited[j]) {
					link += S[i][j];
					link += S[j][i];
				}
			}
		}
		int val = Math.abs(start-link);
		if(val == 0) {
			System.out.println(val);
			System.exit(0);
		}
		return Math.min(val,min);
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		S = new int[N][N];
		visited = new boolean[N];
		
		for(int i=0; i<N; i++){
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				S[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		backtracking(0,0);
		System.out.println(min);
	}
}