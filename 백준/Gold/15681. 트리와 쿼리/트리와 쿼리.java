import java.io.*;
import java.util.*;

class Main {
	static List<Integer>[] tree;
	static int[] size; // size[i]: i를 루트로 하는 서브트리의 노드 수
	static boolean[] visited;
	
	public static void dfs(int node, int parent) {
		visited[node] = true;
		size[node] = 1;
		
		for(int next: tree[node]) {
			if(!visited[next] && next != parent) {
				dfs(next, node);
				size[node] += size[next];
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		int Q = Integer.parseInt(st.nextToken());
		
		tree = new ArrayList[N+1];
		size = new int[N+1];
		visited = new boolean[N+1];
		for(int i=1; i<=N; i++) tree[i] = new ArrayList<>();
		
		for(int i=0; i<N-1; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			tree[u].add(v);
			tree[v].add(u);
		}
		
		dfs(R, -1);
		
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<Q; i++) {
			int u = Integer.parseInt(br.readLine());
			sb.append(size[u]).append("\n");
		}
		System.out.println(sb);
	}
}