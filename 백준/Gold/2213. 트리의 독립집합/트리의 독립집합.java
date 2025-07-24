import java.io.*;
import java.util.*;

class Main {
	static List<Integer>[] tree;
	static int[] weight;
	static int[][] dp; // dp[i][0]: i번째 선택했을 떄 최대독립집합
					   // dp[i][1]: i번째 선택하지 않았을 때 최대독립집합
	static List<Integer> list; //선택된 정점 리스트 (역추적용)
	
	
	// DP값 계산 - dfs (리프 -> 루트)
	public static void dfs(int node, int parent) {
		for(int child: tree[node]) {
			if(child != parent) {
				dfs(child, node);
				dp[node][0] += Math.max(dp[child][0], dp[child][1]);
				dp[node][1] += dp[child][0];
			}
		}
		dp[node][1] += weight[node]; //node를 선택한 경우
	}
	
	//역추적 - trace (루트 -> 리프)
	public static void trace(int node, int parent, boolean selected) {
		if(selected) {
			list.add(node);
			
			//node 선택 -> child는 선택 X
			for(int child: tree[node]) {
				if(child != parent) {
					trace(child, node, false);
				}
			} 
		} else {
			// node 선택 X -> 자식은 선택할 수도 안할수도 (더 큰쪽 선택)
			for(int child: tree[node]) {
				if(child != parent) {
					if(dp[child][1] > dp[child][0]) {
						trace(child, node, true);
					}else {
						trace(child, node, false);
					}
				}
			}
		}
		
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		tree = new ArrayList[N+1];
		weight = new int[N+1];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=1; i<=N; i++) {
			tree[i] = new ArrayList<>();
			weight[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i=0; i<N-1; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			tree[u].add(v);
			tree[v].add(u);
		}
		
		StringBuilder sb = new StringBuilder();
		dp = new int[N+1][2];
		dfs(1, -1); // dp배열 채우기
		
		//역추적 
		list = new ArrayList<>();
		if(dp[1][0] > dp[1][1]) {
			sb.append(dp[1][0]).append("\n");
			trace(1, -1, false);
		}else {
			trace(1, -1, true);
			sb.append(dp[1][1]).append("\n");
		}
		Collections.sort(list);
		for(int k: list) sb.append(k).append(" ");
		System.out.println(sb);
	}
}