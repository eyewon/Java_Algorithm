import java.io.*;
import java.util.*;

class Main {
	static List<Integer>[] tree;
	static int[][] dp; // dp[i][0]: i번째(얼리어답터X), dp[i][1]: i번째(얼리어답터O)
	
	public static void dfs(int node, int parent) {
		
		for(int child: tree[node]) {
			if(child != parent) {
				dfs(child, node);
				
				dp[node][0] += dp[child][1];
				dp[node][1] += Math.min(dp[child][1], dp[child][0]);
			}
		}
		
		dp[node][1] += 1;
	}
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		dp = new int[N+1][2];
		tree = new ArrayList[N+1];
		for(int i=1; i<=N; i++) tree[i] = new ArrayList<>();
		
		
		for(int i=0; i<N-1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			tree[u].add(v);
			tree[v].add(u);
		}
		
		dfs(1, -1);
		System.out.println(Math.min(dp[1][1], dp[1][0]));
	}
}