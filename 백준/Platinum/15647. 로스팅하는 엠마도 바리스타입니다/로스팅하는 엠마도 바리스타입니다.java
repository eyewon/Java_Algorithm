import java.io.*;
import java.util.*;

class Main {
	static int N;
	static List<Node>[] tree;
	static long[] dp; // dp[i]: i번 노드에서 i를 루트로 하는 서브트리에 속한 정점들까지의 거리 합
	static int[] subtreeSize; // i를 루트로 하는 서브트리의 노드 수 
	static long[] ans; // ans[i]: i번 노드에서 모든 정점들의 거리의합 
	
	static class Node{
		int to, weight;
		Node(int to, int weight){
			this.to = to;
			this.weight = weight;
		}
	}
	
	//dp값 계산
	public static void dfs(int node, int parent) {
		// 현재 node의 dp값 계산
		for(Node child: tree[node]) {
			if(child.to != parent) {
				dfs(child.to, node); // 자식 먼저 방문
				
				// 자식에서의 거리 합(do[child].to) + 
				// 그 자식 서브트리에 있는 노드들까지 edge를 하나 더 건너야 하니까 * 거리
				dp[node] += dp[child.to] + subtreeSize[child.to]*child.weight;
				
				// 서브트리 크기도 누적
				subtreeSize[node] += subtreeSize[child.to];
			}
		}
		// 자기 자신 포함
		subtreeSize[node]++;
	}
	//정답 구하기
	public static void dfs2(int node, int parent) {
		for(Node child: tree[node]) {
			if(child.to != parent) {
				//부모의 거리합을 이용해서 자식의 거리합 갱신 
				ans[child.to] = ans[node] + (N - 2*subtreeSize[child.to])*child.weight;
				dfs2(child.to, node);
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		tree = new ArrayList[N+1];
		dp = new long[N+1];
		subtreeSize = new int[N+1];
		ans = new long[N+1];
		
		for(int i=1; i<=N; i++) tree[i] = new ArrayList<>();
		
		for(int i=0; i<N-1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			tree[u].add(new Node(v, d));
			tree[v].add(new Node(u, d));
		}
		
		dfs(1, -1);
		ans[1] = dp[1];
		dfs2(1, -1);
		
		StringBuilder sb = new StringBuilder();
		for(int i=1; i<=N; i++) {
			sb.append(ans[i]).append("\n");
		}
		System.out.println(sb);
	}
}