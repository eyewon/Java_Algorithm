import java.io.*;
import java.util.*;

class Main {
	static List<Integer>[] tree;
	static int[] people;
	static int[][] dp;
	
	public static void dfs(int node, int parent) {
		
		for(int child: tree[node]) {
			if(child != parent) {
				dfs(child, node);
				
				dp[node][0] += Math.max(dp[child][0], dp[child][1]);
				dp[node][1] += dp[child][0];
			}
		}
		
		dp[node][1] += people[node];
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		tree = new ArrayList[N+1];
		people = new int[N+1]; // 각 마을의 인구수
		dp = new int[N+1][2]; // dp[i][0]: i번 마을이 우수마을이 아닐때 i 서브트리에서의 최댓값
							  // dp[i][1]: i번 마을이 우수마을때 i 서브트리에서의 최대값
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=1; i<=N; i++) {
			people[i] = Integer.parseInt(st.nextToken());
			tree[i] = new ArrayList<>();
		}
		
		for(int i=0; i<N-1; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			tree[u].add(v);
			tree[v].add(u);
		}
		dfs(1, -1);
		System.out.println(Math.max(dp[1][0], dp[1][1]));
	}
}